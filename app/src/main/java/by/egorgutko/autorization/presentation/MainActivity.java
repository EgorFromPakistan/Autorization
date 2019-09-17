package by.egorgutko.autorization.presentation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import by.egorgutko.autorization.R;
import data.ListFragment;

public class MainActivity extends AppCompatActivity {

    ListFragment listFragment = new ListFragment();

    FragmentManager fragmetManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tView);
        textView.setOnClickListener(this);*/
        setContentView(R.layout.list_activity);
        //fragment = new ListFragment();
        fragmetManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmetManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder, listFragment);
        fragmentTransaction.commit();
    }

}
