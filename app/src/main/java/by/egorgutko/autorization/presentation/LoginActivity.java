package by.egorgutko.autorization.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import by.egorgutko.autorization.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    SharedPreferences sPref;
    //ForFinalString forFinalString;



   final String SAVED_TEXT = "saved_text";

    LoginPresenter loginPresenter = new LoginPresenter();
    EditText editText;
    Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
