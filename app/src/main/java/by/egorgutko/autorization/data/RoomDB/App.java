package by.egorgutko.autorization.data.RoomDB;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {

    public static App instance;

    private PersonTasksDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, PersonTasksDatabase.class, "persontask")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public PersonTasksDatabase getDatabase() {
        return database;
    }
}
