package com.unicam.IDS.controllers;

import com.unicam.IDS.models.approvabili.Contenuto;
import com.unicam.IDS.models.Liste;
import com.unicam.IDS.models.approvabili.POI;

import java.io.File;
import java.util.List;

public class GestoreContenuti {
    Liste liste;

    GestoreContenuti(Liste liste){
        this.liste = liste;
    }

    //da mettere nel gestore POI
    public void addContenuto(int POIId, String nome, String descrizione, File[] file){
        POI poi = liste.getPOI(POIId);
        List<Contenuto> listaContenuti = poi.getElencoContenuti();
        if( listaContenuti.stream().anyMatch(x->x.getNome().equals(nome)))
            throw new IllegalArgumentException();
        liste.addContenuto(POIId, nome, descrizione, file);
    }

    //da mettere nel gestore POI
    public void removeContenuto(int contenutoId) {
        liste.removeContenuto(contenutoId);
    }

    //da mettere nel gestore POI
    public void cambiaNomeContenuto( int POIid ,int contenutoId, String nome ){
        List<Contenuto> listaContenuti = liste.getPOI(POIid).getElencoContenuti();
        if( listaContenuti.stream().anyMatch(x->x.getNome().equals(nome)))
            throw new IllegalArgumentException();
        liste.changeNomeContenuto(POIid, contenutoId, nome );
    }

    public void cambiaDescrizioneContenuto(int contenutoId, String descrizione ){
        liste.setDescrizioneContenuto(contenutoId, descrizione);
    }
}
