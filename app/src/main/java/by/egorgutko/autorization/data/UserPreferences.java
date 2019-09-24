package by.egorgutko.autorization.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences {

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private Set<String> setTask;

    private AutorizationPreferenceSingleton autorizationPreferenceSingleton;

    public UserPreferences(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        settings = context.getSharedPreferences(autorizationPreferenceSingleton.getUserName(), MODE_PRIVATE);
        editor = settings.edit();

    }

    public ArrayList getTaskList() {
        Set<String> set = settings.getStringSet(autorizationPreferenceSingleton.getUserName(), new HashSet<String>());
        return new ArrayList(set);
    }

    public void putSet(String task) {
        String userName = autorizationPreferenceSingleton.getUserName();
        setTask = settings.getStringSet(userName, new HashSet<String>());
        setTask.add(task);
        editor.clear();
        editor.putStringSet(userName, setTask);
        editor.apply();
    }
}
