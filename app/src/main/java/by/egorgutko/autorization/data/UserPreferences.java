package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences {

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private Set<String> setTask;

    private AutorizationPreferenceSingleton autorizationPreferenceSingleton;

    public UserPreferences(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        settings = context.getSharedPreferences(String.valueOf(autorizationPreferenceSingleton.getUserName()), MODE_PRIVATE);
        editor = settings.edit();

    }

    public Single<ArrayList> getTaskList()
    {
        Set<String> set = settings.getStringSet(String.valueOf(autorizationPreferenceSingleton.getUserName()), new HashSet<String>());
        return Single.just( new ArrayList(set));
    }


      @SuppressLint("CheckResult")
      public Completable putSet(String task) {
        return Completable.complete().doOnComplete(() -> {
            autorizationPreferenceSingleton.getUserName().subscribe(sName -> {
                setTask = settings.getStringSet(sName, new HashSet<>());
                setTask.add(task);
                editor.clear();
                editor.putStringSet(sName, setTask);
                editor.apply();
            });
        });
    }
}
