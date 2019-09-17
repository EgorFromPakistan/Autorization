package data;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import by.egorgutko.autorization.R;

public class ListFragment extends Fragment {

    RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, containre, false);
        recyclerView =(RecyclerView)view.findViewById(R.id.listRecyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<String> mArray = new ArrayList<>();
        mArray.add("sdfsdvsdagvsdab");
        mArray.add("2");
        mArray.add("asdfsdgf");




        MyAdapter myAdapter = new MyAdapter(mArray);

        recyclerView.setAdapter(myAdapter);

        return view;
    }
}
