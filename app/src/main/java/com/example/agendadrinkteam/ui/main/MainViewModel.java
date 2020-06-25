package com.example.agendadrinkteam.ui.main;

import androidx.lifecycle.ViewModel;

import com.example.agendadrinkteam.model.Agenda;
import com.example.agendadrinkteam.model.ObserverTurnosTotales;
import com.example.agendadrinkteam.model.Turno;
import com.example.agendadrinkteam.util.SingleScanner;

import java.util.List;
import java.util.Scanner;

public class MainViewModel extends ViewModel {


    public Agenda agenda = new Agenda();


    public List<Turno> getListaTurno() {
        return agenda.getTurnos();
    }

    public boolean crearTurno(String fecha,String hora) {
        return agenda.crearTurno(fecha,hora);
    }

    public void addPaciente(String nombre, String dni, String telefono) {
        SingleScanner.getInstance().input = nombre+"\n"+dni+"\n"+telefono;
    }


}