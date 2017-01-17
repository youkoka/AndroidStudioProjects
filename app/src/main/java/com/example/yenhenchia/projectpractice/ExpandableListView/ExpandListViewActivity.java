package com.example.yenhenchia.projectpractice.ExpandableListView;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandListViewActivity extends ExpandableListActivity {

    private static final String ITEM_NAME       = "Item Name";
    private static final String ITEM_SUBNAME    = "Item Subname";

    private TextView txtResultTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list_view);

        this.txtResultTitle = (TextView)findViewById(R.id.txtListTitle);

        List<Map<String, String>> groupList = new ArrayList<Map<String, String>>();

        List<List<Map<String, String>>> childList2D = new ArrayList<List<Map<String,String>>>();

        for (int i = 0; i != 5; i++) {

            Map<String, String> group = new HashMap<String, String>();
            group.put(ITEM_NAME, "Group : " + i);
            group.put(ITEM_SUBNAME, "Describe : " + i);
            groupList.add(group);

            List<Map<String, String>> childList = new ArrayList<>();

            for (int j = 0; j != 2; j++) {

                Map<String, String> child = new HashMap<>();
                child.put(ITEM_NAME, "SubTitle : " + i + "-" + j);
                child.put(ITEM_SUBNAME, "SubDescribe : " + i + "-" + j);
                childList.add(child);
            }

            childList2D.add(childList);
        }

        ExpandableListAdapter expandableListAdapter = new SimpleExpandableListAdapter(this, groupList, android.R.layout.simple_expandable_list_item_2,
                new String[]{ITEM_NAME, ITEM_SUBNAME}, new int[]{android.R.id.text1, android.R.id.text2}, childList2D, android.R.layout.simple_expandable_list_item_2,
                new String[]{ITEM_NAME, ITEM_SUBNAME}, new int[]{android.R.id.text1, android.R.id.text2});

        setListAdapter(expandableListAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        String s = "Group : " + groupPosition + " SubTitle : " + childPosition + " id : " + id;
        txtResultTitle.setText(s);

        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }
}
