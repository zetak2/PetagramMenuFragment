package com.ztkx.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ztkx.petagram.R;
import com.ztkx.petagram.adaptador.MascotaAdaptador;
import com.ztkx.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    MascotaAdaptador adaptador;
    private RecyclerView listaMascotas;

    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas= (RecyclerView) v.findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.bandido,0,"Bandido"));
        mascotas.add(new Mascota(R.drawable.pirata,0,"Pirata"));
        mascotas.add(new Mascota(R.drawable.coffe,0,"Coffe"));
        mascotas.add(new Mascota(R.drawable.donatelo,0,"Donatelo"));
        mascotas.add(new Mascota(R.drawable.fluffy,0,"Fluffy"));
        mascotas.add(new Mascota(R.drawable.lucy,0,"Lucy"));
        mascotas.add(new Mascota(R.drawable.negan,0,"Negan"));
        mascotas.add(new Mascota(R.drawable.pelusa,0,"Pelusa"));

    }

}
