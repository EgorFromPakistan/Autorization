package by.egorgutko.autorization.presentation.login

import android.content.Context

import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference
import by.egorgutko.autorization.presentation.base.BasePresenter
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class LoginPresenter : BasePresenter<LoginActivity>(), LoginActivityInterface {

    private lateinit var autorizationPreferenceSingleton: AutorizationPreference

    override fun addName(context: Context, name: String): Completable {
        return Completable.fromAction {
            autorizationPreferenceSingleton = AutorizationPreference.getPreference(context)
            autorizationPreferenceSingleton.addUserName(name)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
        }

    }


}
