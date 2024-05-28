package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.models.Comune;
import com.unicam.ingdelsoftware.models.Liste;

import java.util.List;

public class GestoreComuni {
    //singleton
    //sarebbe un servizio

    private Liste repository;

    public GestoreComuni(Liste liste){
        repository = liste;
    }


    public boolean addComune(Comune comune){

        try{
            repository.addComune(comune);
            return true;
        }catch (Exception ignored){ //TODO

        }
        return false;
    }

    public List<Comune> getListaComuni(){
        return  repository.getListaComuni();
    }

    public Comune getComune(int id){
        List<Comune> lista = repository.getListaComuni();
        return lista.stream().filter(x -> x.getId() == id ).findFirst().orElse(null);
    }


}
