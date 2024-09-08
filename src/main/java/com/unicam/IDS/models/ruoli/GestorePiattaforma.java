package com.unicam.IDS.models.ruoli;


import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Classe utilizzata per gestire la piattaforma.
 */
@Component
public class GestorePiattaforma {

    private static GestorePiattaforma instance = null;

    private final GestoreUtenti gestoreUtenti;

    private final GestoreComuni gestoreComuni;

    ComuniRepository comuniRepository;

    RichiesteRepository richiesteRepository;

    ApprovabiliRepository approvabiliRepository;

    ContestRepository contestRepository;


    UtentiRepository utentiRepository;

    @Autowired
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


    public GestoreComuni getGestoreComuni() {
        return gestoreComuni;
    }


    @Override
    public String toString() {
        return "GestorePiattaforma{" +
                gestoreUtenti +
                ", " + gestoreComuni +
                '}';
    }


    public GestoreUtenti getGestoreUtenti() {
        return gestoreUtenti;
    }


}