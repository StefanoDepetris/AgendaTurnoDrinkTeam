package com.example.agendadrinkteam.ui.main;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.agendadrinkteam.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


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
        EditText et_hora = view.findViewById(R.id.et_hora);
        Button btn_next = view.findViewById(R.id.btn_next);
        DatePicker picker = view.findViewById(R.id.datePicker);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewModel.addPaciente(et_nombre.getText().toString(),et_dni.getText().toString(),et_tel.getText().toString());

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR,picker.getYear());
                cal.set(Calendar.MONTH,picker.getMonth());
                cal.set(Calendar.DAY_OF_MONTH,picker.getDayOfMonth());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    viewModel.crearTurno(sdf.format(cal.getTime()), et_hora.getText().toString());
                    requireDialog().dismiss();
            }
        });




        return view;
    }
}