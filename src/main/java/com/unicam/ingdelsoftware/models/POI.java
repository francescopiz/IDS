package com.unicam.ingdelsoftware.models;

import java.util.ArrayList;
import java.util.List;

public class POI extends Approvabile {
    private String nome;
    private Posizione posizione;
    private final List<Contenuto> elencoContenuti;

    public POI(int id, String nome, Posizione posizione) {
        super(id);
        this.nome = nome;
        this.posizione = posizione;
        this.elencoContenuti = new ArrayList<Contenuto>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    //TODO fatto dal controller
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public List<Contenuto> getElencoContenuti() {
        return elencoContenuti;
    }

    //TODO fatto dal controller
    public void addContenuto(Contenuto contenuto) {
        this.elencoContenuti.add(contenuto);
    }

    //TODO fatto dal controller
    public void setNome(String nome) {
        this.nome = nome;
    } //TODO controlla se nello stesso comune c'è un elemento con lo stesso nome

    public Posizione getCoordinata() {
        return posizione;
    }

    public int getNumeroContenuti() {
        return elencoContenuti.size();
    }
}