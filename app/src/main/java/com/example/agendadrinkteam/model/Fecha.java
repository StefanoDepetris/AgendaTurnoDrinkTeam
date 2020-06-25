package com.example.agendadrinkteam.model;


import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

//ESTA READY

public class Fecha {

    private final Dia dia;
    private final LocalDate fecha;



    //------------------------------------CONSTRUCTOR-------------------------------------------------------------------

    public Fecha (LocalDate fecha)
    {
        this.fecha=fecha;
        dia = new Dia(fecha.getDayOfWeek());
    }

    //--------------------------------------METODOS---------------------------------------------------------------------

    public LocalDate getFecha () {
        return fecha;
    } //Devuelve la fecha en LocalDate
    public void cambiarHora(String hora) {
        dia.CambiaEstadoDeHora(hora);
    }
    public boolean verificarHora(String h) {

        return dia.verificar(h);

    } //Verifica en su variable "dia" si la hora esta disponible
    public boolean verificarDisponibilidad(){
        return dia.estaDisponible();
    }
    public String obtenerProximaHora(){
        return dia.ProximaHora();
    }

    @Override
    public String toString() {
        return dia + " " + fecha.getDayOfMonth() +
                    " de " + fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es"));
    }

}
