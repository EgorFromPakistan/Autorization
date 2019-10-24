package by.egorgutko.autorization.data.RoomDB

import io.reactivex.Completable
import io.reactivex.Single

class DateBase(private val taskDao: TaskDao) : DBInterface {

    override fun getTaskList(name: String): Single<List<String>> {
        return Single.fromCallable { taskDao.getPersons(name) }
    }

    override fun setUserTask(task: Person): Completable {
        return Completable.fromAction { taskDao.setTaskOfUSer(task) }
    }
}
