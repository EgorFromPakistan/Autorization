package by.egorgutko.autorization.data.RoomDB;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

import by.egorgutko.autorization.data.privatePreference.UserPreferencesInterface;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface TaskDao extends UserPreferencesInterface {
    @Override
    @Insert
    Completable setUserTask(String task);

    @Override
    @Query("SELECT * FROM  persontasks")
    Single<ArrayList> getTaskList();


}
