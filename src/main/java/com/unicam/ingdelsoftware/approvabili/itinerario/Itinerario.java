package com.unicam.ingdelsoftware.approvabili.itinerario;

import com.unicam.ingdelsoftware.approvabili.GruppoPOI;
import com.unicam.ingdelsoftware.approvabili.POI;

import java.util.List;

/**
 * Classe che rappresenta un Itinerario, estende GruppoPOI.
 */
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

    /**
     * Restituisce il primo POI dell'itinerario.
     *
     * @return il primo POI se presente, altrimenti null
     */
    public POI PuntoIniziale() {
        if (listaPOI.size() > 0) {
            return listaPOI.get(0);
        }
        return null;
    }

    /**
     * Crea e restituisce un iteratore per l'itinerario.
     *
     * @return un'istanza di ItinerarioIterator
     */
    public POIIterator createIterator() {
        return new ItinerarioIterator(listaPOI);
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