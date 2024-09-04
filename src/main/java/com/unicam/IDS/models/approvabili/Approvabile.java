package com.unicam.IDS.models.approvabili;

/**
 * Classe astratta che rappresenta un elemento approvabile.
 */

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Approvabile {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String descrizione;
    protected boolean visibile;
    private int idComune;

    /**
     * Costruttore con parametri per nome, descrizione e stato di approvazione.
     *
     * @param nome        il nome dell'elemento approvabile
     * @param descrizione la descrizione dell'elemento approvabile
     * @param visibile   lo stato di approvazione dell'elemento
     */
    public Approvabile(String nome, String descrizione, boolean visibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.visibile = visibile;
        this.idComune = -1;
    }

    /**
     * Costruttore con parametri per nome e descrizione. Lo stato di approvazione è impostato a true di default.
     *
     * @param nome        il nome dell'elemento approvabile
     * @param descrizione la descrizione dell'elemento approvabile
     */
    public Approvabile(String nome, String descrizione) {
        this(nome, descrizione, true);
    }

    public Approvabile() {
    }

    /**
     * Imposta lo stato di approvazione dell'elemento.
     *
     * @param approvato il nuovo stato di approvazione
     */
    public void setVisibile(boolean approvato) {
        this.visibile = approvato;
    }

    /**
     * Restituisce lo stato di approvazione dell'elemento.
     *
     * @return true se l'elemento è approvato, false altrimenti
     */
    public boolean isVisibile() {
        return visibile;
    }

    /**
     * Restituisce il nome dell'elemento approvabile.
     *
     * @return il nome dell'elemento
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la descrizione dell'elemento approvabile.
     *
     * @return la descrizione dell'elemento
     */
    public String getDescrizione() {
        return descrizione;
    }

    public int getIdComune() {
        return idComune;
    }

    public void setIdComune(int idComune) {
        this.idComune = idComune;
    }

    public int getId() {
        return id;
    }
}