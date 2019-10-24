package by.egorgutko.autorization.data.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.UUID

@Entity(tableName = "persontask")
class Person {

    @PrimaryKey
    var id: String

    @ColumnInfo(name = "username")
    var name: String? = null

    @ColumnInfo(name = "textForTask")
    var text: String? = null

    constructor() {
        this.id = UUID.randomUUID().toString()
        this.name = ""
        this.text = ""
    }

    constructor(name: String, task: String) {
        this.id = UUID.randomUUID().toString()
        this.name = name
        this.text = task
    }


}
