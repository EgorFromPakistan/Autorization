package by.egorgutko.autorization.fragments.list;

import android.content.Context;

import by.egorgutko.autorization.data.AutorizationPreference;
import by.egorgutko.autorization.data.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.schedulers.Schedulers;

public class ForListFragmentPresenter extends BasePresenter<ForListView> {

    private AutorizationPreference autorizationPreference;
    private UserPreferences userPreferences;


    public void init(Context context) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        autorizationPreference.getUserName()
                .subscribe(name -> {
                    mView.showUserName(name);
                    userPreferences = new UserPreferences(context, name);
                    userPreferences.getTaskList()
                            .subscribe(list -> {
                                mView.showUserData(list);
                            });
                });
    }


}
