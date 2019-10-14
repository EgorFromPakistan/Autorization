package by.egorgutko.autorization.data.RoomDB;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DBInterface {

    Single<List<PersonTasks>> getTaskList(String name);
    Completable setUserTask(PersonTasks task);
}
