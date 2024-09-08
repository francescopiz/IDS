package com.unicam.IDS.controllers;

import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ControllerUtenti {

    private final GestorePiattaforma gestorePiattaforma;

    @Autowired
    public ControllerUtenti(GestorePiattaformaBuilder gestorePiattaformaBuilder) {
        this.gestorePiattaforma = GestorePiattaforma.getInstance(gestorePiattaformaBuilder);
    }


    public boolean setRuoloUtente(int idUtente, Ruolo ruolo, int idComune) {
        RuoloInComune ruoloInComune = new RuoloInComune(gestorePiattaforma.getGestoreComuni().getComuneById(idComune), ruolo);
        return gestorePiattaforma.getGestoreUtenti().setRuoloUtente(gestorePiattaforma.getGestoreUtenti().getUtenteById(idUtente), ruoloInComune);
    }

    public Set<Utente> getUtenti() {
        return gestorePiattaforma.getGestoreUtenti().getUtenti();
    }


    /**
     * Metodo utilizzato per aggiungere un utente al controller.
     *
     * @param utente l'utente da aggiungere.
     * @return true se l'utente è stato aggiunto, false altrimenti.
     */
    public boolean addUtente(Utente utente) {
        return gestorePiattaforma.getGestoreUtenti().addUtente(utente);
    }

    public boolean deleteUtente(int idUtente) {
        return gestorePiattaforma.getGestoreUtenti().deleteUtente(gestorePiattaforma.getGestoreUtenti().getUtenteById(idUtente));
    }

    public Set<Comune> getComuniConRuoloUtente(int idUtente, Ruolo ruolo) {
        return gestorePiattaforma.getGestoreUtenti().getGestoreRuoli().getComuniConRuoloUtente(gestorePiattaforma.getGestoreUtenti().getUtenteById(idUtente), ruolo);
    }
}