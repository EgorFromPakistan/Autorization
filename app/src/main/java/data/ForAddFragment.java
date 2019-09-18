package data;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import by.egorgutko.autorization.R;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    TextView textView;
    Button button;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.for_add, containre, false);

        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(this);

        button =(Button) view.findViewById(R.id.button);
        textView = (TextView)view.findViewById(R.id.etext);
        return view;
    }

    @Override
    public void onClick(View view) {
        //Intent intent = new Intent(getActivity(),)
    }
}
