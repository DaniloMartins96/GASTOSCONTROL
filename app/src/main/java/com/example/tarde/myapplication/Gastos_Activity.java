package com.example.tarde.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Gastos_Activity extends AppCompatActivity {

    private GastosHelper Helper;
    private Button btnInfo;
    private GastoDAO gastoDAO;
    private TextView editTitulo;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(Gastos_Activity.this,MainActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_);

        editTitulo = findViewById(R.id.editTitulo);
        editTitulo.setText("INFORME SEUS GASTOS");
        btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setText("CONFIRMAR");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("NEED CONTROL");

        Helper = new GastosHelper(this);
        gastoDAO = new GastoDAO(this);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperar valores de formulario
                //gerar um objeto
                Gastos gastos = Helper.getGastos();
                if (gastoDAO.inserir(gastos) == -1) {
                    Toast.makeText(Gastos_Activity.this, "nao inseriu", Toast.LENGTH_LONG).show();
                } else {
                    finish();
                }
            }
        });
    }
}



