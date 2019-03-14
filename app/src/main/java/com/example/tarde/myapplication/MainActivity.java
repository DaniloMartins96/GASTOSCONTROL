package com.example.tarde.myapplication;

import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String LISTA_GASTOS = "listaGastos";
    private ListView listaDeGastos;
    private FloatingActionButton buttonAdd;
    private TextView txtTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaDeGastos = findViewById(R.id.main_lista_gastos);
        buttonAdd = findViewById(R.id.buttonAdd);
        txtTotal = findViewById(R.id.txtTotal);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        Gastos_Activity.class);
                startActivity(intent);
            }
        });


        listaDeGastos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,EdicaoActivity.class);
                Gastos gastos = (Gastos)parent.getItemAtPosition(position);
                intent.putExtra(LISTA_GASTOS, gastos);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();

        GastoDAO gastoDAO = new GastoDAO(this);
        List<Gastos>gastos = gastoDAO.listaTodosGastos();

        double totalGastos = recuperaTotalGastos(gastos);
        ListView listaDeGastos = (ListView) findViewById(R.id.main_lista_gastos) ;
//
//        ArrayAdapter<Gastos> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,gastos);

        AdapterActivity adapter = new AdapterActivity(gastos,this);

        listaDeGastos.setAdapter(adapter);

    }


    private double recuperaTotalGastos(List<Gastos> listaDeGastos) {
        double resultado = 0;
        for (Gastos gastos : listaDeGastos) {
            resultado += listaDeGastos;

        }
    }

}


