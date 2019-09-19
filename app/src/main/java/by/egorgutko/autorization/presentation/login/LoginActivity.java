package by.egorgutko.autorization.presentation.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.Main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    SharedPreferences sPref;
    //ForFinalString forFinalString;



   final String SAVED_TEXT = "saved_text";

    ActionBar actionBar;

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

        //loadText();
        editText = (EditText)findViewById(R.id.mEditText);
        buttonOk =(Button) findViewById(R.id.mButton);
        buttonOk.setOnClickListener(this);
       // loginPresenter.attachView(this);
    }

    @Override
    public void onClick(View view) {
        saveText();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", editText.getText().toString());
        startActivity(intent);
    }


    void saveText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);;
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, editText.getText().toString());
        ed.commit();
    }

    void loadText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);;
        String savedText = sPref.getString(SAVED_TEXT, "");
        Toast.makeText(this, savedText, Toast.LENGTH_SHORT).show();
    }
}
