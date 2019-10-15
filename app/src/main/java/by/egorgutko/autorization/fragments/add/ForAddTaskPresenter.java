package by.egorgutko.autorization.fragments.add;

import android.content.Context;

import androidx.lifecycle.LifecycleObserver;

import by.egorgutko.autorization.data.RoomDB.App;
import by.egorgutko.autorization.data.RoomDB.DateBase;
import by.egorgutko.autorization.data.RoomDB.Person;
import by.egorgutko.autorization.data.RoomDB.PersonTasksDatabase;
import by.egorgutko.autorization.data.RoomDB.TaskDao;
import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class ForAddTaskPresenter extends BasePresenter<ForAddFragment> implements LifecycleObserver {


    private AutorizationPreference autorizationPreference;
    private CompositeDisposable disposables = new CompositeDisposable();
    private PersonTasksDatabase db = App.getInstance().getDatabase();//получение базы
    private TaskDao taskDao = db.taskDao();//получение дао
    private Person personTasks;// = new Person();
    private DateBase dateBase;


    public void userClickToAddTask(Context context, String task) {
        autorizationPreference = AutorizationPreference.getPreference(context);
        dateBase = new DateBase(taskDao);
        Disposable disposableSingle = autorizationPreference.getUserName()
                .flatMapCompletable(name -> {
                    personTasks = new Person(name, task);
                    return dateBase.setUserTask(personTasks);
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

    public void disposeObserver() {
        disposables.dispose();
    }


}
