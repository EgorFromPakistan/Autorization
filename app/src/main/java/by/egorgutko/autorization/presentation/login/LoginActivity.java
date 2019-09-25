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

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.Main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {



    ActionBar actionBar;
    private final String SAVED_TEXT = "saved_text";
    LoginPresenter loginPresenter = new LoginPresenter();

    EditText editText;
    Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#93E9FA"));
        actionBar.setBackgroundDrawable(colorDrawable);
        editText = findViewById(R.id.mEditText);
        buttonOk = findViewById(R.id.mButton);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        loginPresenter.addName(this,editText.getText().toString());
        startActivity(intent);
    }
}
