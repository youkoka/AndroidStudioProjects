package com.example.yenhenchia.projectpractice.ViewPager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;

public class SimpleViewFragment extends Fragment {

    private Button btnTapMe;

    private int num;

    public static SimpleViewFragment newInstance(int num) {
        
        Bundle args = new Bundle();
        args.putInt("num", num);

        SimpleViewFragment fragment = new SimpleViewFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        num = (getArguments() != null) ? getArguments().getInt("num") : 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_view, container, false);

        TextView txtPage = (TextView) view.findViewById(R.id.txtPage);
        txtPage.setText("This is number " + num + " page");

        btnTapMe = (Button) view.findViewById(R.id.btnTapMe);
        btnTapMe.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private Button.OnClickListener onClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Toast.makeText(getContext(), "message : " + num, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("SimpleViewFragment", "destroy!");
    }
}
