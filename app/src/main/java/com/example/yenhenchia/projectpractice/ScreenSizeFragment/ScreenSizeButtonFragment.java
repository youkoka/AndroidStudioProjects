package com.example.yenhenchia.projectpractice.ScreenSizeFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yenhenchia.projectpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSizeButtonFragment extends Fragment {


    public interface ScreenSizeButtonInterface {

        void switchFragment();
    }

    public ScreenSizeButtonInterface mCallback;

    public ScreenSizeButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_size_button, container, false);
    }

}
