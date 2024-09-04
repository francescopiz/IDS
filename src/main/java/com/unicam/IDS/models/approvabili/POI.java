package com.unicam.IDS.models.approvabili;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe che rappresenta un Punto di Interesse (POI).
 */
@Entity
public class POI extends Approvabile {
    @Embedded
    private Posizione posizione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "poi")
    private List<Contenuto> elencoContenuti;

    @ManyToOne(fetch = FetchType.EAGER)
    private GruppoPOI gruppoPOI;

    /**
     * Costruttore per creare un POI con una lista di contenuti.
     *
     * @param nome            il nome del POI
     * @param descrizione     la descrizione del POI
     * @param posizione       la posizione del POI
     * @param elencoContenuti la lista dei contenuti del POI
     * @param gruppoPOI       il gruppo di appartenenza del POI
     */
    public POI(String nome, String descrizione, Posizione posizione, List<Contenuto> elencoContenuti, GruppoPOI gruppoPOI) {
        this(nome, descrizione, posizione, elencoContenuti);
        this.gruppoPOI = gruppoPOI;
    }

    public POI(String nome, String descrizione, Posizione posizione, List<Contenuto> elencoContenuti) {
        super(nome, descrizione);
        this.posizione = posizione;
        this.elencoContenuti = elencoContenuti;
        this.gruppoPOI = null;
    }

    /**
     * Costruttore per creare un POI senza una lista di contenuti.
     *
     * @param nome        il nome del POI
     * @param posizione   la posizione del POI
     * @param descrizione la descrizione del POI
     */
    public POI(String nome, String descrizione, Posizione posizione) {
        super(nome, descrizione);
        this.posizione = posizione;
        this.elencoContenuti = new ArrayList<>();
    }

    public POI() {
    }

    /**
     * Restituisce la posizione del POI.
     *
     * @return la posizione del POI
     */
    public Posizione getPosizione() {
        return posizione;
    }

    /**
     * Restituisce la lista dei contenuti del POI.
     *
     * @return la lista dei contenuti del POI
     */
    public List<Contenuto> getElencoContenuti() {
        return elencoContenuti;
    }

    /**
     * Restituisce il numero di contenuti del POI.
     *
     * @return il numero di contenuti del POI
     */
    public int getNumeroContenuti() {
        return elencoContenuti.size();
    }

    /**
     * Restituisce una rappresentazione in stringa del POI.
     *
     * @return una stringa che rappresenta il POI
     */
    @Override
    public String toString() {
        return "POI: " + super.toString() + "\n" + "Posizione: " + posizione.toString();
    }
}