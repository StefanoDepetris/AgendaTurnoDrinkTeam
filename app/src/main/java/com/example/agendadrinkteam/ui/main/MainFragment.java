package com.example.agendadrinkteam.ui.main;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.agendadrinkteam.R;
import com.example.agendadrinkteam.model.Agenda;
import com.example.agendadrinkteam.model.ObserverTurnosTotales;
import com.example.agendadrinkteam.model.Turno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";
    private MainViewModel mViewModel;



    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        ListView listView = requireView().findViewById(R.id.list);

        ObserverTurnosTotales observerTurnosTotales = new ObserverTurnosTotales(mViewModel.agenda,() -> {

            List<String> lista = new ArrayList<>();
            for (Turno turno : mViewModel.getListaTurno()) {
                lista.add("Turno para: " + turno.getFecha() + " " + turno.getHora());
            }

            listView.setAdapter(new ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,lista));
        });

        mViewModel.addPaciente("hoasd","564","65465");

        mViewModel.crearTurno("2020-07-25", "12:00");

        mViewModel.addPaciente("hoa","564","65465");

        mViewModel.crearTurno("2020-08-25", "12:00");

        /*mViewModel.addPaciente("asdf","234","234");
        mViewModel.crearTurno("2020-08-26", "12:00");*/


        Log.e(TAG, "onActivityCreated: cantidad de turnos creados:  " + mViewModel.getListaTurno().size() );



        requireView().findViewById(R.id.btn_add_turno).setOnClickListener(view -> {
            new CrearTurnoFragment().show(getParentFragmentManager(), "crearTurno");
        });

    }

    @Override
    public void onResume() {
        super.onResume();







    }
}