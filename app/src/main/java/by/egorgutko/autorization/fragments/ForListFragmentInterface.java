package by.egorgutko.autorization.fragments;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.Single;

public interface ForListFragmentInterface {

    Single<String> getCurrentUserName(Context context);
    Single<ArrayList> getSetForList(Context context);

}
