package com.example.agendadrinkteam.ui.main;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.agendadrinkteam.R;


public class CrearTurnoFragment extends DialogFragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_crear_turno, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        EditText et_nombre = view.findViewById(R.id.et_nombre);
        EditText et_dni = view.findViewById(R.id.et_dni);
        EditText et_tel = view.findViewById(R.id.et_tel);
        Button btn_next = view.findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewModel.addPaciente(et_nombre.getText().toString(),et_dni.getText().toString(),et_tel.getText().toString());
                    viewModel.crearTurno("2020-08-26", "12:00");
                    requireDialog().dismiss();
            }
        });




        return view;
    }
}