package com.unicam.ingdelsoftware.models;

import com.unicam.ingdelsoftware.controllers.Contesto;

public class Comune {
    private String nome;
    private int id;
    private String provincia;
    //private POI POIComune;


    // Se durante la creazione nel sistema
    public Comune(String nome, int id, String provincia, Posizione posizione) {
        this.nome = nome;
        this.id = id;
        this.provincia = provincia;
        /*this.POIComune =*/ Contesto.Gestore.GetGestorePOI().CreaPOI(nome, posizione); // TODO questo è il metodo che prende il singleton
    }
    public Comune(){}
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getProvincia() {
        return provincia;
    }

    //public POI getPOIComune() {
    //    return POIComune;
    //}





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comune comune)) return false;
        return id == comune.getId();
    }
    @Override
    public String toString() {
        return "Comune{" +
                "nome='" + nome + '\'' +
                ", provincia='" + provincia + '\'' +
                ", id='" + id + '\'' +
                //", " + POIComune.toString() +
                '}';
    }
}
