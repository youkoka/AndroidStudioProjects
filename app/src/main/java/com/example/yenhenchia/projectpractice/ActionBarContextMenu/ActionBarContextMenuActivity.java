package com.example.yenhenchia.projectpractice.ActionBarContextMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class ActionBarContextMenuActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextView textView;

    private static final int MENU_MUSIC = Menu.FIRST,
            MENU_PALY_MUSIC = Menu.FIRST + 1,
            MENU_STOP_PLAYING_MENU = Menu.FIRST + 2,
            MENU_ABOUT = Menu.FIRST + 3,
            MENU_TEXTLENGTH = Menu.FIRST + 4,
            MENU_EXIT = Menu.FIRST + 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_context_menu);

        this.relativeLayout = (RelativeLayout)findViewById(R.id.activity_action_bar_context_menu);
        registerForContextMenu(this.relativeLayout);

        this.textView = (TextView) findViewById(R.id.txtContextMenu);
        registerForContextMenu(this.textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == this.relativeLayout) {

            if (menu.size() == 0) {

                SubMenu subMenu = menu.addSubMenu(0, MENU_MUSIC, 0, "背景音樂").setIcon(android.R.drawable.ic_media_play);
                subMenu.add(0, MENU_PALY_MUSIC, 0, "播放背景音樂");
                subMenu.add(0, MENU_STOP_PLAYING_MENU, 1, "停止播放背景音樂");

                menu.add(0, MENU_ABOUT, 1, "關於這個程式");
                menu.add(0, MENU_EXIT, 2, "結束");


//                getMenuInflater().inflate(R.menu.context_menu_relative_layout, menu);
            }
        }
        else if(v == this.textView) {

            menu.add(0, MENU_ABOUT, 1, "關於這個程式");
//            getMenuInflater().inflate(R.menu.context_menu_textview, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case MENU_PALY_MUSIC: {

                Log.d("onContextItemSelected", "MENU_PALY_MUSIC");
            }
                break;
            case MENU_STOP_PLAYING_MENU: {

                Log.d("onContextItemSelected", "MENU_STOP_PLAYING_MENU");
            }
                break;
            case MENU_ABOUT: {

                Log.d("onContextItemSelected", "MENU_ABOUT");
            }
                break;
            case MENU_EXIT: {

                Log.d("onContextItemSelected", "MENU_EXIT");
            }
                break;
        }
        /*
        switch (item.getItemId()) {

            case R.id.menuItemPlayBackgroundMusic: {

                Log.d("onContextItemSelected", "menuItemPlayBackgroundMusic");
            }
                break;
            case R.id.menuItemStopBackgroundMusic: {

                Log.d("onContextItemSelected", "menuItemStopBackgroundMusic");
            }
                break;
            case R.id.menuItemAbort: {

                Log.d("onContextItemSelected", "menuItemAbort");
            }
                break;
            case R.id.menuItemExit: {

                Log.d("onContextItemSelected", "menuItemExit");
            }
                break;
        }
        */
        return super.onContextItemSelected(item);
    }
}
