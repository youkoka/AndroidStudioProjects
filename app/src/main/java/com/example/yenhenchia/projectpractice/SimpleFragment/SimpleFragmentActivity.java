package com.example.yenhenchia.projectpractice.SimpleFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yenhenchia.projectpractice.R;

public class SimpleFragmentActivity extends AppCompatActivity
        implements SimpleMainFragment.SimpleMainInterface, SimpleButtonFragment.SimpleButtonIngerface{

    //! 以下表示3大區塊fragment
    private final static String SimpleMainFragmentTag       = "SimpleMainFragmentTag";
    private final static String SimpleResultFragmentTag     = "SimpleResultFragmentTag";
    private final static String SimpleButtonFragmentTag     = "SimpleButtonFragmentTag";

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
        this.simpleResult2Fragment = new SimpleResult2Fragment();

        this.simpleButtonFragment = new SimpleButtonFragment();
//        this.simpleButtonFragment.mCallback = this;

        fragmentTransaction.add(R.id.simpleMainFragment, simpleMainFragment, SimpleMainFragmentTag);
        fragmentTransaction.add(R.id.simpleResultFragment, simpleResultFragment, SimpleResultFragmentTag);
        fragmentTransaction.add(R.id.simpleButtonFragment, simpleButtonFragment, SimpleButtonFragmentTag);

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

        if (this.simpleResult2Fragment != null) {

            this.simpleResult2Fragment.setGameResult(this.totalSetCount, this.drawSetCount, this.playerWinSetCount, this.cmpWinSetCount);
        }
    }


    @Override
    public void resultOfShow(SimpleButtonFragment.ShowResultType showResultType) {

        switch (showResultType) {

            case SHOW_RESULT_TYPE_UNKNOW:
                break;
            case SHOW_RESULT_TYPE_RESULT1: {

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (this.isShowResult) {

                    if (this.currentShowResultType != SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT1) {

                        fragmentManager.beginTransaction().replace(R.id.simpleResultFragment, this.simpleResultFragment, SimpleResultFragmentTag).commit();
                    }
                }
                else {

                    if (this.simpleResultFragment == null) {

                        this.simpleResultFragment = new SimpleResultFragment();

                        Log.d("SimpleResultFragment", "simpleResultFragment");
                    }

                    fragmentManager.beginTransaction().add(R.id.simpleResultFragment, this.simpleResultFragment, SimpleResultFragmentTag).commit();
                }

                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentManager.executePendingTransactions();

                if (this.simpleResultFragment != null) {

                    this.simpleResultFragment.setGameResult(this.totalSetCount, this.drawSetCount, this.playerWinSetCount, this.cmpWinSetCount);
                }

                this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT1;
                isShowResult = true;
            }
                break;
            case SHOW_RESULT_TYPE_RESULT2: {

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (this.isShowResult) {

                    if (this.currentShowResultType != SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT2) {

                        fragmentManager.beginTransaction().replace(R.id.simpleResultFragment, this.simpleResult2Fragment, SimpleResultFragmentTag).commit();
                    }
                }
                else {

                    if (this.simpleResult2Fragment == null) {

                        this.simpleResult2Fragment = new SimpleResult2Fragment();

                        Log.d("SimpleResultFragment", "simpleResult2fragment");
                    }

                    fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentManager.beginTransaction().add(R.id.simpleResultFragment, this.simpleResult2Fragment, SimpleResultFragmentTag).commit();
                }

                fragmentManager.executePendingTransactions();

                if (this.simpleResult2Fragment != null) {

                    this.simpleResult2Fragment.setGameResult(this.totalSetCount, this.drawSetCount, this.playerWinSetCount, this.cmpWinSetCount);
                }

                this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_RESULT2;
                isShowResult = true;
            }
                break;
            case SHOW_RESULT_TYPE_HIDE: {

                if (this.isShowResult) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentByTag(SimpleResultFragmentTag);

                    if (fragment != null) {

                        fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                        fragmentManager.beginTransaction().addToBackStack(null);
                        fragmentManager.beginTransaction().remove(fragment).commit();

                        this.currentShowResultType = SimpleButtonFragment.ShowResultType.SHOW_RESULT_TYPE_HIDE;
                        isShowResult = false;
                    }
                }
            }
                break;
        }
    }
}
