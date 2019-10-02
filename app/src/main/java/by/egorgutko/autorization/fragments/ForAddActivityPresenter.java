package by.egorgutko.autorization.fragments;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> implements ForAddFragmentInterface {
    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
    UserPreferences userPreferences;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public Completable putFunc(Context context, String name) {
        return Completable.fromAction(() -> {
            autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(context);
            userPreferences = new UserPreferences(context);
            userPreferences.setUserTask(name)
                    .subscribeOn(Schedulers.io())
                    .subscribe();
        });

    }
}
