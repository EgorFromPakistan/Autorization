package by.egorgutko.autorization.presentation;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import by.egorgutko.autorization.R;
import data.ListFragment;

public class MainActivity extends AppCompatActivity {

    //ListFragment listFragment = new ListFragment();

    FragmentManager fragmetManager;
    NavController navController;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tView);
        textView.setOnClickListener(this);*/
        //setContentView(R.layout.list_activity);
        setContentView(R.layout.check);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // button2 = (Button) findViewById(R.id.button1);
        //button2.setOnClickListener(this);
        //fragment = new ListFragment();
        // navController = Navigation.findNavController(this,R.id.placeholder);
        /*fragmetManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmetManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder, listFragment);
        fragmentTransaction.commit();*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_see:
                navController.navigate(R.id.listFragment);
                break;
            case R.id.menu_add:
                navController.navigate(R.id.forAddFragment);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
