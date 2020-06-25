package com.example.agendadrinkteam.model;

public class TarjetaCredito implements FormaDePago {

    public void pagar() {
        System.out.println(this);
    }
    public String toString(){
        return "Pago con credito";
    }
}
