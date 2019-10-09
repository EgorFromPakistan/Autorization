package by.egorgutko.autorization.fragments.list;

import android.content.Context;

import java.util.List;
import java.util.concurrent.Callable;

import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.data.privatePreference.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForListFragmentPresenter extends BasePresenter<ForListView> {

    private AutorizationPreference autorizationPreference;
    private UserPreferences userPreferences;


    /*public void init(Context context) {
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

     */

    Single<List> myObserver(){
        return  new Single<List>() {
            @Override
            protected void subscribeActual(SingleObserver<? super List> observer) {

            }
        };
    };
    public void init(Context context) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        autorizationPreference.getUserName()
                .flatMap(name -> {
                    mView.showUserName(name);
                    userPreferences = new UserPreferences(context, name);
                    return userPreferences.getTaskList();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list ->
                mView.showUserData(list),Throwable::printStackTrace);
    }


}
