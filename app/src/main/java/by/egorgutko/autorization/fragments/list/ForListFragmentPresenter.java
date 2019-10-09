package by.egorgutko.autorization.fragments.list;

import android.content.Context;

import java.util.List;

import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.data.privatePreference.UserPreferences;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ForListFragmentPresenter extends BasePresenter<ForListView> {

    private AutorizationPreference autorizationPreference;
    private UserPreferences userPreferences;
    private CompositeDisposable disposables = new CompositeDisposable();

    public void init(Context context) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        Disposable myDisposableSingle = autorizationPreference.getUserName()
                .flatMap(name -> {
                    mView.showUserName(name);
                    userPreferences = new UserPreferences(context, name);
                    return userPreferences.getTaskList();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List>() {
                    @Override
                    public void onSuccess(List list) {
                        mView.showUserData(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
        disposables.add(myDisposableSingle);
    }

    public void disposeObserver() {
        disposables.dispose();
    }


}
