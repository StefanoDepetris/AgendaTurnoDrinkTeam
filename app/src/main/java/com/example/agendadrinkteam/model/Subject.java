package com.example.agendadrinkteam.model;


public interface Subject {
    void registrarObserver(Observer o);
    void eliminarObserver(Observer o);
    void notificar();
}
