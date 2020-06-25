package com.example.agendadrinkteam.model;


import java.util.HashSet;

public class ObserverAusencia implements Display, Observer {

    private Agenda miAgenda;
    private HashSet<Turno> turnos;
    private Integer ausencias, aux;

    public ObserverAusencia (Agenda miAgenda) {
        this.miAgenda=miAgenda;
        turnos = new HashSet<>();
        ausencias = 0;
        aux = 0;
        miAgenda.registrarObserver(this);
    }

    private void comprobarAusencias() {
        for (Turno t : turnos){
            if (t.getAusente()){
                aux++;
                turnos.remove(t);
            }
        }
        if (ausencias != aux ){
            ausencias = aux;
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("\n" + this);
    }

    @Override
    public void update() {

        turnos.addAll(miAgenda.getTurnos());
        comprobarAusencias();

    }

    @Override
    public String toString() {
        return "OBSERVER AUSENCIAS: " + ausencias + " ausencias totales." + "\n";
    }
}
