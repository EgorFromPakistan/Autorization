package by.egorgutko.autorization.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

public class AutorizationPreferenceSingleton {

    private static AutorizationPreferenceSingleton ourInstance;

    private static final String SAVED_TEXT = "saved_text";
    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;

    public static AutorizationPreferenceSingleton getPreserence(Context context) {
        if (ourInstance == null) ourInstance = new AutorizationPreferenceSingleton(context);
        return ourInstance;
    }

    private AutorizationPreferenceSingleton(Context context) {
            settings = PreferenceManager.getDefaultSharedPreferences(context);
            editor = settings.edit();
    }

    public void addNameOfUser(String name) {
        ourInstance.editor.putString(SAVED_TEXT, name);
        ourInstance.editor.apply();
       // editor.putString(SAVED_TEXT, name);
       // editor.apply();
    }

    public String getUserName() {
        return ourInstance.settings.getString(SAVED_TEXT, "");
    }
}
