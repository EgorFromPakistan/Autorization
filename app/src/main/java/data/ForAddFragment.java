package data;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import by.egorgutko.autorization.R;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    EditText editText;
    Button button;
    String myNote;
    NavController navController;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.for_add, containre, false);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        editText = (EditText) view.findViewById(R.id.etext);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("arg", editText.getText().toString());

        navController.navigate(R.id.listFragment, bundle);
        //Intent intent = new Intent(getActivity(),)
    }
}
