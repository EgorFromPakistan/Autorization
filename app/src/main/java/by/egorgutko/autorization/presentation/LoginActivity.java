package by.egorgutko.autorization.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import by.egorgutko.autorization.R;

public class LoginActivity extends AppCompatActivity {

    LoginPresenter loginPresenter = new LoginPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // loginPresenter.attachView(this);
    }
}
