package com.example.yenhenchia.projectpractice.NavigationDrawer;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.RecyclerView.RecycleViewItemAdapter;

import java.util.List;

/**
 * Created by yenhenchia on 2017/2/20.
 */

public class LeftNavDrawerRecycleViewItem extends RecyclerView.Adapter<LeftNavDrawerRecycleViewItem.ViewHolder> {

    public String[] mStringList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleView;

        public ViewHolder(View itemView) {

            super(itemView);

            titleView = (TextView)itemView.findViewById(R.id.leftDrawerTitle);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            Toast.makeText(v.getContext(), mStringList[getAdapterPosition()], Toast.LENGTH_SHORT).show();
        }
    }

    public LeftNavDrawerRecycleViewItem(String[] list) {

        mStringList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_drawer_recycle_view_item, parent, false);

        LeftNavDrawerRecycleViewItem.ViewHolder viewHolder = new LeftNavDrawerRecycleViewItem.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.titleView.setText(mStringList[position]);
    }

    @Override
    public int getItemCount() {
        return mStringList.length;
    }

}
