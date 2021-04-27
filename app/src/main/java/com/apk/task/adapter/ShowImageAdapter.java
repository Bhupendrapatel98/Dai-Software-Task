package com.apk.task.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.apk.task.ui.FullImageActivity;
import com.apk.task.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.ViewHolder> {

    Context context;
    ArrayList<String> stringArrayList;

    public ShowImageAdapter(Context context, ArrayList<String> stringArrayList) {
        this.context = context;
        this.stringArrayList = stringArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_image_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context)
                .load(stringArrayList.get(position))
                .placeholder(R.color.codeGray)
                .centerCrop()
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, FullImageActivity.class).putExtra("image", stringArrayList.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
