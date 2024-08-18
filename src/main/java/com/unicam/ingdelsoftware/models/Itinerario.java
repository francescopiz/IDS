package com.unicam.ingdelsoftware.models;

import java.util.List;

public class Itinerario extends GruppoPOI {


    public Itinerario(String nome, int id, List<POI> listaPOI) {
        super(nome, id, listaPOI);
    }

    public POI PuntoIniziale(){
        if(listaPOI.size()>0)
        {
            return listaPOI.get(0);
        }
        return null; // TODO controlla se deve restituire questo
    }

    public boolean HasNextPOI(POI poi){  //TODO metti iterator
        for (int i=0; i<listaPOI.size();i++ ) {
            if (listaPOI.get(i).equals(poi))
                if(listaPOI.size()>i+1)
                    return true;
                else return false;
        }
        return false;
    }

    public POI NextPOI(POI poi){
        for (int i=0; i<listaPOI.size();i++){
            if(listaPOI.get(i).equals(poi))
                return listaPOI.get(i+1);
        }
        return null; // TODO controlla se deve restituire questo
    }



}
