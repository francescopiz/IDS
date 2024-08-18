package com.unicam.ingdelsoftware;

import com.unicam.ingdelsoftware.models.Comune;
import com.unicam.ingdelsoftware.models.Posizione;

import java.util.ArrayList;
import java.util.List;

public class InterfacciaOSM {
    // classe per interfacciarsi a OSM
    //per il momento fittizia

    List<Comune> comuni = new ArrayList<Comune>(){};

    //per inizializzare le liste nella prova
    public void Inizializza(){
        comuni.add( new Comune("Default", 0, "provincia Default" ,new Posizione(0,0)));
    }


    public Comune GetComune(Posizione pos){
        Comune comune = comuni.get(0);
        if(comune == null)
            return new Comune();
        return comune;
    }
}
