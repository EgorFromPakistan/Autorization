package by.egorgutko.autorization.presentation.splash_screen;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.data.AutorizationPreferenceSingleton;
import by.egorgutko.autorization.presentation.Main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    AutorizationPreferenceSingleton autorizationPreferenceSingleton;
   // private AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        autorizationPreferenceSingleton = AutorizationPreferenceSingleton.getPreference(this);
        //authorizationPreferences.init(this);
        if(autorizationPreferenceSingleton.getUserName() != null){
            Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            SplashScreenActivity.this.startActivity(mainIntent);
            SplashScreenActivity.this.finish();
        }
        else {
            Intent mainIntent = new Intent(SplashScreenActivity.this, ListActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            SplashScreenActivity.this.startActivity(mainIntent);
            SplashScreenActivity.this.finish();
        }
    }
}