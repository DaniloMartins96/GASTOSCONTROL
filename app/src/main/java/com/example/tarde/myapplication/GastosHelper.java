package com.example.tarde.myapplication;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

class GastosHelper {
    private TextView mainDescricao;
    private EditText valorGasto;
    private EditText mainDate;
    private Gastos gasto;


    public GastosHelper(Gastos_Activity activity){
        carregaCampos(activity);
    }


    public GastosHelper(EdicaoActivity activity){
        carregaCampos(activity);
    }

    public void carregaCampos(Gastos gastos) {
        this.gasto = gastos;
        mainDescricao.setText(gastos.getDescricao());
        valorGasto.setText(String.valueOf(gastos.getValor()));
        mainDate.setText(gastos.getData());
    }


    private void carregaCampos(Activity activity) {
        mainDescricao = activity.findViewById(R.id.mainDescricao);
        valorGasto = activity.findViewById(R.id.valorGasto);
        mainDate = activity.findViewById(R.id.mainDate);
    }


    public  Gastos getGastos(){
        String descricao = mainDescricao.getText().toString();
        double valor = Double.parseDouble(valorGasto.getText().toString());
        String data = mainDate.getText().toString();
        if (gasto != null) {
            return new Gastos(this.gasto.getIdGasto(),descricao ,valor , data);
        }

        return new Gastos(descricao ,valor , data);
    }



}

