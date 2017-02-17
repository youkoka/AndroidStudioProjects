package com.example.yenhenchia.projectpractice.ActionItemAndView;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.app.AlertDialog;

import com.example.yenhenchia.projectpractice.R;

public class ActionItemAndViewActivity extends AppCompatActivity {

    private Spinner spnRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_item_and_view);

        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide(); //! 隱藏 Action bar
//        actionBar.setDisplayShowTitleEnabled(false); //! 隱藏 Action bar title

        //! set action bar logo
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //! show back arrow
        actionBar.setDisplayHomeAsUpEnabled(true);

        //! set background color
        actionBar.setBackgroundDrawable(new ColorDrawable(0xFF505050));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar_view_layout, menu);

        spnRegion = (Spinner) menu.findItem(R.id.menuItemRegion).getActionView().findViewById(R.id.spnRegion);

        ArrayAdapter<CharSequence> arrayAdapterRegion = ArrayAdapter.createFromResource(this, R.array.regionList, android.R.layout.simple_spinner_item);
        spnRegion.setAdapter(arrayAdapterRegion);
        spnRegion.setOnItemSelectedListener(onSpinnerSelectedListener);

        SearchView searchView = (SearchView) menu.findItem(R.id.menuItemSearch).getActionView();
        searchView.setOnQueryTextListener(onSearchQueryTextListen);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home: {

                Toast.makeText(this, "Back button clicked", Toast.LENGTH_LONG).show();

//                onBackPressed();
            }
                break;
            case R.id.menuItemRegion: {

                AlertDialog.Builder alertBuider = new AlertDialog.Builder(this);
                alertBuider.setTitle("Region!");
                alertBuider.setMessage("menuItemRegion");
                alertBuider.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertBuider.show();
            }
                break;
            case R.id.menuItemSearch: {

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setTitle("Search!");
                alertBuilder.setMessage("menuItemSearch");
                alertBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertBuilder.show();
            }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private Spinner.OnItemSelectedListener onSpinnerSelectedListener = new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(ActionItemAndViewActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private SearchView.OnQueryTextListener onSearchQueryTextListen = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            Toast.makeText(ActionItemAndViewActivity.this, query, Toast.LENGTH_SHORT).show();

            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            return false;
        }
    };
}
