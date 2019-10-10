package by.egorgutko.autorization.data.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class PersonTasks {

    @PrimaryKey
    private String id;
    private String username;
    private String text;

    public PersonTasks(String name, String task) {
        id = UUID.randomUUID().toString();
        username = name;
        text = task;
    }

}
