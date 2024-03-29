package by.egorgutko.autorization.data.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class PersonTasksDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
