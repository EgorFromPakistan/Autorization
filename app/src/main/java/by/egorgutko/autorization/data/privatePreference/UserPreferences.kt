package by.egorgutko.autorization.data.privatePreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

import java.util.ArrayList
import java.util.HashSet

import io.reactivex.Completable
import io.reactivex.Single

import android.content.Context.MODE_PRIVATE

class UserPreferences @SuppressLint("CheckResult")
constructor(context: Context, name: String) : UserPreferencesInterface {

    private val KEY_SET = "KEY_SET"

    private var settings: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        settings = context.getSharedPreferences(name, MODE_PRIVATE)
        editor = settings!!.edit()
    }


    override fun getTaskList(): Single<ArrayList<*>> {
        return Single.fromCallable {
            val set = settings!!.getStringSet(KEY_SET, HashSet())
            ArrayList(set!!)
        }
    }


    override fun setUserTask(task: String): Completable {
        return Completable.fromAction {
            val setTask = settings!!.getStringSet(KEY_SET, HashSet())
            setTask!!.add(task)
            editor!!.clear()
            editor!!.putStringSet(KEY_SET, setTask).apply()
        }
    }

}
