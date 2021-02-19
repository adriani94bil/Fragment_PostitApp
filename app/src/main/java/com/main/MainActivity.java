package com.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.main.model.Nota;
import com.main.ui.FragmentDetalle;
import com.main.ui.FragmentLista;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    FragmentDetalle mFragmentDetalle;
    FragmentLista mFragmentLista;
    ArrayList<Nota> listaNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarNotas();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        mFragmentLista=FragmentLista.newInstance(listaNotas);
        mFragmentDetalle=FragmentDetalle.newInstance(listaNotas.get(0));

        fragmentTransaction.add(R.id.lista,mFragmentLista);
        fragmentTransaction.add(R.id.detalle,mFragmentDetalle);
        fragmentTransaction.commit();

        mFragmentLista.setOnListaSelectedListener(new FragmentLista.OnListaSelectedListener() {
            @Override
            public void onNotaListaSeleccionado(Nota nota) {
                enviarDetalleNota(nota);
            }
        });


    }
    private void enviarDetalleNota(Nota nota){
        mFragmentDetalle.verDetalleSeleccionado(nota);
    }
    public void cargarNotas(){
        listaNotas =new ArrayList<>();
        listaNotas.add(new Nota("Llamar cliente","Laura R"));
        listaNotas.add(new Nota("Hacer pedido","Laura R"));
        listaNotas.add(new Nota("Generar Informe","Laura R"));
    }
}