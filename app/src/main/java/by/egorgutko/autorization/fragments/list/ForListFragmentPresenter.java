package by.egorgutko.autorization.fragments.list;

import android.content.Context;

import javax.inject.Inject;

import by.egorgutko.autorization.data.RoomDB.App;
import by.egorgutko.autorization.data.RoomDB.DateBase;
import by.egorgutko.autorization.data.RoomDB.PersonTasksDatabase;
import by.egorgutko.autorization.data.RoomDB.TaskDao;
import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForListFragmentPresenter extends BasePresenter<ForListView> {


    private AutorizationPreference autorizationPreference;
    private CompositeDisposable disposables = new CompositeDisposable();
    PersonTasksDatabase db = App.getInstance().getDatabase();//получение базы
    private TaskDao taskDao = db.taskDao();//получение дао
    private DateBase dateBase;

    public void showTaskList(Context context) {
        disposables = new CompositeDisposable();
        dateBase = new DateBase(taskDao);
        autorizationPreference = AutorizationPreference.getPreference(context);
        Disposable myDisposableSingle = autorizationPreference.getUserName()
                .flatMap(name -> {
                    mView.showUserName(name);
                    return dateBase.getTaskList(name);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(task -> mView.showUserData(task), throwable -> throwable.printStackTrace());
        disposables.add(myDisposableSingle);
    }

    public void disposeObserver() {
        disposables.dispose();
    }


}
