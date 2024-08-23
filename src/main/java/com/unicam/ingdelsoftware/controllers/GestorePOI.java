package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.approvabili.Contenuto;
import com.unicam.ingdelsoftware.approvabili.POI;
import com.unicam.ingdelsoftware.approvabili.Posizione;
import com.unicam.ingdelsoftware.models.*;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.unicam.ingdelsoftware.controllers.Contesto.getComuneFromPosition;

public class GestorePOI {

    private  Liste liste;
    public GestorePOI (Liste liste) {
        this.liste = liste;
    }

    public boolean CreaPOI(String nome, Posizione posizione ){
        Comune comune = getComuneFromPosition(posizione);
        POI poi = liste.getPOIInComune(comune.getId(), nome);
        if(poi != null)
            return false;
        liste.addPOI(nome, posizione);
        return true;
    }

    public boolean CreaPOI(String nome, Posizione posizione, Date dataInizio, Date dataFine){
        Comune comune = getComuneFromPosition(posizione);
        POI poi = liste.getPOIInComune(comune.getId(), nome);
        if(poi != null)
            return false;
        liste.addPOI(nome, posizione, dataInizio, dataFine);
        return true;
    }

    public void SetPosizione(int POIId, Posizione pos){
        POI poi = liste.getPOI(POIId);

        Comune comune1 = liste.getComuneFromPosition(pos);
        Comune comune2 = liste.getComuneFromPosition( poi.getPosizione());
        if(comune1 == comune2)
            throw new IllegalArgumentException();
        //poi.setPosizione(pos); // devo farlo fare alla repository
    }

    public boolean AddContenuto(int POIId, String nome, String descrizione, File[] file){
        POI poi = liste.getPOI(POIId);
        List<Contenuto> listCont = poi.getElencoContenuti();
        for (Contenuto item: listCont) {
            if(Objects.equals(item.getNome(), nome))
                return false;
        }
        try {
            liste.addContenuto(POIId, nome, descrizione, file);
            liste.Save();
            return true;
        }
        catch (Exception ignored){}
            return false;
    }

/*
    public boolean IscrizioneEvento(int idEvento, int idUtente ){
        POI poi = liste.getPOI(idEvento);
        if(poi.getClass()!=Evento.class)
            return false;
        Evento evento = (Evento) poi;
        List<Integer> listaIscritti = evento.getListaIscritti();
        if(listaIscritti.contains(idUtente))
            return false;
        if(!evento.EventoPrivato())
        {
            return evento.iscriviUtente(idUtente);
        }
        List<Integer> listaAmmessi = evento.getListaAmmessi();
        if(listaIscritti.contains(idUtente)) {
            evento.iscriviUtente(idUtente);
            return true;
        }
        return false;
    }
*/

    public boolean SetNome(int POIId, String nome){
        POI poi = liste.getPOI(POIId);
        Comune comune = liste.getComuneFromPosition(poi.getPosizione());
        List<POI> listaPOIComune = liste.getPOIsFromComune(comune);
        if (listaPOIComune.stream().anyMatch(x -> x.getNome().equals(nome)))
            return false;
        liste.SetNomePOI(POIId, nome);// TODO prendo questo come esempio, ma poi questo tipo di metodi
        //dovranno essere cambiati con change seguito da save, come se fosse un db
        //quindi potrebbero poi venire compressi tutti in un metodo, poi bisogna vedere
        return true;
    }
}
