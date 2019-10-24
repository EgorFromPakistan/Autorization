package by.egorgutko.autorization.data.defaultPreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.Action

class AutorizationPreference @SuppressLint("CommitPrefEdits")
private constructor(context: Context) : AutorizationPreferenceInterfece {
    private val settings: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        settings = PreferenceManager.getDefaultSharedPreferences(context)
        editor = settings.edit()
    }

    override fun addUserName(name: String): Completable {
        val action = { editor.putString(SAVED_TEXT, name).apply() }
        return Completable.fromAction(action)
    }

    override fun getUserName(): Single<String> {
        return Single.fromCallable { settings.getString(SAVED_TEXT, "") }
    }

    companion object {

        private var ourInstance: AutorizationPreference? = null

        private val SAVED_TEXT = "saved_text"

        fun getPreference(context: Context): AutorizationPreference {
            if (ourInstance == null) ourInstance = AutorizationPreference(context)
            return ourInstance as AutorizationPreference
        }
    }
}