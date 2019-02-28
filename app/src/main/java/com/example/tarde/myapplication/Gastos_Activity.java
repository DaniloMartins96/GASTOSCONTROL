package com.example.tarde.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Gastos_Activity extends AppCompatActivity {

    public static final String GASTOS = "gastos";
    public static final String VALOR = "valor";
    private TextView mainGastos;
    private EditText valorGasto;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_);

        mainGastos = findViewById(R.id.mainGastos);
        valorGasto = findViewById(R.id.valorGasto);
        btnInfo = findViewById(R.id.btnInfo);

            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Recuperar valores do formulario
                    //Gerar um objeto
                    String gastos = mainGastos.getText().toString();
                    double valor = Double.parseDouble(valorGasto.getText().toString());

                    Intent intent = new Intent(Gastos_Activity.this,MainActivity.class);
                    intent.putExtra(GASTOS,gastos);
                    intent.putExtra(VALOR,valor);
                    startActivity(intent);



                }
            });
        }
    }


