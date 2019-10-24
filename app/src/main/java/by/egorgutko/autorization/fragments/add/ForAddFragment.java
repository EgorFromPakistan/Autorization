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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Objects;

import javax.inject.Inject;

import by.egorgutko.autorization.DI.DaggerController;
import by.egorgutko.autorization.DI.DaggerMyAppComponent;
import by.egorgutko.autorization.DI.MyAppComponent;
import by.egorgutko.autorization.R;
import by.egorgutko.autorization.databinding.FragmentForAddBinding;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    private EditText editText;
    private NavController navController;
    private DaggerController daggerController;

    @Inject
    ForAddTaskPresenter forAddActivityPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MyAppComponent myAppComponent = DaggerMyAppComponent.builder().build();
        daggerController = new DaggerController(myAppComponent);
        daggerController.initForAddTaskSubController();
        daggerController.getForAddTAskComponent().inject(this);
       // myAppComponent.forAddTaskComponent().inject(this);
        super.onCreate(savedInstanceState);
        forAddActivityPresenter.attachView(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {


        FragmentForAddBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_for_add, containre, false);
        View view = binding.getRoot();
        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);
        editText = binding.etext;
        Button button = binding.button;
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
