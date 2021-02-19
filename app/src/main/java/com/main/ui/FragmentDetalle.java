package com.main.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.main.R;
import com.main.model.Nota;

import java.text.DateFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDetalle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDetalle extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NOTA = "NOTA";

    // TODO: Rename and change types of parameters
    private Nota nota;

    public FragmentDetalle() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentDetalle.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDetalle newInstance(Nota param1) {
        FragmentDetalle fragment = new FragmentDetalle();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTA, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nota = (Nota)(getArguments().getSerializable(ARG_NOTA));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void verDetalleSeleccionado(Nota nota){
        TextView textViewMsg=getView().findViewById(R.id.textViewDescripcion);
        TextView textViewAutor=getView().findViewById(R.id.textViewAutor);
        TextView textViewFecha=getView().findViewById(R.id.textViewFechaCreacion);

        textViewMsg.setText(nota.getMensaje());
        textViewAutor.setText(nota.getAutor());
        DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT);
        textViewFecha.setText(df.format(nota.getFechaCreacion()));
    }
}