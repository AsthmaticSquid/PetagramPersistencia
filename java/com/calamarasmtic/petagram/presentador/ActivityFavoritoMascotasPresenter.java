package com.calamarasmtic.petagram.presentador;

import android.content.Context;

import com.calamarasmtic.petagram.IActivityFavoritoMascotas;
import com.calamarasmtic.petagram.db.ConstructorMascotas;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 14/11/2016.
 */

public class ActivityFavoritoMascotasPresenter implements IActivityFavoritoMascotasPresenter {

    private IActivityFavoritoMascotas iActivityFavoritoMascotas;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> pets;

    public ActivityFavoritoMascotasPresenter(IActivityFavoritoMascotas iActivityFavoritoMascotas, Context context) {
        this.iActivityFavoritoMascotas = iActivityFavoritoMascotas;
        this.context = context;
        obtenerMascotasFavs();
    }

    @Override
    public void obtenerMascotasFavs() {
        constructorMascotas = new ConstructorMascotas(context);
        pets = constructorMascotas.obtenerDatosFavs();
        mostrarMascotasFavs();
    }

    @Override
    public void mostrarMascotasFavs() {
        iActivityFavoritoMascotas.inicializarAdaptador(iActivityFavoritoMascotas.crearAdaptador(pets));
        iActivityFavoritoMascotas.generarLinearLayoutVertical();
    }
}
