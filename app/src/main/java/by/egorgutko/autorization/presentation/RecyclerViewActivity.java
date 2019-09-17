package by.egorgutko.autorization.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import by.egorgutko.autorization.R;
import data.MyAdapter;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> mArray = new ArrayList<>();
        mArray.add("sdfsdvsdagvsdab");
        mArray.add("2");
        mArray.add("asdfsdgf");




        MyAdapter myAdapter = new MyAdapter(mArray);

        recyclerView.setAdapter(myAdapter);
    }
}
