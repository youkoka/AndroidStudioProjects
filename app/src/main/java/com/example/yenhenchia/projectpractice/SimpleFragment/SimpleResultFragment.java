package com.example.yenhenchia.projectpractice.SimpleFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.yenhenchia.projectpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleResultFragment extends Fragment {

    private EditText editTotalSet, editDrawSet, editPlayerWinSet, editCmpWinSet;
    private int totalSetCount, playerWinSetCount, cmpWinSetCount, drawSetCount;

    public SimpleResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_result, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.editTotalSet = (EditText)getView().findViewById(R.id.editTotal);
        this.editDrawSet = (EditText)getView().findViewById(R.id.editDraw);
        this.editPlayerWinSet = (EditText)getView().findViewById(R.id.editPlayerSet);
        this.editCmpWinSet = (EditText)getView().findViewById(R.id.editCmpSet);
    }

    @Override
    public void onResume() {
        super.onResume();

        this.editTotalSet.setText(String.valueOf(totalSetCount));
        this.editPlayerWinSet.setText(String.valueOf(playerWinSetCount));
        this.editCmpWinSet.setText(String.valueOf(cmpWinSetCount));
        this.editDrawSet.setText(String.valueOf(drawSetCount));
    }

    public void setGameResult(int totalSet, int drawSet, int playerWinSet, int cmpWinSet) {

        this.totalSetCount = totalSet;
        this.drawSetCount = drawSet;
        this.playerWinSetCount = playerWinSet;
        this.cmpWinSetCount = cmpWinSet;

        if (this.editTotalSet != null) {

            this.editTotalSet.setText(String.valueOf(totalSet));
        }

        if (this.editPlayerWinSet != null) {

            this.editPlayerWinSet.setText(String.valueOf(playerWinSet));
        }

        if (this.editCmpWinSet != null) {

            this.editCmpWinSet.setText(String.valueOf(cmpWinSet));
        }

        if (this.editDrawSet != null) {

            this.editDrawSet.setText(String.valueOf(drawSet));
        }
    }
}
