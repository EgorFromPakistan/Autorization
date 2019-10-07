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

    private final String KEY_SET = "KEY_SET";

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;

    @SuppressLint("CheckResult")
    public UserPreferences(Context context, String name) {
        settings = context.getSharedPreferences(name, MODE_PRIVATE);
        editor = settings.edit();
    }


    public Single<ArrayList> getTaskList() {
        return Single.fromCallable(() -> {
            Set<String> set = settings.getStringSet(KEY_SET, new HashSet<String>());
            Log.d("myLog", String.valueOf(set.size()));
            return new ArrayList(set);
        });
    }


    public Completable setUserTask(String task) {
        return Completable.fromAction(() -> {
            Set<String> setTask = settings.getStringSet(KEY_SET, new HashSet<>());
            setTask.add(task);
            Log.d("myLog", "task = " + task);
            Log.d("myLog", "size= " + setTask.size());
            editor.clear();
            editor.putStringSet(KEY_SET, setTask).apply();
        });
    }

}
