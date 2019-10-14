package by.egorgutko.autorization.data.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.UUID;

@Entity(tableName = "persontask")
public class Person {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "username")
    private String name;

    @ColumnInfo(name = "textForTask")
    private String text;

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Person(){
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.text = "";
    }

    public Person(String name, String task) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.text = task;
    }


}
