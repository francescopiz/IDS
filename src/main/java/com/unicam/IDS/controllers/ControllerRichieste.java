package com.unicam.IDS.controllers;

import com.unicam.IDS.dtos.RichiestaApprovabileDto;
import com.unicam.IDS.models.approvabili.Approvabile;
import com.unicam.IDS.models.richieste.GestoreRichieste;
import com.unicam.IDS.models.richieste.Richiesta;
import com.unicam.IDS.models.richieste.RichiestaApprovabile;
import com.unicam.IDS.models.richieste.RichiestaSegnalazione;
import com.unicam.IDS.models.ruoli.GestoreApprovabili;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ControllerRichieste {

    GestoreRichieste gestoreRichieste;

    GestoreApprovabili gestoreApprovabili;

    @Autowired
    public ControllerRichieste(GestoreRichieste gestoreRichieste, GestoreApprovabili gestoreApprovabili) {
        this.gestoreRichieste = gestoreRichieste;
        this.gestoreApprovabili = gestoreApprovabili;
    }

    public boolean addRichiestaApprovabile(RichiestaApprovabileDto richiestaApprovabileDto, int idComune) {
        Approvabile approvabile = gestoreApprovabili.getApprovabileByApprovabileDto(richiestaApprovabileDto.approvabileDto());
        this.gestoreApprovabili.addApprovabile(approvabile, idComune);
        RichiestaApprovabile richiestaApprovabile = new RichiestaApprovabile(approvabile);
        richiestaApprovabile.getApprovabile().setVisibile(false);
        return addRichiesta(richiestaApprovabile);
    }

    public boolean addRichiestaSegnalazione(int idApprovabile, String descrizione) {
        RichiestaSegnalazione richiestaSegnalazione = new RichiestaSegnalazione(gestoreApprovabili.getApprovabileById(idApprovabile), descrizione);
        return addRichiesta(richiestaSegnalazione);
    }

    private boolean addRichiesta(Richiesta richiesta) {
        return gestoreRichieste.addRichiesta(richiesta);
    }

    public Collection<Richiesta> getRichiesteByComune(int idComune) {
        return gestoreRichieste.getRichiesteByComune(idComune);
    }

    public Richiesta getRichiestaById(int id) {
        return gestoreRichieste.getRichiestaById(id);
    }

    public boolean valutaRichiesta(int idRichiesta, boolean approva) {
        return gestoreRichieste.valutaRichiesta(getRichiestaById(idRichiesta), approva);
    }

    public Richiesta getRichiestaByIdApprovabile(int idApprovabile) {
        return gestoreRichieste.getRichiestaByIdApprovabile(idApprovabile);
    }
}