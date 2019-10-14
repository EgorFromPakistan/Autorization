package by.egorgutko.autorization.fragments.list;

import android.content.Context;

import java.util.ArrayList;

import by.egorgutko.autorization.data.RoomDB.App;
import by.egorgutko.autorization.data.RoomDB.DateBase;
import by.egorgutko.autorization.data.RoomDB.Person;
import by.egorgutko.autorization.data.RoomDB.PersonTasksDatabase;
import by.egorgutko.autorization.data.RoomDB.TaskDao;
import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference;
import by.egorgutko.autorization.data.privatePreference.UserPreferencesInterface;
import by.egorgutko.autorization.presentation.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForListFragmentPresenter extends BasePresenter<ForListView> {

    private AutorizationPreference autorizationPreference;
    private UserPreferencesInterface userPreferences;
    private CompositeDisposable disposables = new CompositeDisposable();
    PersonTasksDatabase db = App.getInstance().getDatabase();//получение базы
    private TaskDao taskDao = db.taskDao();//получение дао
    private DateBase dateBase;

    public void init(Context context) {
        disposables = new CompositeDisposable();
        dateBase = new DateBase(taskDao);
        autorizationPreference = AutorizationPreference.getPreference(context);
        Disposable myDisposableSingle = autorizationPreference.getUserName()
                .flatMap(name -> {
                    mView.showUserName(name);
                    //personTasks = new Person(name);
                    return dateBase.getTaskList(name);
                })
                .map(personTasks -> {
                    ArrayList<String> tasks = new ArrayList<>();
                    for (Person s : personTasks) {
                        tasks.add(s.getText());
                    }
                    return tasks;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(task -> mView.showUserData(task), throwable -> throwable.printStackTrace());
//                        new DisposableSingleObserver<java.util.List<Person>>() {
//                    @Override
//                    public void onSuccess(List<Person> personTasks) {
//                        ArrayList<String> tasks = new ArrayList<>();
//                        for (Person s : personTasks) {
//                            tasks.add(s.getText());
//                        }
//                        mView.showUserData(tasks);
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//                });
                /*.subscribe((arrayList, throwable) -> {
                    if (throwable != null) {
                        throwable.printStackTrace();
                    } else {
                        ArrayList<String> tasks = new ArrayList<>();
                        for (Person s : arrayList) {
                            tasks.add(s.getText());
                        }
                        mView.showUserData(tasks);
                    }
                });

                 */
        disposables.add(myDisposableSingle);
    }

    public void disposeObserver() {
        disposables.dispose();
    }


}
