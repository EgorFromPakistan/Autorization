package by.egorgutko.autorization.data.RoomDB;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {

    private static  App instance;

    private PersonTasksDatabase database;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, PersonTasksDatabase.class, "database")
                .build();
    }

    public static  App getInstance(){
        return instance;
    }

    private PersonTasksDatabase getDatabase(){
        return database;
    }
}
