package com.example.tarde.myapplication;

public class Gastos {
    private long idGasto;
    private String descricao;
    private double valor;
    private String data;

    public Gastos(String descricao, double valor, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Gastos(long idGasto, String descricao) {
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
        return "Gastos\n" +
                "\nidGasto = " + idGasto +
                "\ndescricao = " + descricao +
                "\nvalor = " + valor +
                "\ndata = " + data;
    }
}

