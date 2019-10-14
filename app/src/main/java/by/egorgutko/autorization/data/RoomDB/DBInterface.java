package by.egorgutko.autorization.data.RoomDB;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DBInterface {

    Single<List<String>> getTaskList(String name);
    Completable setUserTask(Person task);
}
