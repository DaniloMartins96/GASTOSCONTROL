package com.example.tarde.myapplication;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

class GastosHelper {
    private TextView mainDescricao;
    private EditText valorGasto;
    private EditText mainDate;


    public GastosHelper(Gastos_Activity activity){
        carregaCampos(activity);
    }

    private void carregaCampos(Activity activity) {
        mainDescricao = activity.findViewById(R.id.mainDescricao);
        valorGasto = activity.findViewById(R.id.valorGasto);
        mainDate = activity.findViewById(R.id.mainDate);
    }

    public  Gastos getGastos(){
        String descricao = mainDescricao.getText().toString();
        String valor = double.parseDouble(valorGasto.getText().toString());
        String data = mainDate.getText().toString();

        return new Gastos(descricao ,valor , data);
    }



}

}
