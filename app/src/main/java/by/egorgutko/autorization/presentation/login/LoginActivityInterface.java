package by.egorgutko.autorization.presentation.login;

import android.content.Context;

import io.reactivex.Completable;

public interface LoginActivityInterface {
    Completable addName(Context context, String name);
}
