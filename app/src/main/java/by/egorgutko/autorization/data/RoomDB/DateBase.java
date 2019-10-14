package by.egorgutko.autorization.data.RoomDB;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DateBase implements DBInterface  {

    private TaskDao taskDao;

    public DateBase(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Single<List<PersonTasks>> getTaskList(String name) {
        return Single.fromCallable(()-> taskDao.getTaskList(name));
    }

    @Override
    public Completable setUserTask(PersonTasks task) {
        return Completable.fromAction(()-> taskDao.setTaskOfUSer(task));
    }
}
