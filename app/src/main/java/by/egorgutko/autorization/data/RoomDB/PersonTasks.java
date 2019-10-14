package by.egorgutko.autorization.data.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "persontask")
public class PersonTasks {

    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name = "username")
    public String name;

    @ColumnInfo(name = "textForTask")
    public String text;


    public PersonTasks(){
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.text = "";
    }

    public PersonTasks(String name, String task) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.text = task;
    }

    public String getText() {
        return text;
    }
}
