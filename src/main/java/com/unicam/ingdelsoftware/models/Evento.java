package com.unicam.ingdelsoftware.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento extends POI {

    private Date dataInizio;
    private Date dataFine;
    /*
    private List<Integer> listaIscritti;
    private boolean privato; //TODO decidere se lasciare anche l'evento privato
    private List<Integer> utentiAmmessi;
    */
    public Evento(int id, String nome, Posizione posizione, Date dataINizio, Date dataFine) {
        super(id, nome, posizione);
        this.dataInizio = dataINizio;
        this.dataFine = dataFine;
    }



    public Date getDataFine(){
        return dataFine;
    }

    public Date getDataInizio(){
        return dataInizio;
    }

    /*
    public List<Integer> getListaIscritti(){
        return listaIscritti;
    }

    public boolean EventoPrivato(){
        return privato;
    }
    */


}
