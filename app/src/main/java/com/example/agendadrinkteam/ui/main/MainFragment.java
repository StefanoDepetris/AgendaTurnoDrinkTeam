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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.agendadrinkteam.R;
import com.example.agendadrinkteam.model.Agenda;
import com.example.agendadrinkteam.model.Efectivo;
import com.example.agendadrinkteam.model.FormaDePago;
import com.example.agendadrinkteam.model.ObserverTurnosTotales;
import com.example.agendadrinkteam.model.TarjetaCredito;
import com.example.agendadrinkteam.model.TarjetaDebito;
import com.example.agendadrinkteam.model.Turno;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";
    private MainViewModel mViewModel;
    private List<Turno> listaTurno = new ArrayList<>();
    private FormaDePago mFormaDePago;


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


            listaTurno = mViewModel.getListaTurno();

            listView.setAdapter(new ArrayAdapter<>(requireContext(),android.R.layout.simple_list_item_1,listaTurno));
        });

        mViewModel.addPaciente("Juan Blanco","564","65465");

        mViewModel.crearTurno("2020-07-25", "12:00");

        mViewModel.addPaciente("Martin Blasco","564","65465");

        mViewModel.crearTurno("2020-08-25", "12:00");

        
        listView.setOnItemClickListener((adapterView, view, pos, l) -> {
            Turno item = listaTurno.get(pos);

            new MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Turno")
                    .setMessage(listaTurno.get(pos).toString())
                    .setNegativeButton("Cancelar turno",(dialogInterface, i) -> {
                        mViewModel.agenda.quitarTurno(item.getID());
                        dialogInterface.dismiss();
                    })
                    .setPositiveButton("Pagar",(dialogInterface, i) -> {
                        item.setFormaPago(mFormaDePago);
                        mViewModel.agenda.pagar(item.getID());
                    })
                    .show();
        });


        requireView().findViewById(R.id.btn_add_turno).setOnClickListener(view -> {
            new CrearTurnoFragment().show(getParentFragmentManager(), "crearTurno");
        });


        Spinner spinner =  requireView().findViewById(R.id.metodo_pago);
        List<String> metodoPagoList = new ArrayList<>();
        metodoPagoList.add("Tarjeta de crédito");
        metodoPagoList.add("Tarjeta de débito");
        metodoPagoList.add("Efectivo");
        spinner.setAdapter(new ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,metodoPagoList));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos) {
                    case 0:
                        mFormaDePago = new TarjetaCredito();
                        break;
                    case 1:
                        mFormaDePago = new TarjetaDebito();
                        break;
                    case 2:
                        mFormaDePago = new Efectivo();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}