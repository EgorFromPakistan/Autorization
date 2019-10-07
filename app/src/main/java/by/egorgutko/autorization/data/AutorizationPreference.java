package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;

public class AutorizationPreference implements AutorizationPreferenceInterfece {

    private static AutorizationPreference ourInstance;

    private static final String SAVED_TEXT = "saved_text";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public static AutorizationPreference getPreference(Context context) {
        if (ourInstance == null) ourInstance = new AutorizationPreference(context);
        return ourInstance;
    }

    @SuppressLint("CommitPrefEdits")
    private AutorizationPreference(Context context) {
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        editor = settings.edit();
    }

    @Override
    public Completable addUserName(String name) {
        Action action = () -> editor.putString(SAVED_TEXT, name).apply();
        return Completable.fromAction(action);
    }

    @Override
    public Single<String> getUserName() {
        return Single.fromCallable(()->{
            return settings.getString(SAVED_TEXT, "");
        });
    }
}