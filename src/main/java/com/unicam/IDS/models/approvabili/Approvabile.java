package com.unicam.IDS.models.approvabili;

/**
 * Classe astratta che rappresenta un elemento approvabile.
 */
public abstract class Approvabile {
    private String id;
    private String nome;
    private String descrizione;
    protected boolean approvato;

    /**
     * Costruttore con parametri per nome, descrizione e stato di approvazione.
     *
     * @param nome        il nome dell'elemento approvabile
     * @param descrizione la descrizione dell'elemento approvabile
     * @param approvato   lo stato di approvazione dell'elemento
     */
    public Approvabile(String nome, String descrizione, boolean approvato) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.approvato = approvato;
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

    /**
     * Imposta lo stato di approvazione dell'elemento.
     *
     * @param approvato il nuovo stato di approvazione
     */
    public void setApprovato(boolean approvato) {
        this.approvato = approvato;
    }

    /**
     * Restituisce lo stato di approvazione dell'elemento.
     *
     * @return true se l'elemento è approvato, false altrimenti
     */
    public boolean isApprovato() {
        return approvato;
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
}