package com.example.tarde.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Gastos_Activity extends AppCompatActivity {

    private GastosHelper Helper
    private TextView mainDescricao;
    private EditText valorGasto;
    private EditText mainDate;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_);

        mainDescricao = findViewById(R.id.mainDescricao);
        valorGasto = findViewById(R.id.valorGasto);
        btnInfo = findViewById(R.id.btnInfo);

            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //recuperar valores de formulario
                    //gerar um objeto
                    Gastos gastos = Helper.getGastos();





                }
            });
        }
    }


