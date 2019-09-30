package by.egorgutko.autorization.data;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface AutorizationPreferenceInterfece {

    Completable addName(Single name);
    Single<String> getName();
}
