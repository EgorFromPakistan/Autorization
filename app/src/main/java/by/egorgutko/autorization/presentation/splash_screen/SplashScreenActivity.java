package by.egorgutko.autorization.presentation.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    // Время в милесекундах, в течение которого будет отображаться Splash Screen
    private final int SPLASH_DISPLAY_LENGTH = 300;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        // проверяем, первый ли раз открывается программа
        final boolean hasVisited = sp.getBoolean("egor", false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    SplashScreenActivity.this.startActivity(mainIntent);
                    SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}