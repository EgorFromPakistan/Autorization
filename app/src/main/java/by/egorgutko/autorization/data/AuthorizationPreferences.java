package by.egorgutko.autorization.data;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class AuthorizationPreferences {



    public static final String SAVED_TEXT = "saved_text";

    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public static ArrayList<String> mArray;// = new ArrayList<>();
    public static Set<String> set;

    public static void init( Context cntxt ){
        context = cntxt;
    }

    private static void init(){
        settings = context.getSharedPreferences(SAVED_TEXT, Context.MODE_PRIVATE);
        editor = settings.edit();
    }



    public static void addNameOfUser( String name, String value ){
        if( settings == null ){
            settings = PreferenceManager.getDefaultSharedPreferences(context);
            editor = settings.edit();
        }
        editor.putString(name,value);
        editor.apply();
    }

    public static String getUserName(){
        if( settings == null ){
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return settings.getString( SAVED_TEXT, "" );
    }

    public static void getSet(String name, ArrayList mArray){
        if( settings == null ){
            settings = context.getSharedPreferences(name,MODE_PRIVATE);
        }
        //preferences = getActivity().getSharedPreferences(onLoadName(),MODE_PRIVATE);
        Set<String> set = settings.getStringSet(name,new HashSet<String>());
        for(String r : set) {
            mArray.add(r);
        };
    }

    public static void putSet(String name, String task) {
        if( settings == null ){
            settings = context.getSharedPreferences(name,MODE_PRIVATE);
        }
        //preferences = getActivity().getSharedPreferences(onLoadNameUser(), MODE_PRIVATE);
        set= settings.getStringSet(name, new HashSet<String>());
        SharedPreferences.Editor ed = settings.edit();
        set.add(task);
        ed.putStringSet(name, set);
        ed.commit();
    }


}
