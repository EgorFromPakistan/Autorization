package by.egorgutko.autorization.presentation.login;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.presentation.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginActivity> {

    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public void addName(Context context, String name){
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        autorizationPreferenceSingleton.addUserName(name);
    }


}
