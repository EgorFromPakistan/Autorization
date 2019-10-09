package by.egorgutko.autorization.fragments.add;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Objects;

import by.egorgutko.autorization.R;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    private EditText editText;
    private Button button;
    private NavController navController;
    private ForAddActivityPresenter forAddActivityPresenter = new ForAddActivityPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forAddActivityPresenter.attachView(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_add, containre, false);
        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);
        editText = view.findViewById(R.id.etext);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);

        getLifecycle().addObserver(forAddActivityPresenter);

        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        forAddActivityPresenter.init(getContext(), editText.getText().toString());
        navController.popBackStack();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        forAddActivityPresenter.disposeObserver();
    }
}
