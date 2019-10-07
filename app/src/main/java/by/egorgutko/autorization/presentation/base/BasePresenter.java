package by.egorgutko.autorization.presentation.base;

public abstract class BasePresenter<View> {

    protected View mView;

    public void attachView(View view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }
}
