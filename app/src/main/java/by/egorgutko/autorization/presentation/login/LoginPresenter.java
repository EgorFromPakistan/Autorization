package by.egorgutko.autorization.presentation.login;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.presentation.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginActivityInterface {

    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public void addName(Context context, String name){
        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
        autorizationPreferenceSingleton.addUserName(name).subscribe();
    }


}
