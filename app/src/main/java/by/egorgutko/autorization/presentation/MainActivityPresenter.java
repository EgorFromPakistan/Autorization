package by.egorgutko.autorization.presentation;

public class MainActivityPresenter {

    private MainActivity view;

    public void attachView(MainActivity mainActivity){
        view = mainActivity;
    }

    public void detachView(){
        view = null;
    }
}
