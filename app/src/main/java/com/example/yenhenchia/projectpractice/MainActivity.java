package com.example.yenhenchia.projectpractice;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.yenhenchia.projectpractice.ButtonSelector.ButtonSelectorActivity;
import com.example.yenhenchia.projectpractice.CoordinatorLayout.CoordinatorLayoutActivity;
import com.example.yenhenchia.projectpractice.DrawableAnimationAndGame.DrawableAnimatinAndGameActivity;
import com.example.yenhenchia.projectpractice.ExpandableListView.ExpandListViewActivity;
import com.example.yenhenchia.projectpractice.GridView.GridViewActivity;
import com.example.yenhenchia.projectpractice.ImageButtonAndView.ImageButtonAndViewActivity;
import com.example.yenhenchia.projectpractice.ImageListView.ImageListViewActivity;
import com.example.yenhenchia.projectpractice.Linearlayout.LinearlayoutActivity;
import com.example.yenhenchia.projectpractice.PropertyAnimation.PropertyAnimationActivity;
import com.example.yenhenchia.projectpractice.RadioButton.RadioButtonActivity;
import com.example.yenhenchia.projectpractice.RecyclerView.RecyclerViewAndCardViewActivity;
import com.example.yenhenchia.projectpractice.RelativeLayout.RelativeLayoutActivity;
import com.example.yenhenchia.projectpractice.ScrollViewAndCheckBox.ScrollViewAndCheckBoxActivity;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleFragmentActivity;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleMainFragment;
import com.example.yenhenchia.projectpractice.Spinner.SpinnerActivity;
import com.example.yenhenchia.projectpractice.NumberPicker.NumberPickerActivity;
import com.example.yenhenchia.projectpractice.TableLayout.TableLayoutActivity;
import com.example.yenhenchia.projectpractice.ViewAnimation.ViewAnimationActivity;

public class MainActivity extends ListActivity {

    private static final int itemTypeSpinner               = 0;
    private static final int itemTypeRadioButton           = 1;
    private static final int itemTypeNumberPicker          = 2;
    private static final int itemTypeScrollViewAndCheckbox = 3;
    private static final int itemTypeLinearlayout          = 4;
    private static final int itemTypeTableLayout           = 5;
    private static final int itemTypeRelativeLayout        = 6;
    private static final int itemTypeButtonSelector        = 7;
    private static final int itemTypeCoordinatorLayout     = 8;
    private static final int itemTypeImageButtonAndView    = 9;
    private static final int itemTypeGridView              = 10;
    private static final int itemTypeViewAnimation         = 11;
    private static final int itemTypeDrawableAnimation     = 12;
    private static final int itemTypePropertyAnimation     = 13;
    private static final int itemTypeSimpleFragment        = 14;
    private static final int itemTypeImageListView         = 15;
    private static final int itemTypeExpandableListView    = 16;
    private static final int itemTypeRecyclerView          = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> arrAdpList = ArrayAdapter.createFromResource(this, R.array.listItem,
                android.R.layout.simple_list_item_1);

        setListAdapter(arrAdpList);

        ListView listView = getListView();
        listView.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {

                case itemTypeSpinner: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SpinnerActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeRadioButton: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, RadioButtonActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeNumberPicker:{

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, NumberPickerActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeScrollViewAndCheckbox: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ScrollViewAndCheckBoxActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeLinearlayout: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, LinearlayoutActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeTableLayout: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TableLayoutActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeRelativeLayout: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, RelativeLayoutActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeButtonSelector: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ButtonSelectorActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeCoordinatorLayout: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, CoordinatorLayoutActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeImageButtonAndView: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ImageButtonAndViewActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeGridView: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, GridViewActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeViewAnimation: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ViewAnimationActivity.class);
                    startActivity(intent);
//                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                }
                    break;
                case itemTypeDrawableAnimation: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DrawableAnimatinAndGameActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypePropertyAnimation: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PropertyAnimationActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSimpleFragment: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SimpleFragmentActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeImageListView: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ImageListViewActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeExpandableListView: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ExpandListViewActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeRecyclerView: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, RecyclerViewAndCardViewActivity.class);
                    startActivity(intent);
                }
                    break;
            }
        }
    };
}
