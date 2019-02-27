package com.example.tarde.myapplication;

import java.io.Serializable;

public class ListaDeGastos implements Serializable{
    private String Gasto;
    private double ValorGasto;

    public ListaDeGastos(String gasto, double valorGasto) {
        Gasto = gasto;
        ValorGasto = valorGasto;



        public String getGasto() {
            return Gasto;
        }
    }
}
