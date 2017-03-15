package com.example.yenhenchia.projectpractice;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yenhenchia.projectpractice.ActionBarContextMenu.ActionBarContextMenuActivity;
import com.example.yenhenchia.projectpractice.ActionBarOptionMenu.ActionBarMenuActivity;
import com.example.yenhenchia.projectpractice.ActionItemAndView.ActionItemAndViewActivity;
import com.example.yenhenchia.projectpractice.ActivityLifecycle.ActivityLifecycleActivity;
import com.example.yenhenchia.projectpractice.AlertDialog.AlertDialogActivity;
import com.example.yenhenchia.projectpractice.AutoCompleteText.AutoCompleteTextViewActivity;
import com.example.yenhenchia.projectpractice.ButtonSelector.ButtonSelectorActivity;
import com.example.yenhenchia.projectpractice.ContentProvider.ContentProviderActivity;
import com.example.yenhenchia.projectpractice.CoordinatorLayout.CoordinatorLayoutActivity;
import com.example.yenhenchia.projectpractice.CustomDialog.CustomDialogActivity;
import com.example.yenhenchia.projectpractice.DateAndTimePicker.DateAndTimePickerActivity;
import com.example.yenhenchia.projectpractice.DrawableAnimationAndGame.DrawableAnimatinAndGameActivity;
import com.example.yenhenchia.projectpractice.ExpandableListView.ExpandListViewActivity;
import com.example.yenhenchia.projectpractice.FileStream.FileStreamActivity;
import com.example.yenhenchia.projectpractice.GridView.GridViewActivity;
import com.example.yenhenchia.projectpractice.ImageButtonAndView.ImageButtonAndViewActivity;
import com.example.yenhenchia.projectpractice.ImageListView.ImageListViewActivity;
import com.example.yenhenchia.projectpractice.Linearlayout.LinearlayoutActivity;
import com.example.yenhenchia.projectpractice.NavigationDrawer.NavigationDrawerActivity;
import com.example.yenhenchia.projectpractice.Notification.NotificationActivity;
import com.example.yenhenchia.projectpractice.ProgressBarAndDialog.ProgressBarAndDialogActivity;
import com.example.yenhenchia.projectpractice.PropertyAnimation.PropertyAnimationActivity;
import com.example.yenhenchia.projectpractice.RadioButton.RadioButtonActivity;
import com.example.yenhenchia.projectpractice.RecyclerView.RecyclerViewAndCardViewActivity;
import com.example.yenhenchia.projectpractice.RelativeLayout.RelativeLayoutActivity;
import com.example.yenhenchia.projectpractice.SQLite.SQLiteActivity;
import com.example.yenhenchia.projectpractice.ScreenSizeFragment.ScreenSizeFragmentActivity;
import com.example.yenhenchia.projectpractice.ScrollViewAndCheckBox.ScrollViewAndCheckBoxActivity;
import com.example.yenhenchia.projectpractice.ScrollableSwipe.ScrollableSwipeActivity;
import com.example.yenhenchia.projectpractice.SeekBarAndRatingBar.SeekBarAndRatingBarActivity;
import com.example.yenhenchia.projectpractice.SimpleBroadcast.SimpleBroadcastActivity;
import com.example.yenhenchia.projectpractice.SimpleFragment.SimpleFragmentActivity;
import com.example.yenhenchia.projectpractice.SimpleIntent.SimpleIntentActivity;
import com.example.yenhenchia.projectpractice.SimpleService.SimpleServiceActivity;
import com.example.yenhenchia.projectpractice.SnackBar.SnackBarActivity;
import com.example.yenhenchia.projectpractice.Spinner.SpinnerActivity;
import com.example.yenhenchia.projectpractice.NumberPicker.NumberPickerActivity;
import com.example.yenhenchia.projectpractice.TabLayout.TabLayoutActivity;
import com.example.yenhenchia.projectpractice.TableLayout.TableLayoutActivity;
import com.example.yenhenchia.projectpractice.ViewAnimation.ViewAnimationActivity;

public class MainActivity extends ListActivity {

    private static final int itemTypeSpinner                = 0;
    private static final int itemTypeRadioButton            = 1;
    private static final int itemTypeNumberPicker           = 2;
    private static final int itemTypeScrollViewAndCheckbox  = 3;
    private static final int itemTypeLinearlayout           = 4;
    private static final int itemTypeTableLayout            = 5;
    private static final int itemTypeRelativeLayout         = 6;
    private static final int itemTypeButtonSelector         = 7;
    private static final int itemTypeCoordinatorLayout      = 8;
    private static final int itemTypeImageButtonAndView     = 9;
    private static final int itemTypeGridView               = 10;
    private static final int itemTypeViewAnimation          = 11;
    private static final int itemTypeDrawableAnimation      = 12;
    private static final int itemTypePropertyAnimation      = 13;
    private static final int itemTypeSimpleFragment         = 14;
    private static final int itemTypeImageListView          = 15;
    private static final int itemTypeExpandableListView     = 16;
    private static final int itemTypeRecyclerView           = 17;
    private static final int itemTypeAutoCompleteText       = 18;
    private static final int itemTypeSeekBarAndRatingBar    = 19;
    private static final int itemTypeDateAndTimePicker      = 20;
    private static final int itemTypeProgressBarAndDialog   = 21;
    private static final int itemTypeAlertDialog            = 22;
    private static final int itemTypeSnackBar               = 23;
    private static final int itemTypeCustomDialog           = 24;
    private static final int itemTypeSimpleIntent           = 25;
    private static final int itemTypeSimpleBroadcast        = 26;
    private static final int itemTypeSimpleService          = 27;
    private static final int itemTypeActivityLifecycle      = 28;
    private static final int itemTypeActionBarOptionMenu    = 29;
    private static final int itemTypeActionBarContextMenu   = 30;
    private static final int itemTypeActionViewAndItem      = 31;
    private static final int itemTypeNavigationDrawer       = 32;
    private static final int itemTypeScrollableSwipe        = 33;
    private static final int itemTypeTabLayout              = 34;
    private static final int itemTypeNotification           = 35;
    private static final int itemTypeSQLite                 = 36;
    private static final int itemTypeContentProvider        = 37;
    private static final int itemTypeFileStream             = 38;
    private static final int itemTypeScreenSizeFragment     = 39;

    private static final String TAG_LOG = "Main Lifecycle!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG_LOG, "onCreate!");

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
                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
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
                case itemTypeAutoCompleteText: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, AutoCompleteTextViewActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSeekBarAndRatingBar: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SeekBarAndRatingBarActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeDateAndTimePicker: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, DateAndTimePickerActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeProgressBarAndDialog: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ProgressBarAndDialogActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeAlertDialog: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, AlertDialogActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSnackBar: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SnackBarActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeCustomDialog: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, CustomDialogActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSimpleIntent: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SimpleIntentActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSimpleBroadcast: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SimpleBroadcastActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSimpleService: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SimpleServiceActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeActivityLifecycle: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ActivityLifecycleActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeActionBarOptionMenu: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ActionBarMenuActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeActionBarContextMenu: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ActionBarContextMenuActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeActionViewAndItem: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ActionItemAndViewActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeNavigationDrawer: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, NavigationDrawerActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeScrollableSwipe: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ScrollableSwipeActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeTabLayout: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TabLayoutActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeNotification: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, NotificationActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeSQLite: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SQLiteActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeContentProvider: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ContentProviderActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeFileStream: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, FileStreamActivity.class);
                    startActivity(intent);
                }
                    break;
                case itemTypeScreenSizeFragment: {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ScreenSizeFragmentActivity.class);
                    startActivity(intent);
                }
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG_LOG, "onStart!");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Log.d(TAG_LOG, "onPostCreate!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG_LOG, "onResume!");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d(TAG_LOG, "onPostResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG_LOG, "onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG_LOG, "onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG_LOG, "onDestroy!");
    }
}
