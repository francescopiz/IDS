package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.models.Liste;
import com.unicam.ingdelsoftware.models.POI;

import java.util.ArrayList;


public class GestoreGruppoPOI {

    Liste liste;

    GestoreGruppoPOI (Liste liste){
        this.liste = liste;
    }



    public void SetNome(int POIId, String nome){
        GruppoPOI gruppo = liste.getGruppoPOI(POIId);
        gruppo.nome = nome;
        liste.Save();
    }

    public void addPOI(int gruppoID, int POIID){
        GruppoPOI gruppo = liste.getGruppoPOI(gruppoID);
        gruppo.listaPOI.add(liste.getPOI(POIID));
        liste.Save();
    }

    public boolean removePOI(int gruppoID, int POIID){
        GruppoPOI gruppo = liste.getGruppo(gruppoID);
        try{
            gruppo.listaPOI.remove(liste.getPOI(POIID));
            liste.Save();
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public void creaGruppoPOI(ArrayList<POI> listaPOI, String nome){
        GruppoPOI gruppo = new GruppoPOI(nome, listaPOI);
        liste.GetListaGruppoPOI.add(gruppo);
        liste.Save();
    }



}
