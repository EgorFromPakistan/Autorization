package by.egorgutko.autorization.presentation.login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.databinding.ActivityLoginBinding;
import by.egorgutko.autorization.presentation.Main.MainActivity;
import by.egorgutko.autorization.presentation.Schedule.SchedulerActivity;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    ActionBar actionBar;
    private final String SAVED_TEXT = "saved_text";
    LoginPresenter loginPresenter = new LoginPresenter();

    EditText editText;
    Button buttonOk;
    Button buttonToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //setContentView(R.layout.activity_login);
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#93E9FA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        editText = binding.mEditText;
        //editText = findViewById(R.id.mEditText);
       // buttonOk = findViewById(R.id.mButton);
        buttonOk = binding.mButton;
        buttonOk.setOnClickListener(this);
        buttonToScreen = binding.mButtonToScheduler;
        buttonToScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SchedulerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        loginPresenter.addName(this, editText.getText().toString())
                .subscribeOn(Schedulers.io())
                .subscribe();
        startActivity(intent);
    }
}
