package com.example.agendadrinkteam.model;



public class TarjetaDebito implements FormaDePago {

    public void pagar() {
        System.out.println(this);
    }
    public String toString(){
        return "Pago con debito";
    }
}
