package by.egorgutko.autorization.presentation.base;

public abstract class BasePresenter<TypeOfActivity> {

    TypeOfActivity mActivity;

    public void attachView(TypeOfActivity typeOfActivity) {
        mActivity = typeOfActivity;
    }

    public void detachView() {
        mActivity = null;
    }
}
