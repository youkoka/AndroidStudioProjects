package com.example.yenhenchia.projectpractice.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.yenhenchia.projectpractice.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAndCardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_and_card_view);

        List<String> list = new ArrayList<>();

        for (int i = 0; i != 16; i++) {

            list.add(new String("第 " + String.valueOf(i + 1) + " 項"));
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleView);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.VERTICAL));
        RecycleViewItemAdapter itemAdapter = new RecycleViewItemAdapter(list);
        recyclerView.setAdapter(itemAdapter);
    }
}
