package by.egorgutko.autorization.fragments;

import android.content.Context;

import java.util.ArrayList;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.Single;

public class ForListFragmentPresenter extends BasePresenter<ForListFragment> implements ForListFragmentInterface  {

    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    UserPreferences userPreferences;

    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public Single<String> getCurrentUserName(Context context) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        return autorizationPreferenceSingleton.getUserName();
    }


    public Single<ArrayList> getSetForList(Context context) {
        userPreferences = new UserPreferences(context);
        return userPreferences.getTaskList();
//        authorizationPreferences.getTaskList(name, arrayList);
    }

}
