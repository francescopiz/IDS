package com.unicam.IDS.controllers;

import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.dtos.RichiestaApprovabileDto;
import com.unicam.IDS.models.approvabili.Approvabile;
import com.unicam.IDS.models.richieste.GestoreRichieste;
import com.unicam.IDS.models.richieste.Richiesta;
import com.unicam.IDS.models.richieste.RichiestaApprovabile;
import com.unicam.IDS.models.richieste.RichiestaSegnalazione;
import com.unicam.IDS.models.ruoli.GestoreApprovabili;
import com.unicam.IDS.models.ruoli.GestorePiattaforma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ControllerRichieste {

    private final GestorePiattaforma gestorePiattaforma;

    @Autowired
    public ControllerRichieste(GestorePiattaformaBuilder gestorePiattaformaBuilder) {
        this.gestorePiattaforma = GestorePiattaforma.getInstance(gestorePiattaformaBuilder);
    }

    public boolean addRichiestaApprovabile(RichiestaApprovabileDto richiestaApprovabileDto, int idComune) {
        Approvabile approvabile = gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().getApprovabileByApprovabileDto(richiestaApprovabileDto.approvabileDto());
        this.gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().addApprovabile(approvabile, idComune);
        RichiestaApprovabile richiestaApprovabile = new RichiestaApprovabile(approvabile);
        richiestaApprovabile.getApprovabile().setVisibile(false);
        return addRichiesta(richiestaApprovabile);
    }

    public boolean addRichiestaSegnalazione(int idApprovabile, String descrizione) {
        RichiestaSegnalazione richiestaSegnalazione = new RichiestaSegnalazione(gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().getApprovabileById(idApprovabile), descrizione);
        return addRichiesta(richiestaSegnalazione);
    }

    private boolean addRichiesta(Richiesta richiesta) {
        return gestorePiattaforma.getGestoreComuni().getGestoreRichieste().addRichiesta(richiesta);
    }

    public Collection<Richiesta> getRichiesteByComune(int idComune) {
        return gestorePiattaforma.getGestoreComuni().getGestoreRichieste().getRichiesteByComune(idComune);
    }

    public Richiesta getRichiestaById(int id) {
        return gestorePiattaforma.getGestoreComuni().getGestoreRichieste().getRichiestaById(id);
    }

    public boolean valutaRichiesta(int idRichiesta, boolean approva) {
        return gestorePiattaforma.getGestoreComuni().getGestoreRichieste().valutaRichiesta(getRichiestaById(idRichiesta), approva);
    }

    public Richiesta getRichiestaByIdApprovabile(int idApprovabile) {
        return gestorePiattaforma.getGestoreComuni().getGestoreRichieste().getRichiestaByIdApprovabile(idApprovabile);
    }
}