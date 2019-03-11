package com.example.tarde.myapplication;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class AdapterActivity extends BaseAdapter {
    private final List<Gastos> gastos;
    private final Activity act;

    public AdapterActivity(List<Gastos> gastos, Activity ect, Activity act) {
        this.gastos = gastos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return gastos.size();
    }

    @Override
    public Object getItem(int position) {
        return gastos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return gastos.get(position).getIdGasto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_lista,parent,false);
        Gastos gastos = gastos.get(position);
        return null;
    }
}
