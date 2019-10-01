package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

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
    private String curName;

    private AutorizationPreferenceSingleton autorizationPreferenceSingleton;

    @SuppressLint("CheckResult")
    public UserPreferences(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        autorizationPreferenceSingleton.getUserName().subscribe(sCurName->curName = sCurName);
        settings = context.getSharedPreferences(curName, MODE_PRIVATE);
        editor = settings.edit();

    }

    @Override
    public Single<ArrayList> getTaskList() {
        autorizationPreferenceSingleton.getUserName().subscribe(sCurName->curName = sCurName);
        Set<String> set = settings.getStringSet(curName, new HashSet<String>());
        return Single.just(new ArrayList(set));
    }

    public Completable putSet(String task) {
        return Completable.fromAction(() -> autorizationPreferenceSingleton.getUserName().subscribe(sName -> {
            setTask = settings.getStringSet(sName, new HashSet<>());
            setTask.add(task);
            editor.clear();
            editor.putStringSet(sName, setTask).apply();
        }));
    }
}
