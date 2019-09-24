package by.egorgutko.autorization.fragments;

import android.content.Context;

import java.util.ArrayList;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;

public class ForListFragmentPresenter extends BasePresenter<ForListFragment> {

    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    UserPreferences userPreferences;

    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public String getCurrentUserName(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreserence(context);
        return autorizationPreferenceSingleton.getUserName();
    }

    public ArrayList getSetForList(Context context) {
        userPreferences = new UserPreferences(context);
        return userPreferences.getTaskList();
//        authorizationPreferences.getTaskList(name, arrayList);
    }
}
