package com.worlds.myteaching.sharepreference_demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.worlds.myteaching.R;


public class FirstFagment extends Fragment {
    TextView textView;

    public FirstFagment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_fagment, container, false);
        textView = view.findViewById(R.id.text);
        textView.setText("First");
        return view;
    }

}
