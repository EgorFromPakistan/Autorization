package by.egorgutko.autorization.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.Main.AdapterForRecyclerView;
import by.egorgutko.autorization.presentation.login.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class ForListFragment extends Fragment implements View.OnClickListener {

    NavController navController;
    RecyclerView recyclerView;
    Button mButton;
    TextView mTextView;
    SharedPreferences preferences;

    final String SAVED_TEXT = "saved_text";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_list, containre, false);
        setHasOptionsMenu(true);

        mTextView = (TextView) view.findViewById(R.id.mText);
        recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        mButton = (Button) view.findViewById(R.id.mButtonLogOn);
        mButton.setOnClickListener(this);

        mTextView.setText("Привет, "+onLoadName());

        //mButton.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<String> mArray = new ArrayList<>();

        preferences = getActivity().getSharedPreferences(onLoadName(),MODE_PRIVATE);
        Set<String>  set = preferences.getStringSet(onLoadName(),new HashSet<String>());
        String savedText = preferences.getString(SAVED_TEXT, "");
        for(String r : set) {
            mArray.add(r);
        }


       // if (getArguments() != null && !getArguments().getString("arg").equals(""))
        //    mArray.add(getArguments().getString("arg"));
       // mArray.add("number1");
       // mArray.add("number2");
       // mArray.add("number3");


        AdapterForRecyclerView myAdapter = new AdapterForRecyclerView(mArray);

        recyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_for_navigation, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Intent intent = new Intent(getActivity(), LoginActivity.class);
        //startActivity(intent);
        navController.navigate(R.id.forAddFragment);
        return super.onOptionsItemSelected(item);
    }


    public String onLoadName(){
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String savedText = preferences.getString(SAVED_TEXT, "");
        Toast.makeText(getActivity().getApplicationContext(), savedText, Toast.LENGTH_SHORT).show();

        return savedText;
    }

    public String onLoadSet(){
        preferences = getActivity().getSharedPreferences(onLoadName(),MODE_PRIVATE);
        Set<String>  set = preferences.getStringSet(onLoadName(),new HashSet<String>());
        String savedText = preferences.getString(SAVED_TEXT, "");
        for(String r : set) {
            Log.i("Share", "Taska: " + r);
        }
        Toast.makeText(getActivity().getApplicationContext(), savedText, Toast.LENGTH_SHORT).show();

        return savedText;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
