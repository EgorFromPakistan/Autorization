package by.egorgutko.autorization.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import by.egorgutko.autorization.R
import by.egorgutko.autorization.databinding.ActivityLoginBinding
import by.egorgutko.autorization.presentation.Main.MainActivity
import by.egorgutko.autorization.presentation.Schedule.SchedulerActivity
import io.reactivex.schedulers.Schedulers

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    private var actionBar: ActionBar? = null
    private val SAVED_TEXT = "saved_text"
    private var loginPresenter = LoginPresenter()

    private lateinit var editText: EditText
    private lateinit var buttonOk: Button
    private lateinit var buttonToScreen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        actionBar = supportActionBar
        editText = binding.mEditText
        buttonOk = binding.mButton
        buttonOk.setOnClickListener(this)
        buttonToScreen = binding.mButtonToScheduler
        buttonToScreen.setOnClickListener { view ->
            val intent = Intent(this@LoginActivity, SchedulerActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        loginPresenter.addName(this, editText.text.toString())
                .subscribeOn(Schedulers.io())
                .subscribe()
        startActivity(intent)
    }
}
