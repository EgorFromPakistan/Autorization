package by.egorgutko.autorization.data.privatePreference

import java.util.ArrayList

import io.reactivex.Completable
import io.reactivex.Single

interface UserPreferencesInterface {

    fun getTaskList(): Single<ArrayList<*>>
    fun setUserTask(task: String): Completable
}
