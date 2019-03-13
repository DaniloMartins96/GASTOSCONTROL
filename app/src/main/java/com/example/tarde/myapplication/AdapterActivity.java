package com.example.tarde.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterActivity extends BaseAdapter {
    public static final double LINHA_AFETADA = 1;
    private final List<Gastos> gastoslista;
    private final Activity act;

    public AdapterActivity(List<Gastos> gastos, Activity ect, Activity act) {
        this.gastoslista = gastos;
        this.act = act;
    }

    public AdapterActivity(List<Gastos> gastos, MainActivity mainActivity) {
        this.gastoslista = gastos;
        this.act = mainActivity;
    }

    @Override
    public int getCount() {
        return gastoslista.size();
    }

    @Override
    public Object getItem(int position) {
        return gastoslista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return gastoslista.get(position).getIdGasto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_lista,parent,false);
        Gastos gastos = gastoslista.get(position);

        //pegando as referencias da views
        TextView editListDescricao = (TextView)
        view.findViewById(R.id.editListDescricao);
        TextView editListValor = (TextView)
        view.findViewById(R.id.editListValor);
        TextView editListData = (TextView)
        view.findViewById(R.id.editListData);
        FloatingActionButton btnExcluir = (FloatingActionButton)
        view.findViewById(R.id.btnExcluir);

        //populando as views
        editListDescricao.setText(gastos.getDescricao());
        editListValor.setText(String.valueOf(gastos.getValor()));
        editListData.setText(gastos.getData());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act,EdicaoActivity.class);
                act.startActivity(intent);
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(act, "Arquivo Excluido", Toast.LENGTH_SHORT).show();
                getItemId(position);

            }
        });




        return view;

    }
}
