package by.egorgutko.autorization.presentation.Main;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import by.egorgutko.autorization.R;

public class MainActivity extends AppCompatActivity {

    //ForListFragment listFragment = new ForListFragment();



    FragmentManager fragmetManager;
    NavController navController;
    Button button2;
    String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tView);
        textView.setOnClickListener(this);*/
        //setContentView(R.layout.list_activity);
        setContentView(R.layout.activity_main);

        //Intent intent = getIntent();
        /*if (!intent.getStringExtra("name").equals("")) {
            name = intent.getStringExtra("name");
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.listFragment);
            ((TextView) fragment.getView().findViewById(R.id.mText)).setText(name);
        }*/
      /*  Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.listFragment);
        ((TextView) fragment.getView().findViewById(R.id.mText)).setText("csca");
       */
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // button2 = (Button) findViewById(R.id.button1);
        //button2.setOnClickListener(this);
        //fragment = new ForListFragment();
        // navController = Navigation.findNavController(this,R.id.placeholder);
        /*fragmetManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmetManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder, listFragment);
        fragmentTransaction.commit();*/
    }



   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_navigation, menu);
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
    }*/
}
