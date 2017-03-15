package com.example.yenhenchia.projectpractice.ScreenSizeFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleMainFragment;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleResultFragment;

public class ScreenSizeFragmentActivity extends AppCompatActivity implements SimpleMainFragment.SimpleMainInterface, ScreenSizeButtonFragment.ScreenSizeButtonInterface {

    //! 以下表示3大區塊fragment
    private final static String ScreenMainFragmentTag       = "ScreenMainFragmentTag";
    private final static String ScreenResultFragmentTag     = "ScreenResultFragmentTag";
    private final static String ScreenButtonFragmentTag     = "ScreenButtonFragmentTag";

    private SimpleMainFragment simpleMainFragment;
    private SimpleResultFragment simpleResultFragment;
    private ScreenSizeButtonFragment screenSizeButtonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_size_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        simpleMainFragment = new SimpleMainFragment();
        simpleMainFragment.mCallback = this;

        simpleResultFragment = new SimpleResultFragment();

        screenSizeButtonFragment = new ScreenSizeButtonFragment();
        screenSizeButtonFragment.mCallback = this;

        fragmentTransaction.add(R.id.sizeFragmentGame, simpleMainFragment, ScreenMainFragmentTag);
        fragmentTransaction.add(R.id.sizeFragmentResult, simpleResultFragment, ScreenResultFragmentTag);
        fragmentTransaction.add(R.id.sizeFragmentButton, screenSizeButtonFragment, ScreenButtonFragmentTag);

        fragmentTransaction.commit();
    }

    @Override
    public void resultOfWin(SimpleMainFragment.GameResultWinType winType) {

    }

    @Override
    public void switchFragment() {

    }
}
