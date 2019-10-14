package by.egorgutko.autorization.data.RoomDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao  {

    @Insert
    void setTaskOfUSer(Person task);

    @Query("SELECT * FROM  persontask WHERE username = :name")
    List<Person> getPersons(String name);



}
