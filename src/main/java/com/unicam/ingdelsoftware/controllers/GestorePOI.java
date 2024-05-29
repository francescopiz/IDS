package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.models.*;

import java.util.List;

public class GestorePOI {

    private  Liste liste;
    public GestorePOI (Liste liste) {
        this.liste = liste;
    }

    public void CreaPOI(String nome, Posizione posizione ){
        Comune comune = liste.getComuneFromPosition(posizione);
        POI poi = liste.getPOI(comune, nome);
        if(poi != null)
            throw new IllegalArgumentException();
        liste.addPOI( nome, posizione);
    }

    public void SetPosizione(int POIId, Posizione pos){
        POI poi = liste.getPOI(POIId);

        Comune comune1 = liste.getComuneFromPosition(pos);
        Comune comune2 = liste.getComuneFromPosition( poi.getPosizione());
        if(comune1 == comune2)
            throw new IllegalArgumentException();
        poi.setPosizione(pos); // devo farlo fare alla repository
    }

    public void AddContenuto(int POIId, Contenuto cont){
        POI poi = liste.getPOI(POIId);
        List<Contenuto> listCont = poi.getElencoContenuti();
        if(listCont.contains(cont))
            throw new IllegalArgumentException();
        liste.addContenuto(poi, cont);
    }

    public void SetNome(int POIId, String nome){
        POI poi = liste.getPOi(POIId);
        Comune comune = liste.getComuneFromPosition(poi.getPosizione());
        List<POI> listaPOIComune = liste.getPOIsFromComune(comune);
        if (listaPOIComune.stream().anyMatch(x -> x.getNome().equals(nome)))
            throw new IllegalArgumentException();
        liste.ChangePOI()//metti il nome in qualche modo
    }

}
