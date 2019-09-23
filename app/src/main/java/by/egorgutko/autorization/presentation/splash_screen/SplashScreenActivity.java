package by.egorgutko.autorization.presentation.splash_screen;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.data.AuthorizationPreferences;
import by.egorgutko.autorization.presentation.Main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    // Время в милесекундах, в течение которого будет отображаться Splash Screen
    //private final int SPLASH_DISPLAY_LENGTH = 300;
    private AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        authorizationPreferences.init(this);
        if(authorizationPreferences.getUserName() != null){
            Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
            SplashScreenActivity.this.startActivity(mainIntent);
            SplashScreenActivity.this.finish();
        }
        else {
            Intent mainIntent = new Intent(SplashScreenActivity.this, ListActivity.class);
            SplashScreenActivity.this.startActivity(mainIntent);
            SplashScreenActivity.this.finish();
        }
       /* if(authorizationPreferences.getUserName() != null){
            Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
            SplashScreenActivity.this.startActivity(mainIntent);
        } else {
            Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            SplashScreenActivity.this.startActivity(mainIntent);
        }
        SplashScreenActivity.this.finish();

        */

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*if(authorizationPreferences.getUserName() != null) {
                    Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    SplashScreenActivity.this.startActivity(mainIntent);
                    SplashScreenActivity.this.finish();
                }
                else{
                    Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    SplashScreenActivity.this.startActivity(mainIntent);
                    SplashScreenActivity.this.finish();
                }
                //SplashScreenActivity.this.finish();
            }

                 */
        /*
                Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                SplashScreenActivity.this.startActivity(mainIntent);
                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

         */



    }
}