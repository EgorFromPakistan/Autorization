package by.egorgutko.autorization.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import by.egorgutko.autorization.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tView);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intetent = new Intent(this,LoginActivity.class);
        startActivity(intetent);
    }
}
