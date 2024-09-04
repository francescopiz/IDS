package com.unicam.IDS.controllers;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ControllerUtenti {

    private final GestoreUtenti gestoreUtenti;


    public ControllerUtenti() {
        this.gestoreUtenti = GestorePiattaforma.getInstance().getGestoreUtenti();
    }

    /**
     * Costruisce un ControllerUtenti.
     *
     * @param gestoreUtenti Il gestore degli utenti.
     */
    @Autowired
    public ControllerUtenti(GestoreUtenti gestoreUtenti) {
        this.gestoreUtenti = gestoreUtenti;
    }


    public boolean setRuoloUtente(int idUtente, RuoloInComune ruoloComune) {
        return gestoreUtenti.setRuoloUtente(gestoreUtenti.getUtenteById(idUtente), ruoloComune);
    }
    public Set<Utente> getUtenti() {
        return gestoreUtenti.getUtenti();
    }


    /**
     * Metodo utilizzato per aggiungere un utente al controller.
     *
     * @param utente l'utente da aggiungere.
     * @return true se l'utente è stato aggiunto, false altrimenti.
     */
    public boolean addUtente(Utente utente) {
        return gestoreUtenti.addUtente(utente);
    }

    public boolean deleteUtente(int idUtente) {
        return gestoreUtenti.deleteUtente(gestoreUtenti.getUtenteById(idUtente));
    }

    public Set<Comune> getComuniConRuoloUtente(int idUtente, Ruolo ruolo) {
        return gestoreUtenti.getGestoreRuoli().getComuniConRuoloUtente(gestoreUtenti.getUtenteById(idUtente), ruolo);
    }
}