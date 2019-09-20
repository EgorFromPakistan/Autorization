package by.egorgutko.autorization.presentation.login;

import android.content.Context;

import by.egorgutko.autorization.data.AuthorizationPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import by.egorgutko.autorization.presentation.login.LoginActivity;

public class LoginPresenter extends BasePresenter<LoginActivity> {

    AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public void addName(Context context, String key, String name){
        authorizationPreferences.init(context);
        authorizationPreferences.addNameOfUser(name);
    }


}
