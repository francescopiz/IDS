package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.models.GruppoPOI;
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
        gruppo.setNome(nome);
        liste.Save();
    }

    public void addPOI(int gruppoID, int POIID){
        GruppoPOI gruppo = liste.getGruppoPOI(gruppoID);
        gruppo.getListaPOI().add(liste.getPOI(POIID));
        liste.Save();
    }

    public boolean removePOI(int gruppoID, int POIID){
        GruppoPOI gruppo = liste.getGruppo(gruppoID);
        try{
            gruppo.getListaPOI().remove(liste.getPOI(POIID));
            liste.Save();
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public void creaGruppoPOI(ArrayList<POI> listaPOI, String nome){
        liste.addGruppoPOI(nome, listaPOI);
        liste.Save();
    }



}
