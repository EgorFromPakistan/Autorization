package by.egorgutko.autorization.data;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface AutorizationPreferenceInterfece {
    Completable addUserName(String name);
    Single<String> getUserName();
}
