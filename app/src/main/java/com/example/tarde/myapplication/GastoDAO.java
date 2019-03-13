package com.example.tarde.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GastoDAO extends SQLiteOpenHelper {



    public GastoDAO(Context context) {
        super(context, "BancoGastos", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Gastos(" +
                "idGasto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "descricao Text NOT NULL, " +
                "valor DOUBLE NOT NULL, " +
                "data Text NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private ContentValues getContentValues(Gastos gastos) {
        ContentValues dados = new ContentValues();
        dados.put("descricao", gastos.getDescricao());
        dados.put("valor", gastos.getValor());
        dados.put("data", gastos.getData());

        return dados;
    }

    public int editar(Gastos gastos) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(gastos);
        String selection = "idGasto = ?";
        String[] args = {String.valueOf(gastos.getIdGasto())};

        int resultado = db.update("gastos", dados, selection, args);
        db.close();
        return resultado;
    }

    public int deletar(long idGastos) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "idGastos = ?";
        String[] args = {String.valueOf(idGastos)};

        int resultado = db.delete("Gastos", selection, args);
        db.close();
        return resultado;

    }


    public long inserir(Gastos gastos) {
        ContentValues dados = new ContentValues();
        dados.put("Descricao", gastos.getDescricao());
        dados.put("Valor", gastos.getValor());
        dados.put("Data", gastos.getData());

        SQLiteDatabase db = getWritableDatabase();
        return db.insert("gastos", null, dados);

    }

    public List<Gastos> listaTodosGastos() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM gastos";
        Cursor cursor = db.rawQuery(sql, null);

        List<Gastos> listaGastos = new ArrayList<>();

        while (cursor.moveToNext()) {
            long idGasto = cursor.getLong(cursor.getColumnIndex("idGasto"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            double valor = Double.parseDouble(cursor.getString(cursor.getColumnIndex("valor")));
            String data = cursor.getString(cursor.getColumnIndex("data"));

            Gastos gastos = new Gastos(idGasto, descricao, valor, data);
            listaGastos.add(gastos);
        }

        return listaGastos;


    }
}
