package data;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import by.egorgutko.autorization.R;
import by.egorgutko.autorization.presentation.LoginActivity;
import by.egorgutko.autorization.presentation.MainActivity;

public class ListFragment extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    Button mButton;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, containre, false);
        recyclerView =(RecyclerView)view.findViewById(R.id.listRecyclerView);

        mButton =(Button)view.findViewById(R.id.mButtonLogOn);

        mButton.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<String> mArray = new ArrayList<>();
        mArray.add("sdfsdvsdagvsdab");
        mArray.add("2");
        mArray.add("asdfsdgf");




        MyAdapter myAdapter = new MyAdapter(mArray);

        recyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
