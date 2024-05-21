package com.unicam.ingdelsoftware.models;

import java.util.ArrayList;
import java.util.List;

public class POI {
    private final String id;
    private String nome;
    private Posizione posizione;
    private List<Contenuto> elencoContenuti;

    public POI(String id, String nome, Posizione posizione) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.elencoContenuti = new ArrayList<Contenuto>();
    }

    public String getNome() {
        return nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public List<Contenuto> getElencoContenuti() {
        return elencoContenuti;
    }

    public void addContenuto(Contenuto contenuto) {
        this.elencoContenuti.add(contenuto);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posizione getCoordinata() {
        return posizione;
    }

    public int getNumeroContenuti() {
        return elencoContenuti.size();
    }
}