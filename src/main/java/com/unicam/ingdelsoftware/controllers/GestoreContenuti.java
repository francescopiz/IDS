package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.models.Contenuto;
import com.unicam.ingdelsoftware.models.Liste;
import com.unicam.ingdelsoftware.models.POI;

import java.io.File;
import java.util.List;

public class GestoreContenuti {
    Liste liste;

    GestoreContenuti(Liste liste){
        this.liste = liste;
    }

    public void addContenuto(int POIId, String nome, String descrizione, File[] file){
        POI poi = liste.getPOI(POIId);
        List<Contenuto> listaContenuti = poi.getElencoContenuti();
        if( listaContenuti.stream().anyMatch(x->x.getNome().equals(nome)))
            throw new IllegalArgumentException();
        liste.addContenuto(POIId, nome, descrizione, file);
    }

    public void removeContenuto(int contenutoId) {
        liste.removeContenuto(contenutoId);
    }

    public void cambiaNomeContenuto( int POIid ,int contenutoId, String nome ){
        List<Contenuto> listaContenuti = liste.getPOI(POIid).getElencoContenuti();
        if( listaContenuti.stream().anyMatch(x->x.getNome().equals(nome)))
            throw new IllegalArgumentException();
        liste.addContenuto(POIId, nome, descrizione, file);
    }

    public void cambiaDescrizioneContenuto(int contenutoId, String nome ){
        liste.setDescrizioneContenuto();
    }
}
