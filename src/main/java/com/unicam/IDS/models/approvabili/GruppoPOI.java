package com.unicam.IDS.models.approvabili;

import jakarta.persistence.*;

import java.util.List;

/**
 * Rappresenta un gruppo di POI non ordinato.
 */
@Entity
public class GruppoPOI extends Approvabile {

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "gruppoPOI")
    protected List<POI> listaPOI;

    /**
     * Costruttore per creare un GruppoPOI con una lista di POI.
     *
     * @param nome        il nome del gruppo di POI
     * @param descrizione la descrizione del gruppo di POI
     * @param listaPOI    la lista di POI del gruppo
     */
    public GruppoPOI(String nome, String descrizione, List<POI> listaPOI) {
        super(nome, descrizione);
        this.listaPOI = listaPOI;
    }

    public GruppoPOI() {

    }

    /**
     * Restituisce la lista di POI del gruppo.
     *
     * @return la lista di POI
     */
    public List<POI> getListaPOI() {
        return listaPOI;
    }

    /**
     * Aggiunge un POI alla lista del gruppo.
     *
     * @param poi il POI da aggiungere
     * @return true se il POI è stato aggiunto, false altrimenti
     */
    public boolean addPOI(POI poi) {
        return listaPOI.add(poi);
    }

    /**
     * Rimuove un POI dalla lista del gruppo.
     *
     * @param poi il POI da rimuovere
     * @return true se il POI è stato rimosso, false altrimenti
     */
    public boolean removePOI(POI poi) {
        return listaPOI.remove(poi);
    }

    /**
     * Restituisce un POI dalla lista del gruppo in base all'indice.
     *
     * @param index l'indice del POI da restituire
     * @return il POI all'indice specificato
     */
    public POI getPOI(int index) {
        return listaPOI.get(index);
    }

    /**
     * Restituisce una rappresentazione in stringa del gruppo di POI.
     *
     * @return una stringa che rappresenta il gruppo di POI
     */
    @Override
    public String toString() {
        return "GruppoPOI{" +
                "listaPOI=" + listaPOI +
                '}';
    }
}