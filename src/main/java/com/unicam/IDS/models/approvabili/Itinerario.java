package com.unicam.IDS.models.approvabili;

import com.unicam.IDS.models.approvabili.GruppoPOI;
import com.unicam.IDS.models.approvabili.POI;
import jakarta.persistence.Entity;

import java.util.List;

/**
 * Classe che rappresenta un Itinerario, estende GruppoPOI.
 */
@Entity
public class Itinerario extends GruppoPOI {

    /**
     * Costruttore per creare un Itinerario con una lista di POI.
     *
     * @param nome        il nome dell'itinerario
     * @param descrizione la descrizione dell'itinerario
     * @param listaPOI    la lista di POI dell'itinerario
     */
    public Itinerario(String nome, String descrizione, List<POI> listaPOI) {
        super(nome, descrizione, listaPOI);
    }

    public Itinerario() {

    }

    /**
     * Restituisce una rappresentazione in stringa dell'itinerario.
     *
     * @return una stringa che rappresenta l'itinerario
     */
    @Override
    public String toString() {
        return "Itinerario{" +
                "nome='" + getNome() + '\'' +
                ", descrizione='" + getDescrizione() + '\'' +
                ", listaPOI=" + listaPOI +
                '}';
    }
}