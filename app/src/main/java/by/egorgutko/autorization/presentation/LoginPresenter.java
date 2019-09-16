package by.egorgutko.autorization.presentation;

public class LoginPresenter {

    private LoginActivity view;

    public void attachView(LoginActivity loginActivity) {
        view = loginActivity;
    }

    public void detachView() {
        view = null;
    }
}
