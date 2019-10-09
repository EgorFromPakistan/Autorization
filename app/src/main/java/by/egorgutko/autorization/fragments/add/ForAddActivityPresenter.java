package by.egorgutko.autorization.fragments.add;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.data.privatePreference.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ForAddActivityPresenter extends BasePresenter<ForAddFragment> implements LifecycleObserver {
    private AutorizationPreference autorizationPreference;
    private UserPreferences userPreferences;
    private CompositeDisposable disposables = new CompositeDisposable();
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
        Disposable disposableSingle = autorizationPreference.getUserName()
                .flatMapCompletable(name -> {
                    userPreferences = new UserPreferences(context, name);
                    return userPreferences.setUserTask(task);
                })
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
        disposables.add(disposableSingle);
    }
    public void disposeObserver(){
        disposables.dispose();
    }


}
