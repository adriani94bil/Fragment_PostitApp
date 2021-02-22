package com.main.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.main.R;
import com.main.model.Nota;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLista extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LISTA_NOTAS = "LISTANOTAS";

    // TODO: Rename and change types of parameters
    private List<Nota> listaNotas;

    public FragmentLista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param listaNotas Parameter 1.
     * @return A new instance of fragment FragmentLista.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLista newInstance(ArrayList<Nota> listaNotas) {
        FragmentLista fragment = new FragmentLista();
        Bundle args = new Bundle();
        args.putSerializable(ARG_LISTA_NOTAS, listaNotas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listaNotas = (List<Nota>)(getArguments().getSerializable(ARG_LISTA_NOTAS));
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    //Crear oyente para seleccionar en la lista en el MainActivity
    //Pasar un lsitener que se ejecuta al seleccionar un elemento de la lista
    //Para ello creo la interfaz

    public interface OnListaSelectedListener{
        public void onNotaListaSeleccionado(Nota nota);
    }

    private OnListaSelectedListener listener=null;

    public void setOnListaSelectedListener(OnListaSelectedListener listener){
        this.listener=listener;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!=null){
            listaNotas=(List<Nota>)getArguments().getSerializable(ARG_LISTA_NOTAS);
        }
        ArrayAdapter<Nota> notasAdapter=new ArrayAdapter<Nota>(getActivity(),
                android.R.layout.simple_list_item_1,listaNotas);
        setListAdapter(notasAdapter);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (listener !=null){
                    listener.onNotaListaSeleccionado(listaNotas.get(i));
                }
            }
        });
    }
}