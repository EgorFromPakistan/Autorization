package by.egorgutko.autorization.presentation.splash_screen

import android.annotation.SuppressLint
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import by.egorgutko.autorization.R
import by.egorgutko.autorization.data.defaultPreference.AutorizationPreference
import by.egorgutko.autorization.presentation.Main.MainActivity
import io.reactivex.schedulers.Schedulers

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var autorizationPreferenceSingleton: AutorizationPreference

    @SuppressLint("CheckResult")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        autorizationPreferenceSingleton = AutorizationPreference.getPreference(this)
        autorizationPreferenceSingleton.getUserName()
                .subscribeOn(Schedulers.io())
                .subscribe { currentName ->
                    if (currentName != null) {
                        val mainIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        this@SplashScreenActivity.startActivity(mainIntent)
                        this@SplashScreenActivity.finish()
                    } else {
                        val mainIntent = Intent(this@SplashScreenActivity, ListActivity::class.java)
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        this@SplashScreenActivity.startActivity(mainIntent)
                        this@SplashScreenActivity.finish()
                    }
                }
    }
}