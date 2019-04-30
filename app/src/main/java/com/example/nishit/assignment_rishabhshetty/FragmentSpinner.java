package com.example.nishit.assignment_rishabhshetty;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nishit.assignment_rishabhshetty.R;

public class FragmentSpinner extends android.support.v4.app.Fragment{
    View view;
    public FragmentSpinner() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.spinner_fragment,container,false);
        return view;
    }
}
