package by.egorgutko.autorization.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.Main.AdapterForRecyclerView;
import by.egorgutko.autorization.presentation.login.LoginActivity;

public class ForListFragment extends Fragment {

    private NavController navController;
    private RecyclerView recyclerView;
    private Button mButton;
    private TextView mTextView;
    private String nameOfUser;

    private ForListFragmentPresenter forListFragmentPresenter = new ForListFragmentPresenter();


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_list, containre, false);
        setHasOptionsMenu(true);

        mTextView = (TextView) view.findViewById(R.id.mText);
        recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);
        mButton = (Button) view.findViewById(R.id.mButtonLogOn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //authorizationPreferences.init(getActivity().getApplicationContext());
        //nameOfUser = authorizationPreferences.getUserName();
        nameOfUser = forListFragmentPresenter.getCurrentUserName(getActivity().getApplicationContext());
        mTextView.setText("Привет, " + nameOfUser);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //authorizationPreferences.getTaskList(nameOfUser, mArray);

        //onLoadSet();

        AdapterForRecyclerView myAdapter = new AdapterForRecyclerView(forListFragmentPresenter.getSetForList(nameOfUser));

        recyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_for_navigation, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Intent intent = new Intent(getActivity(), LoginActivity.class);
        //startActivity(intent);
        navController.navigate(R.id.action_listFragment_to_forAddFragment);
        return super.onOptionsItemSelected(item);
    }


   /* public String onLoadName(){
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String savedText = preferences.getString(SAVED_TEXT, "");
        Toast.makeText(getActivity().getApplicationContext(), savedText, Toast.LENGTH_SHORT).show();

        return savedText;
    }


    public void onLoadSet(){
        preferences = getActivity().getSharedPreferences(onLoadName(),MODE_PRIVATE);
        Set<String>  set = preferences.getStringSet(onLoadName(),new HashSet<String>());
        //String savedText = preferences.getString(SAVED_TEXT, "");
        for(String r : set) {
            mArray.add(r);
        };
    }

    */

}
