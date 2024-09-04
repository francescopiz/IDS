package com.unicam.IDS.models.approvabili;

import com.unicam.IDS.models.approvabili.GruppoPOI;
import com.unicam.IDS.models.approvabili.POI;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Itinerario itinerario)) return false;
        return Objects.equals(getNome(), itinerario.getNome()) && Objects.equals(getDescrizione(), itinerario.getDescrizione()) && Objects.equals(listaPOI, itinerario.listaPOI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

}