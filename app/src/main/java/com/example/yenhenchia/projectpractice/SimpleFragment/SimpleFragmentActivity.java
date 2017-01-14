package com.example.yenhenchia.projectpractice.SimpleFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.yenhenchia.projectpractice.R;

public class SimpleFragmentActivity extends AppCompatActivity
        implements SimpleMainFragment.SimpleMainInterface, SimpleButtonFragment.SimpleButtonIngerface{

    private int totalSetCount, playerWinSetCount, cmpWinSetCount, drawSetCount;

    private SimpleMainFragment simpleMainFragment;
    private SimpleResultFragment simpleResultFragment;
    private SimpleResult2Fragment simpleResult2Fragment;
    private SimpleButtonFragment simpleButtonFragment;

    private boolean isShowResult;
    private SimpleButtonFragment.ShowResultType currentShowResultType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);

        this.totalSetCount = this.playerWinSetCount = this.cmpWinSetCount = this.drawSetCount = 0;
        this.isShowResult = true;
        this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT1;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

        this.simpleMainFragment = new SimpleMainFragment();
        this.simpleMainFragment.mCallback = this;

        this.simpleResultFragment = new SimpleResultFragment();

        this.simpleButtonFragment = new SimpleButtonFragment();
        this.simpleButtonFragment.mCallback = this;

        fragmentTransaction.add(R.id.simpleMainFragment, simpleMainFragment, "SimpleMainFragment");
        fragmentTransaction.add(R.id.simpleResultFragment, simpleResultFragment, "SimpleResultFragment");
        fragmentTransaction.add(R.id.simpleButtonFragment, simpleButtonFragment, "SimpleButtonFragment");

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

        this.simpleResultFragment.setGameResult(this.totalSetCount, this.drawSetCount, this.playerWinSetCount, this.cmpWinSetCount);
    }


    @Override
    public void resultOfShow(SimpleButtonFragment.ShowResultType showResultType) {

        switch (showResultType) {

            case SHOW_RESULT_TYPE_RESULT1: {

                this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT1;

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (this.isShowResult == true) {

                    if (this.currentShowResultType != SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT1) {

                    }
                }
                else {

                    if (this.simpleResultFragment == null) {

                        this.simpleResultFragment = new SimpleResultFragment();
                    }

                    fragmentManager.beginTransaction().add(R.id.simpleResultFragment, this.simpleResultFragment, "SimpleResultFragment").commit();
                }

                isShowResult = true;
            }
                break;
            case SHOW_RESULT_TYPE_RESULT2: {

                this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT2;

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (this.isShowResult == true) {

                    if (this.currentShowResultType != SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT2) {

                    }
                }
                else {

                    if (this.simpleResultFragment == null) {

                        this.simpleResultFragment = new SimpleResultFragment();
                    }

                    fragmentManager.beginTransaction().add(R.id.simpleResultFragment, this.simpleResultFragment, "SimpleResultFragment").commit();
                }

                isShowResult = true;
            }
                break;
            case SHOW_RESULT_TYPE_HIDE: {

                if (this.isShowResult == true) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    SimpleResultFragment simpleResultFragment = (SimpleResultFragment) fragmentManager.findFragmentByTag("SimpleResultFragment");

                    if (simpleResultFragment != null) {

                        fragmentManager.beginTransaction().remove(simpleResultFragment).commit();

                        this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_HIDE;
                        isShowResult = false;
                    }
                }
            }
                break;
        }
    }
}
