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

import javax.inject.Inject;

import by.egorgutko.autorization.DI.DaggerMyAppComponent;
import by.egorgutko.autorization.DI.MyAppComponent;
import by.egorgutko.autorization.R;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    private EditText editText;
    private NavController navController;

    @Inject
    ForAddTaskPresenter forAddActivityPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       /*
         AppComponent appComponent = DaggerAppComponent.builder().build();
        ForAddTaskComponent forAddTaskComponent = DaggerForAddTaskComponent.builder().build();
        */
        MyAppComponent myAppComponent = DaggerMyAppComponent.builder().build();
        myAppComponent.forAddTaskComponent().inject(this);
        super.onCreate(savedInstanceState);
        forAddActivityPresenter.attachView(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_add, containre, false);
        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);
        editText = view.findViewById(R.id.etext);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(this);

        getLifecycle().addObserver(forAddActivityPresenter);

        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        forAddActivityPresenter.userClickToAddTask(getContext(), editText.getText().toString());
        navController.popBackStack();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        forAddActivityPresenter.disposeObserver();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        forAddActivityPresenter.detachView();
    }
}
