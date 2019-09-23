package by.egorgutko.autorization.fragments;

import android.content.Context;

import by.egorgutko.autorization.data.AuthorizationPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> {
    AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

   public void putFunc(Context context, String name){
       authorizationPreferences.init(context);
       authorizationPreferences.putSet(name);
    }
}
