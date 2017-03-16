package com.example.yenhenchia.projectpractice.ScreenSizeFragment;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleMainFragment;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleResultFragment;

public class ScreenSizeFragmentActivity extends AppCompatActivity implements SimpleMainFragment.SimpleMainInterface, ScreenSizeButtonFragment.ScreenSizeButtonInterface {

    enum FragmentType {

        FRAGMENT_TYPE_UNKNOW,
        FRAGMENT_TYPE_ONE_FRAME, FRAGMENT_TYPE_TWO_FRAME;
    }

    //! 以下表示3大區塊fragment
    private final static String ScreenMainFragmentTag       = "ScreenMainFragmentTag";
    private final static String ScreenResultFragmentTag     = "ScreenResultFragmentTag";
    private final static String ScreenButtonFragmentTag     = "ScreenButtonFragmentTag";

    private SimpleMainFragment simpleMainFragment;
    private SimpleResultFragment simpleResultFragment;
    private ScreenSizeButtonFragment screenSizeButtonFragment;

    private FragmentType fragmentType;

    private int totalSetCount, playerWinSetCount, cmpWinSetCount, drawSetCount;

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

        switch (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) {

            case Configuration.SCREENLAYOUT_SIZE_SMALL:
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            case Configuration.SCREENLAYOUT_SIZE_LARGE:{

                this.fragmentType = FragmentType.FRAGMENT_TYPE_ONE_FRAME;

                fragmentTransaction.add(R.id.sizeFragmentMain, simpleMainFragment, ScreenMainFragmentTag);
                fragmentTransaction.add(R.id.sizeFragmentButton, screenSizeButtonFragment, ScreenButtonFragmentTag);
            }
                break;
            case Configuration.SCREENLAYOUT_SIZE_XLARGE: {

                this.fragmentType = FragmentType.FRAGMENT_TYPE_TWO_FRAME;

                fragmentTransaction.add(R.id.sizeFragmentMain, simpleMainFragment, ScreenMainFragmentTag);
                fragmentTransaction.add(R.id.sizeFragmentResult, simpleResultFragment, ScreenResultFragmentTag);
            }
                break;
            default: {

                this.fragmentType = FragmentType.FRAGMENT_TYPE_UNKNOW;
                fragmentTransaction.add(R.id.sizeFragmentMain, simpleMainFragment, ScreenMainFragmentTag);
                fragmentTransaction.add(R.id.sizeFragmentButton, screenSizeButtonFragment, ScreenButtonFragmentTag);
            }
                break;
        }

        fragmentTransaction.commit();
    }

    @Override
    public void resultOfWin(SimpleMainFragment.GameResultWinType winType) {

        this.totalSetCount++;

        switch (winType) {

            case GAME_RESULT_WIN_TYPE_DRAW: {

                this.drawSetCount++;
            }
            break;
            case GAME_RESULT_WIN_TYPECOMPUTER: {

                this.cmpWinSetCount++;
            }
            break;
            case GAME_RESULT_WIN_TYPE_PLAYER: {

                this.playerWinSetCount++;
            }
            break;
        }

        if (this.simpleResultFragment != null) {

            this.simpleResultFragment.setGameResult(this.totalSetCount, this.drawSetCount, this.playerWinSetCount, this.cmpWinSetCount);
        }
    }

    @Override
    public void switchFragment(ScreenSizeButtonFragment.SwitchType switchType) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (switchType) {

            case SWITCH_TYPE_SHOWGAME: {

                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.replace(R.id.sizeFragmentMain, simpleMainFragment, ScreenMainFragmentTag);
            }
                break;
            case SWITCH_TYPE_SHOWRESULT: {

                fragmentTransaction.replace(R.id.sizeFragmentMain, simpleResultFragment, ScreenResultFragmentTag);
                fragmentManager.executePendingTransactions();
                simpleResultFragment.setGameResult(totalSetCount, drawSetCount, playerWinSetCount, cmpWinSetCount);
            }
                break;
        }

        fragmentTransaction.commit();
    }
}
