package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import io.reactivex.Completable;
import io.reactivex.Single;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences implements UserPreferencesInterface {

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private Set<String> setTask;

    private AutorizationPreferenceSingleton autorizationPreferenceSingleton;

    @SuppressLint("CheckResult")
    public UserPreferences(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        autorizationPreferenceSingleton.getUserName().subscribe(sCurName -> {
            settings = context.getSharedPreferences(sCurName, MODE_PRIVATE);
            editor = settings.edit();
        });

    }


    public Single<ArrayList> getTaskList() {
        return autorizationPreferenceSingleton.getUserName()
                .map(name -> {
                    Set<String> set = settings.getStringSet(name, new HashSet<String>());
                    Log.d("myLog", String.valueOf(set.size()));
                    return new ArrayList(set);
                });
    }


    public Completable setUserTask(String task) {
        return autorizationPreferenceSingleton.getUserName()
                .flatMapCompletable(sName -> {
                            setTask = settings.getStringSet(sName, new HashSet<>());
                            setTask.add(task);
                            Log.d("myLog", "task = " + task);
                            Log.d("myLog", "size= " + String.valueOf(settings.getStringSet(sName, new HashSet<>()).size()));
                            editor.clear();
                            editor.putStringSet(sName, setTask).apply();
                            return Completable.complete();
                        }
                );
    }

}
