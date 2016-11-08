package com.example.fovos.fragments_test;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

    //FIELDS
    private TextView txtmesg;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //reference to rootview after the inflate of this fragment
        View rootview=inflater.inflate(R.layout.fragment_a, container, false);

        //reference se item tou host activity
        Button btn=(Button) rootview.findViewById(R.id.btn_add_fragment);
        //Button btn=(Button)getActivity().findViewById(R.id.btn_add_fragment);

        //reference to Textview element of this Fragment Layout
        txtmesg=(TextView) rootview.findViewById(R.id.txt_msg);

        //One way to reference to Activity's variable via getter method
        txtmesg.setText("This is a variable String value from MainActivity: "+((MainActivity)getActivity()).get_message().toString());

        //inflate fragment A layout into MainActivity Layout
        //return inflater.inflate(R.layout.fragment_a, container, false);
        return rootview;
    }

}
