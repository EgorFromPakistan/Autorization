package by.egorgutko.autorization.presentation.Main;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import by.egorgutko.autorization.R;

public class AdapterForRecyclerView extends RecyclerView.Adapter<AdapterForRecyclerView.MyAdapetrViewHolder> {

    ArrayList<String> myArray;

    public AdapterForRecyclerView(ArrayList<String> myArray) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycler_view, parent, false);
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
