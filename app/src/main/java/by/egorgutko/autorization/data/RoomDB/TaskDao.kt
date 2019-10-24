package by.egorgutko.autorization.data.RoomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    fun setTaskOfUSer(task: Person)

    @Query("SELECT textForTask  FROM  persontask WHERE username = :name")
    fun getPersons(name: String): List<String>


}
