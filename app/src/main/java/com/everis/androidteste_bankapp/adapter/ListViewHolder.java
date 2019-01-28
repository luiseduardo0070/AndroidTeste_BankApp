package com.everis.androidteste_bankapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.everis.androidteste_bankapp.R;

class ListViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_title;
    public TextView tv_desc;
    public TextView tv_date;
    public TextView tv_value;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_date = itemView.findViewById(R.id.tv_date);
        tv_desc = itemView.findViewById(R.id.tv_desc);
        tv_value = itemView.findViewById(R.id.tv_value);
    }
}
