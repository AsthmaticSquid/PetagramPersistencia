package com.calamarasmtic.petagram.presentador;

import android.content.Context;

import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.db.ConstructorMascotas;
import com.calamarasmtic.petagram.fragments.IRecyclerViewFragmentView;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 13/11/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> pets;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        pets = constructorMascotas.obtenerDatos();
        mostrarMascotasEnRecyclerView();
    }

    @Override
    public void mostrarMascotasEnRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(pets));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
