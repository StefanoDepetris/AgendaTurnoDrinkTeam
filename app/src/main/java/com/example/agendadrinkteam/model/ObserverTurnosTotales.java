package com.example.agendadrinkteam.model;

import java.util.List;

public class ObserverTurnosTotales implements Display, Observer {



    Agenda miAgenda;
    private Integer turnos;
    private Runnable mRunnable;

    public ObserverTurnosTotales (Agenda a,Runnable runnable) {
        miAgenda = a;
        miAgenda.registrarObserver(this);
        mRunnable = runnable;
        turnos = 0;
    }

    @Override
    public void display() {
        mRunnable.run();
    }

    @Override
    public void update(){
        //if (turnos != miAgenda.cantidadTurnos()){
          //  turnos = miAgenda.cantidadTurnos();
            display();
        //}
    }

    @Override
    public String toString() {
        return "OBSERVER TURNOS: " + turnos + " turnos totales." + "\n";
    }

}
