package com.unicam.ingdelsoftware.models;

import java.util.List;

/**
 * Rappresenta un gruppo di POI non ordinato
 */
public class GruppoPOI {
    private String nome;
    private int id;
    private List<POI> listaPOI;

    public GruppoPOI(String nome, int id, List<POI> listaPOI) {
        this.nome = nome;
        this.id = id;
        this.listaPOI = listaPOI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }

    public List<POI> getListaPOI() {
        return listaPOI;
    }

    public boolean addPOI(POI poi) {
        return listaPOI.add(poi);
    }

    public boolean removePOI(POI poi) {
        return listaPOI.remove(poi);
    }

    public POI getPOI(int index) {
        return listaPOI.get(index);
    }
}
