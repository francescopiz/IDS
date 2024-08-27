package com.unicam.IDS;


import com.unicam.IDS.models.approvabili.Posizione;

import java.io.IOException;

public class ServizioOSM implements InterfacciaOSM{

    @Override
    public String getInfoPunto(Posizione posizione) throws IOException {
        return "";
    }

    @Override
    public Posizione getPosizione(String comune) throws IOException {
        return null;
    }
}
