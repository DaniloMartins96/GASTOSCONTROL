package com.example.tarde.myapplication;

import java.io.Serializable;

public class Gastos implements Serializable{
    private long idGasto;
    private String descricao;
    private double valor;
    private String data;

    public Gastos(String descricao, double valor, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Gastos(long idGasto, String descricao, double valor, String data) {
        this.idGasto = idGasto;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }


    public long getIdGasto(){
        return idGasto;
    }
    public String getDescricao(){
        return descricao;
    }
    public double getValor(){
        return valor;
    }
    public String getData(){
        return data;
    }

    @Override
    public String toString() {
        return "Seu Gasto\n" +
                "\nidGasto = " + idGasto +
                "\ndescricao = " + descricao +
                "\nvalor = " + valor +"R$"+
                "\ndata = " + data;
    }
}

