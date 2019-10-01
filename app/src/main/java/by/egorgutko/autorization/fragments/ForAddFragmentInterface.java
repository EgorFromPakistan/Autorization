package by.egorgutko.autorization.fragments;

import android.content.Context;

import io.reactivex.Completable;

public interface ForAddFragmentInterface {
    Completable putFunc(Context context, String name);
}
