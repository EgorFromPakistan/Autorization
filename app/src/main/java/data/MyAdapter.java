package data;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import by.egorgutko.autorization.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapetrViewHolder> {

    ArrayList<String> myArray;

    public MyAdapter(ArrayList<String> myArray) {
        this.myArray = myArray;
    }

    public class MyAdapetrViewHolder extends RecyclerView.ViewHolder {

        TextView myText;

        public MyAdapetrViewHolder(@NonNull View view) {
            super(view);
            myText = (TextView) view.findViewById(R.id.mText);
        }
    }


    @NonNull
    @Override
    public MyAdapetrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new MyAdapetrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapetrViewHolder myAdapetrViewHolder, int position) {
        myAdapetrViewHolder.myText.setText(myArray.get(position));

    }

    @Override
    public int getItemCount() {
        return myArray.size();
    }


}
