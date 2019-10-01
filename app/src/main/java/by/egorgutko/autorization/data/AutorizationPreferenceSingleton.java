package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Objects;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.functions.Action;

public class AutorizationPreferenceSingleton {

    private static AutorizationPreferenceSingleton ourInstance;

    private static final String SAVED_TEXT = "saved_text";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public static AutorizationPreferenceSingleton getPreference(Context context) {
        if (ourInstance == null) ourInstance = new AutorizationPreferenceSingleton(context);
        return ourInstance;
    }

    @SuppressLint("CommitPrefEdits")
    private AutorizationPreferenceSingleton(Context context) {
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        editor = settings.edit();
    }

    public Completable addUserName(String name) {
        return Completable.complete().doOnComplete(() -> {
            ourInstance.editor.putString(SAVED_TEXT, name);
            ourInstance.editor.apply();
        });
    }


    public Single<String> getUserName() {
        return Single.just(Objects.requireNonNull(ourInstance.settings.getString(SAVED_TEXT, "")));
    }
}