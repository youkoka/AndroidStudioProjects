package com.example.yenhenchia.projectpractice.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by yenhenchia on 2017/1/18.
 */

public class RecycleViewItemAdapter extends RecyclerView.Adapter<RecycleViewItemAdapter.ViewHolder>{

    private List<String> mListString;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imgView;
        public TextView txtTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            this.imgView = (ImageView)itemView.findViewById(R.id.imgView);
            this.txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(), mListString.get(getAdapterPosition()), Toast.LENGTH_LONG).show();
        }
    }

    public RecycleViewItemAdapter(List<String> listString) {

        this.mListString = listString;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

//        int height = parent.getMeasuredHeight() / mListString.size();

//        itemView.setMinimumHeight(height);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imgView.setImageResource(android.R.drawable.star_on);
        holder.txtTitle.setText(mListString.get(position));
    }

    @Override

    public int getItemCount() {

        return this.mListString.size();
    }
}
