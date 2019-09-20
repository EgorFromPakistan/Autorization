package by.egorgutko.autorization.presentation.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.data.AuthorizationPreferences;
import by.egorgutko.autorization.presentation.Main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {



    SharedPreferences preferences;
    ActionBar actionBar;
    final String SAVED_TEXT = "saved_text";
    AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

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

        //authorizationPreferences.init(this);
        //authorizationPreferences.addNameOfUser();
        //loadText();
        editText = (EditText)findViewById(R.id.mEditText);
        buttonOk =(Button) findViewById(R.id.mButton);
        buttonOk.setOnClickListener(this);
       // loginPresenter.attachView(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", editText.getText().toString());
        authorizationPreferences.init(this);
        authorizationPreferences.addNameOfUser(SAVED_TEXT,editText.getText().toString());
        //preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences.Editor editor = preferences.edit();
        //editor.putString(SAVED_TEXT,editText.getText().toString());
        //editor.apply();
        startActivity(intent);
    }
}
