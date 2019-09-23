package by.egorgutko.autorization.data;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class AuthorizationPreferences {


    private static final String SAVED_TEXT = "saved_text";

    private SharedPreferences settings = null;
    private Editor editor = null;
    private Context context = null;

    public ArrayList<String> mArray;// = new ArrayList<>();
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
        //preferences = getActivity().getSharedPreferences(onLoadName(),MODE_PRIVATE);
        Set<String> set = settings.getStringSet(name, new HashSet<String>());
//        mArray.addAll(set);
        return new ArrayList(set);
    }

    /*public Set getTasks(String name) {
        if (settings == null) {
            settings = context.getSharedPreferences(name, MODE_PRIVATE);
        }
        //preferences = getActivity().getSharedPreferences(onLoadName(),MODE_PRIVATE);
        Set<String> set = settings.getStringSet(name, new HashSet<String>());
//        mArray.addAll(set);
        return set;
    }
     */

    public void putSet(String task) {
        String userName = getUserName();
        if (settings == null) {
            settings = context.getSharedPreferences(userName, MODE_PRIVATE);
        }
        //preferences = getActivity().getSharedPreferences(onLoadNameUser(), MODE_PRIVATE);
        set = settings.getStringSet(userName, new HashSet<String>());
        Editor ed = settings.edit();
        set.add(task);
        ed.putStringSet(userName, set);
        ed.apply();
    }


}
