package by.egorgutko.autorization.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import io.reactivex.Observable;

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

    public void addNameOfUser(String name) {
        ourInstance.editor.putString(SAVED_TEXT, name);
        ourInstance.editor.apply();
    }

    public String getUserName() {
        return ourInstance.settings.getString(SAVED_TEXT, "");
    }
}
