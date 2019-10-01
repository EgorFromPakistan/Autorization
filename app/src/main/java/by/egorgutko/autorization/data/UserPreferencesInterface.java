package by.egorgutko.autorization.data;

import java.util.ArrayList;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserPreferencesInterface {

    Single<ArrayList> getTaskList();
    Completable putSet(String task);
}
