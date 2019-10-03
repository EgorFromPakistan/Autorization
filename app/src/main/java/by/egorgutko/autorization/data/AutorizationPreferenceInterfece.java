package by.egorgutko.autorization.data;

import android.content.Context;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface AutorizationPreferenceInterfece {
    Completable addUserName(String name);
    Single<String> getUserName();
}
