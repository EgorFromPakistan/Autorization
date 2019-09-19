package by.egorgutko.autorization.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Set;

import by.egorgutko.autorization.R;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    EditText editText;
    Button button;
    NavController navController;
    SharedPreferences preferences;
    Set<String> set;


    final String SAVED_TEXT = "saved_text";


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_add, containre, false);

       /* actionBar = mainActivity.getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#93E9FA"));
        actionBar.setBackgroundDrawable(colorDrawable);*/


        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        editText = (EditText) view.findViewById(R.id.etext);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }


    public String onLoad(){
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String savedText = preferences.getString(SAVED_TEXT, "");
        Toast.makeText(getActivity().getApplicationContext(), savedText, Toast.LENGTH_SHORT).show();

        return savedText;
    }
    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("arg", editText.getText().toString());

        navController.navigate(R.id.action_forAddFragment_to_listFragment,bundle);
        //navController.navigate(R.id.listFragment, bundle);
        //Intent intent = new Intent(getActivity(),)
    }
}
