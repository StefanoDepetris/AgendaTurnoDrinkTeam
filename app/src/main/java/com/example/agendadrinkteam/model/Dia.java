package com.example.agendadrinkteam.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

// ESTA READY

public class Dia {

    //-------------------CONFIGURACION INICIAL (LO MISMO PARA TODAS LAS INSTANCIAS DE DIA)------------------------------

    static private final LocalTime HoraComienzo = LocalTime.parse("08:00");
    static private final Integer DuracionDeTurno = 30;
    static private final Integer CantidadDeTurnos = 9;

    //--------------------------PROPIO DE CADA INSTANCIA DE DIA---------------------------------------------------------

    private DayOfWeek dia;
    private TreeMap<LocalTime, Boolean> horas;

    //------------------------------------CONSTRUCTOR-------------------------------------------------------------------

    public Dia (DayOfWeek dia) {
        this.dia = dia;
        InicializarHoras();
    }

    //--------------------------------------METODOS-------------------------------------------------------------------------

    private void InicializarHoras(){
        horas = new TreeMap<>();
        for (int i = 0; i < CantidadDeTurnos; i++) {
            horas.put(HoraComienzo.plusMinutes(DuracionDeTurno * i), true);
        }
    } // Crea las horas del dia
    public boolean estaDisponible () {
        return horas.containsValue(true);
    } //Te dice si alguna hora de dia está disponible
    public void CambiaEstadoDeHora (String h) {
            Boolean b = !horas.get(LocalTime.parse(h));
            horas.put(LocalTime.parse(h), b);
    } // Cambia el estado (boolean) de una determinada hora
    public boolean verificar (String h) {
        try {
            return horas.get(LocalTime.parse(h));
        } catch (NullPointerException a) {
            a.getStackTrace();
            System.out.println("DIA: La hora introducida es INVALIDA");
            return false;
        } catch (DateTimeParseException a) {
            a.getStackTrace();
            System.out.println("DIA: La hora introducida esta INCOMPLETA");
            return false;
        }
    } //Te dice si una determinada hora está disponible
    public String ProximaHora () {

        for (Map.Entry<LocalTime, Boolean> i : horas.entrySet()) {
            if (horas.get(i.getKey())) {
                horas.put(i.getKey(), false);
                return i.getKey().toString();
            }
        }
        return null;
    } //Te da como String la próxima hora disponible y la pone como ocupada

    @Override
    public String toString() {
        return dia.getDisplayName(TextStyle.FULL,  new Locale("es"));
    }

    //---------------------------------METODOS DE PRUEBAS------------------------------------------------------------------

    public void getDia() {
        System.out.println(dia.getDisplayName(TextStyle.FULL, new Locale("es")));
    } // imprime el nombre del dia
    public TreeMap<LocalTime, Boolean> getHoras(){
        return horas;
    }
    public void imprimirHoras(){
        horas.forEach((k,v) -> System.out.println(k.toString() + " " + v));
    } //  imprime todas las horas y su disponibilidad

}


