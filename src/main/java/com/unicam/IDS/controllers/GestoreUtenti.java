package com.unicam.IDS.controllers;

import com.unicam.IDS.models.Liste;
import com.unicam.IDS.models.ruoli.RuoloInComune;
import com.unicam.IDS.models.ruoli.Utente;


public class GestoreUtenti {

    // Il gestore dei ruoli
    private final GestoreRuoli gestoreRuoli;

    // La lista degli utenti
    private Liste liste;

    /**
     * Costruttore per la classe GestoreUtenti.
     * @param liste La lista degli utenti.
     */
    public GestoreUtenti(Liste liste) {
        gestoreRuoli = new GestoreRuoli();
        this.liste = liste;
    }

    /**
     * Aggiunge un utente alla lista.
     * @param utente L'utente da aggiungere.
     * @return true se l'utente è stato aggiunto con successo.
     */
    public boolean aggiungiUtente(Utente utente) {
        this.liste.addUtente(utente);
        return true;
    }

    /**
     * Rimuove un utente dalla lista.
     * @param utente L'utente da rimuovere.
     * @return true se l'utente è stato rimosso con successo, false altrimenti.
     */
    public boolean rimuoviUtente(Utente utente) {
        if(this.liste.getListaUtenti().contains(utente)) {
            this.liste.removeUtente(utente.getId());
            return true;
        }
        return false;
    }

    /**
     * Imposta il ruolo di un utente.
     * @param utente L'utente a cui impostare il ruolo.
     * @param ruoloComune Il ruolo da impostare.
     * @return true se il ruolo è stato impostato con successo.
     */
    public boolean setRuoloUtente(Utente utente, RuoloInComune ruoloComune) {
        return gestoreRuoli.conferisciRuoloComuneAUtente(utente, ruoloComune);
    }

    /**
     * Restituisce una rappresentazione in stringa dell'oggetto GestoreUtenti.
     * @return Una rappresentazione in stringa dell'oggetto GestoreUtenti.
     */
    @Override
    public String toString() {
        return "GestoreUtenti{" +
                "utenti=" + this.liste.getListaUtenti().size() +
                '}';
    }

    /**
     * Restituisce il gestore dei ruoli.
     * @return Il gestore dei ruoli.
     */
    public GestoreRuoli getGestoreRuoli() {
        return gestoreRuoli;
    }

    /**
     * Restituisce un utente in base al suo ID.
     * @param idUtente L'ID dell'utente.
     * @return L'utente con l'ID dato, o null se non esiste un utente con tale ID.
     */
    public Utente getUtenteById(int idUtente) {
        if(this.liste.containsUtente(idUtente))
            return liste.getUtente(idUtente);
        return null;
    }

}
