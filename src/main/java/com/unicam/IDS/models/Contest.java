package com.unicam.IDS.models;

import com.unicam.IDS.models.ruoli.Utente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * La classe Contest rappresenta un concorso con un nome, una descrizione, un animatore e una lista di iscrizioni.
 */
@Entity
public class Contest {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String descrizione;
    @ManyToOne
    private Utente animatore;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    private Set<Iscrizione> listaIscritti;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    private List<Utente> utentiAmmessi;

    @OneToOne(cascade = CascadeType.ALL)
    private Iscrizione vincitore;

    /**
     * Costruttore della classe Contest.
     *
     * @param nome        Il nome del concorso.
     * @param descrizione La descrizione del concorso.
     * @param animatore   L'animatore del concorso.
     */
    public Contest(String nome, String descrizione, Utente animatore) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.animatore = animatore;
        this.vincitore = null;
        this.utentiAmmessi = new ArrayList<>();
        this.listaIscritti = new HashSet<>();
    }

    /**
     * Costruttore della classe Contest con lista di utenti ammessi.
     *
     * @param nome          Il nome del concorso.
     * @param descrizione   La descrizione del concorso.
     * @param animatore     L'animatore del concorso.
     * @param utentiAmmessi La lista di utenti ammessi al concorso.
     */
    public Contest(String nome, String descrizione, Utente animatore, List<Utente> utentiAmmessi) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.animatore = animatore;
        this.vincitore = null;
        this.utentiAmmessi = utentiAmmessi;
        this.listaIscritti = new HashSet<>();
    }

    /**
     * Costruttore di default della classe Contest.
     */
    public Contest() {
        this.utentiAmmessi = new ArrayList<>();
        this.listaIscritti = new HashSet<>();
    }

    /**
     * Aggiunge un'iscrizione alla lista delle iscrizioni.
     *
     * @param iscrizione L'iscrizione da aggiungere.
     * @return true se l'iscrizione è stata aggiunta con successo, false altrimenti.
     */
    public boolean addIscrizione(Iscrizione iscrizione) {
        if (!utenteAbilitato(iscrizione.getIscritto()))
            return false;
        listaIscritti.add(iscrizione);
        return true;
    }

    /**
     * Restituisce la lista degli utenti ammessi.
     *
     * @return La lista degli utenti ammessi.
     */
    public List<Utente> getUtentiAmmessi() {
        return utentiAmmessi;
    }

    /**
     * Restituisce l'ID del concorso.
     *
     * @return L'ID del concorso.
     */
    public int getId() {
        return id;
    }

    /**
     * Restituisce la lista delle iscrizioni.
     *
     * @return La lista delle iscrizioni.
     */
    public Set<Iscrizione> getListaIscritti() {
        return listaIscritti;
    }

    /**
     * Verifica se il concorso è privato.
     *
     * @return true se il concorso è privato, false altrimenti.
     */
    public boolean contestPrivato() {
        return !this.utentiAmmessi.isEmpty();
    }

    /**
     * Restituisce il vincitore del concorso.
     *
     * @return Il vincitore del concorso.
     */
    public Iscrizione getVincitore() {
        return this.vincitore;
    }

    /**
     * Imposta il vincitore del concorso.
     *
     * @param iscrizione L'iscrizione del vincitore.
     * @return true se il vincitore è stato impostato con successo, false altrimenti.
     */
    public boolean setVincitore(Iscrizione iscrizione) {
        if (this.vincitore != null)
            return false;
        this.vincitore = iscrizione;
        return true;
    }

    /**
     * Verifica se un utente è abilitato a partecipare al concorso.
     *
     * @param utente L'utente da verificare.
     * @return true se l'utente è abilitato, false altrimenti.
     */
    public boolean utenteAbilitato(Utente utente) {
        if (this.utentiAmmessi == null || this.utentiAmmessi.isEmpty())
            return true;
        return this.utentiAmmessi.contains(utente);
    }

    //TODO: implementare equals, toString, hashcode
}