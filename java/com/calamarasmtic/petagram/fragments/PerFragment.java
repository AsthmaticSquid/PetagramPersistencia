package com.calamarasmtic.petagram.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calamarasmtic.petagram.R;
import com.calamarasmtic.petagram.adapter.PerfilMascotaAdaptador;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;


public class PerFragment extends Fragment {

    private ArrayList<Mascota> fotosMiPet;
    private RecyclerView rvFotosMiPet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotosMiPet = (RecyclerView) v.findViewById(R.id.rvFotosMiPet);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        //glm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFotosMiPet.setLayoutManager(glm);

        inicializarMascotas();
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador(){
        PerfilMascotaAdaptador adapter = new PerfilMascotaAdaptador(fotosMiPet, getActivity());
        rvFotosMiPet.setAdapter(adapter);
    }

    public void inicializarMascotas(){
        fotosMiPet = new ArrayList<>();

        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 4));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 2));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 1));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 0));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 3));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 5));

    }

}
