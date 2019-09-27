package by.egorgutko.autorization.fragments;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface ForListFragmentInterface {

    String getCurrentUserName(Context context);
    ArrayList getSetForList(Context context);

}
