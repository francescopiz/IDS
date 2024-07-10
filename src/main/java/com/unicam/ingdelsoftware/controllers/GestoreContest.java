package com.unicam.ingdelsoftware.controllers;

import com.unicam.ingdelsoftware.models.Contenuto;
import com.unicam.ingdelsoftware.models.Contest;
import com.unicam.ingdelsoftware.models.Iscrizione;
import com.unicam.ingdelsoftware.models.Liste;
import com.unicam.ingdelsoftware.models.ruoli.Utente;

import java.util.List;

public class GestoreContest {

    private Liste repository;

    public GestoreContest(Liste liste){
        repository = liste;
    }


    public boolean creaContest(String nome, String descrizione, Utente animatore){
        return Liste.creaContest(nome, descrizione, animatore);
    }



    public boolean iscriviti(int contestId, int utenteId, Contenuto contenuto) {

        List<Iscrizione> iscrizioni = Liste.getListaIscrittiContest(contestId);
        int id = -1;
        for (Iscrizione iscr : iscrizioni) {
            id = iscr.getIdUtente();
            if (id == utenteId)
                return false;
        }
        Contest contest = Liste.getContest();
        if (contest == null) {
            return false;
            Liste.addIscrizione(new Iscrizione(contestId, utenteId, contenuto));
            return true;
        }
    }

}
