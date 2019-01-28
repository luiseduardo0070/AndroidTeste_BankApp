package com.everis.androidteste_bankapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everis.androidteste_bankapp.R;
import com.everis.androidteste_bankapp.model.statementlist.StatementList;
import com.everis.androidteste_bankapp.util.Format;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<ListViewHolder> {

    private Context context;
    private List<StatementList> statementLists;
    private Format format;

    public AdapterList(Context context, List<StatementList> statementLists){
        this.context = context;
        this.statementLists = statementLists;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celula_data, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        StatementList statementList = statementLists.get(position);
        holder.tv_title.setText(statementList.getTitle());
        holder.tv_desc.setText(statementList.getDesc());
        holder.tv_date.setText(statementList.getDate());
        String value = format.SetCurrencyInstanceInt(statementList.getValue());
        holder.tv_value.setText(value);
    }

    @Override
    public int getItemCount() {
        return statementLists.size();
    }
}
