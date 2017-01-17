package com.example.yenhenchia.projectpractice.ImageListView;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageListViewActivity extends ListActivity {

    private TextView txtListResult;

    private List<Map<String, Object>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list_view);

        this.txtListResult = (TextView)findViewById(R.id.txtListResult);

        this.mList = new ArrayList<Map<String, Object>>();

        String listItemResource[] = getResources().getStringArray(R.array.listItem);

        for (int i = 0; i < listItemResource.length; i++) {

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("imgListIcon", R.drawable.icon_hammer);
            item.put("txtListTitle", listItemResource[i]);

            mList.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mList, R.layout.image_list_item_layout, new String[]{"imgListIcon", "txtListTitle"}, new int[]{R.id.imgListIcon, R.id.txtListTitle});
        setListAdapter(simpleAdapter);

        /*
        ListView listView = getListView();
        listView.setOnItemClickListener(onItemClickListener);
        */
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String s = ((TextView)v.findViewById(R.id.txtListTitle)).getText().toString();

        txtListResult.setText(s);
    }

    /*
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            String s = ((TextView)view.findViewById(R.id.txtListTitle)).getText().toString();

            txtListResult.setText(s);
        }
    };
    */
}
