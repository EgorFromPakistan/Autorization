package by.egorgutko.autorization.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class UserPreferences {

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    private Set<String> set;

    private AutorizationPreferenceSingleton autorizationPreferenceSingleton;

    public UserPreferences(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreserence(context);
        settings = context.getSharedPreferences(autorizationPreferenceSingleton.getUserName(), MODE_PRIVATE);
        editor = settings.edit();

    }

    public ArrayList getTaskList() {
        Set<String> set = settings.getStringSet(autorizationPreferenceSingleton.getUserName(), new HashSet<String>());
        return new ArrayList(set);
    }

    public void putSet(String task) {
        String userName = autorizationPreferenceSingleton.getUserName();
        set = settings.getStringSet(userName, new HashSet<String>());
        SharedPreferences.Editor ed = settings.edit();
        Set<String> doubleSet = new HashSet<>(set);
        doubleSet.add(task);
        ed.putStringSet(userName, doubleSet);
       // set.add(task);
       // ed.putStringSet(userName, set);
       ed.apply();
    }
}
