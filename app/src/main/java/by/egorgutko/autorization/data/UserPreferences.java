package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;

import io.reactivex.Completable;
import io.reactivex.Single;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences implements UserPreferencesInterface {

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private String curName;

    private AutorizationPreferenceSingleton autorizationPreferenceSingleton;

    @SuppressLint("CheckResult")
    public UserPreferences(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        autorizationPreferenceSingleton.getUserName().subscribe(sCurName -> {
            settings = context.getSharedPreferences(sCurName, MODE_PRIVATE);
            editor = settings.edit();
        });

    }

    /*@Override
    public Single<ArrayList> getTaskList() {
        autorizationPreferenceSingleton.getUserName().subscribe(sCurName -> curName = sCurName);
        Set<String> set = settings.getStringSet(curName, new HashSet<String>());
        return Single.just(new ArrayList(set));
    }

     */

    @SuppressLint("CheckResult")
    @Override
    public Single<ArrayList> getTaskList() {
        autorizationPreferenceSingleton.getUserName().flatMapCompletable(sCurName -> {
            curName = sCurName;
            return Completable.complete();
        });
        return Single.just(new ArrayList(settings.getStringSet(curName, new HashSet<String>())));
    }


    public Completable setUserTask(String task) {
        return autorizationPreferenceSingleton.getUserName()
                .flatMapCompletable(sName -> {
                    settings.getStringSet(sName, new HashSet<>()).add(task);
                    editor.clear();
                    editor.putStringSet(sName, settings.getStringSet(sName, new HashSet<>())).apply();
                    return Completable.complete();
                }
               );
    }

}
