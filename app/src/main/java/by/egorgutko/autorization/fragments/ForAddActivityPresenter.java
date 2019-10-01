package by.egorgutko.autorization.fragments;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.Completable;
import io.reactivex.functions.Action;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> implements ForAddFragmentInterface {
    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    UserPreferences userPreferences;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public Completable putFunc(Context context, String name) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
                userPreferences = new UserPreferences(context);
                userPreferences.putSet(name).subscribe();
            }
        });

    }
}
