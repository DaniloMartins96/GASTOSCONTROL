package com.example.tarde.myapplication;

import java.io.Serializable;

public class Gastos implements Serializable{
    private long idGastos;
    private String descricao;
    private double valor;
    private String data;

    public Gastos(String descricao, double valor, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Gastos(long idGastos, String descricao, double valor, String data) {
        this.idGastos = idGastos;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }



    public long getIdGastos(){
        return idGastos;
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
                "\nidGasto = " + idGastos +
                "\ndescricao = " + descricao +
                "\nvalor = " + valor +"R$"+
                "\ndata = " + data;
    }
}
