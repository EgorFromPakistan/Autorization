package by.egorgutko.autorization.fragments.add;

import android.content.Context;

import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.data.privatePreference.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.schedulers.Schedulers;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> {
    private AutorizationPreference autorizationPreference;
    private UserPreferences userPreferences;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    /*public void init(Context context, String task) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        autorizationPreference.getUserName().
                subscribe(name -> {
            userPreferences = new UserPreferences(context, name);
            userPreferences.setUserTask(task).subscribe();

        });
    }

     */

    public void init(Context context, String task) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        autorizationPreference.getUserName()
                .flatMapCompletable(name -> {
                    userPreferences = new UserPreferences(context, name);
                    return userPreferences.setUserTask(task);
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

}
