package by.egorgutko.autorization.fragments;

import android.content.Context;

import java.util.ArrayList;

public interface ForListFragmentInterface {

    String getCurrentUserName(Context context);
    void  getSetForList(String name, ArrayList arrayList);

}
