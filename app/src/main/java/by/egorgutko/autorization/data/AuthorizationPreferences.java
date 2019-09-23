package by.egorgutko.autorization.data;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class AuthorizationPreferences {


    private static final String SAVED_TEXT = "saved_text";
    private static final String LOG_CAT = "myLog";

    private SharedPreferences settings = null;
    private Editor editor = null;
    private Context context = null;
    private Set<String> set;

    public void init(Context cntxt) {
        context = cntxt;
    }

    public void addNameOfUser(String name) {
        if (settings == null) {
            settings = PreferenceManager.getDefaultSharedPreferences(context);
            editor = settings.edit();
        }
        editor.putString(SAVED_TEXT, name);
        editor.apply();
    }

    public String getUserName() {
        if (settings == null) {
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return settings.getString(SAVED_TEXT, "");
    }

    public ArrayList getTaskList(String name) {
        if (settings == null) {
            settings = context.getSharedPreferences(name, MODE_PRIVATE);
        }
        Set<String> set = settings.getStringSet(name, new HashSet<String>());
        Log.d(LOG_CAT, "set = " + " " + set);
        return new ArrayList(set);
    }


    public void putSet(String task) {
        String userName = getUserName();
        if (settings == null) {
            settings = context.getSharedPreferences(userName, MODE_PRIVATE);
        }
        //preferences = getActivity().getSharedPreferences(onLoadNameUser(), MODE_PRIVATE);
        set = settings.getStringSet(userName, new HashSet<String>());
        Editor ed = settings.edit();
        Set<String> doubleSet = new HashSet<>(set);
        doubleSet.add(task);
        ed.putStringSet(userName, doubleSet);
        ed.apply();
        Log.d(LOG_CAT, "doubleSet_after_put = " + " " + doubleSet);
        Log.d(LOG_CAT, "set_after_put = " + " " + set);
        Log.d(LOG_CAT, "size = " + " " + Integer.toString(set.size()));
    }


}
