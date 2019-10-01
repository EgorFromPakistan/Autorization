package by.egorgutko.autorization.fragments;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> implements ForAddFragmentInterface {
    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    UserPreferences userPreferences;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public void putFunc(Context context, String name) {
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        userPreferences = new UserPreferences(context);
        userPreferences.putSet(name).subscribe();
    }
}
