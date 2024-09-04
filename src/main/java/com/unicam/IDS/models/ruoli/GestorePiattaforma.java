package com.unicam.IDS.models.ruoli;


import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.GestoreComuni;
import com.unicam.IDS.repositorys.*;

import java.util.Set;

/**
 * Classe utilizzata per gestire la piattaforma.
 */
public class GestorePiattaforma {

    private static GestorePiattaforma instance = null;

    private final GestoreUtenti gestoreUtenti;

    public GestoreComuni getGestoreComuni() {
        return gestoreComuni;
    }

    private final GestoreComuni gestoreComuni;

    ComuniRepository comuniRepository;

    RichiesteRepository richiesteRepository;

    ApprovabiliRepository approvabiliRepository;

    ContestRepository contestRepository;


    UtentiRepository utentiRepository;


    private GestorePiattaforma(GestorePiattaformaBuilder builder) {
        this.comuniRepository = builder.getComuniRepository();
        this.richiesteRepository = builder.getRichiesteRepository();
        this.approvabiliRepository = builder.getApprovabiliRepository();
        this.contestRepository = builder.getContestRepository();
        this.utentiRepository = builder.getUtentiRepository();
        this.gestoreUtenti = new GestoreUtenti(utentiRepository);
        this.gestoreComuni = new GestoreComuni(comuniRepository, approvabiliRepository, richiesteRepository, contestRepository);
        instance = this;
    }

    public GestorePiattaforma() {
        this.gestoreUtenti = new GestoreUtenti(utentiRepository);
        this.gestoreComuni = new GestoreComuni(comuniRepository, approvabiliRepository, richiesteRepository, contestRepository);
    }

    public static GestorePiattaforma getInstance(GestorePiattaformaBuilder builder) {
        if (instance == null) {
            instance = new GestorePiattaforma(builder);
        }
        return instance;
    }

    public static GestorePiattaforma getInstance() {
        return instance;
    }


    /**
     * Aggiunge un utente alla lista degli utenti
     *
     * @param utente l'utente da aggiungere
     * @return true se l'utente è stato aggiunto, false altrimenti
     */
    public boolean aggiungiUtente(Utente utente) {
        return gestoreUtenti.addUtente(utente);
    }


    /**
     * Aggiunge un comune alla lista dei comuni
     *
     * @param comune il comune da aggiungere
     * @return true se il comune è stato aggiunto, false altrimenti
     */
    public boolean aggiungiComune(Comune comune) {
        return gestoreComuni.addComune(comune);
    }


    @Override
    public String toString() {
        return "GestorePiattaforma{" +
                gestoreUtenti +
                ", " + gestoreComuni +
                '}';
    }


    public Set<Comune> getComuni() {
        return gestoreComuni.getComuni();
    }

    public GestoreUtenti getGestoreUtenti() {
        return gestoreUtenti;
    }

    public ComuniRepository getComuniRepository() {
        return comuniRepository;
    }

    public RichiesteRepository getRichiesteRepository() {
        return richiesteRepository;
    }

    public ApprovabiliRepository getContenutiRepository() {
        return approvabiliRepository;
    }

    public ContestRepository getContestRepository() {
        return contestRepository;
    }

    public UtentiRepository getUtentiRepository() {
        return utentiRepository;
    }

}