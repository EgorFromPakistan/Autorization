package by.egorgutko.autorization.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
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


      public Completable putSet(String task) {
        return new Completable() {
            @Override
            protected void subscribeActual(CompletableObserver s) {
                Single<String> userName = (Single<String>) autorizationPreferenceSingleton.getUserName().subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String sName) throws Exception {
                        setTask = settings.getStringSet(sName, new HashSet<String>());
                        setTask.add(task);
                        editor.clear();
                        editor.putStringSet(sName, setTask);
                        editor.apply();
                    }
                });

            }
        };
    }
}
