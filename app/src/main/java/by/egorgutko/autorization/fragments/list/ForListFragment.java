package by.egorgutko.autorization.fragments.list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import by.egorgutko.autorization.DI.DaggerController;
import by.egorgutko.autorization.DI.DaggerMyAppComponent;
import by.egorgutko.autorization.DI.MyAppComponent;
import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.Main.AdapterForRecyclerView;
import by.egorgutko.autorization.presentation.login.LoginActivity;

public class ForListFragment extends Fragment implements ForListView {

    private NavController navController;
    private RecyclerView recyclerView;
    private TextView mTextView;
    private DaggerController daggerController;
    @Inject
    ForListFragmentPresenter forListFragmentPresenter;

    /* private ForListFragmentPresenter forListFragmentPresenter = new ForListFragmentPresenter(); */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        //AppComponent appComponent = DaggerAppComponent.builder().build();
        MyAppComponent myAppComponent = DaggerMyAppComponent.builder().build();
        daggerController = new DaggerController(myAppComponent);
        daggerController.initForListSubComponent();
        daggerController.getForListTaskSubComponent().inject(this);
        //myAppComponent.forListTaskComponent().inject(this);
        super.onCreate(savedInstanceState);
        forListFragmentPresenter.attachView(this);
    }

    @SuppressLint({"SetTextI18n", "CheckResult"})
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_list, containre, false);
        setHasOptionsMenu(true);


        mTextView = view.findViewById(R.id.mText);
        recyclerView = view.findViewById(R.id.listRecyclerView);
        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);
        Button mButton = view.findViewById(R.id.mButtonLogOn);
        mButton.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        });

        //forListFragmentPresenter.userClickToAddTask(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("myLog","мы тут");
        forListFragmentPresenter.showTaskList(getContext());
    }




    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_for_navigation, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        navController.navigate(R.id.action_listFragment_to_forAddFragment);
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showUserName(String name) {
        mTextView.setText("Привет, " + name);
    }

    @Override
    public void showUserData(List data) {
        AdapterForRecyclerView myAdapter = new AdapterForRecyclerView(data);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        forListFragmentPresenter.disposeObserver();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        forListFragmentPresenter.detachView();
    }
}
