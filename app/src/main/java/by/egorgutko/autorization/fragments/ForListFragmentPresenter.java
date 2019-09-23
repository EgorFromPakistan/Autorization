package by.egorgutko.autorization.fragments;

import android.content.Context;

import java.util.ArrayList;

import by.egorgutko.autorization.data.AuthorizationPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;

public class ForListFragmentPresenter extends BasePresenter<ForListFragment> {

    AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public  String getCurrentUserName(Context context){
        authorizationPreferences.init(context);
       return authorizationPreferences.getUserName();
    }

    public ArrayList  getSetForList(String name){
        return authorizationPreferences.getTaskList(name);
//        authorizationPreferences.getTaskList(name, arrayList);
    }
}
