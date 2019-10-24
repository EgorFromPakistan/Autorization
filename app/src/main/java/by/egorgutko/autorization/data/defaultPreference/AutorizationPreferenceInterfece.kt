package by.egorgutko.autorization.data.defaultPreference

import io.reactivex.Completable
import io.reactivex.Single

interface AutorizationPreferenceInterfece {
    //val userName: Single<String>
    fun getUserName(): Single<String>
    fun addUserName(name: String): Completable
}
