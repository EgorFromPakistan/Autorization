package by.egorgutko.autorization.presentation.login

import android.content.Context

import io.reactivex.Completable

interface LoginActivityInterface {
    fun addName(context: Context, name: String): Completable
}
