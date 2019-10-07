package by.egorgutko.autorization.fragments.add;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreference;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> {
    private AutorizationPreference autorizationPreference;
    private UserPreferences userPreferences;
    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public void init(Context context, String task) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        autorizationPreference.getUserName().subscribe(name -> {
            userPreferences = new UserPreferences(context, name);
            userPreferences.setUserTask(task).subscribe();

        });
    }
   /* public Completable putFunc(Context context, String name) {
        return Completable.fromAction(() -> {
            autorizationPreference = AutorizationPreference.getPreference(context);
            userPreferences = new UserPreferences(context, name);
            userPreferences.setUserTask(name)
                    .subscribeOn(Schedulers.io())
                    .subscribe();
        });

    }

    */
}
