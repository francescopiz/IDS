package com.unicam.IDS.controllers;

import com.unicam.IDS.models.approvabili.Contenuto;
import com.unicam.IDS.models.Contest;
import com.unicam.IDS.models.Iscrizione;
import com.unicam.IDS.models.Liste;
import com.unicam.IDS.models.ruoli.Utente;

import java.util.List;

public class GestoreContest {

    private Liste repository;

    public GestoreContest(Liste liste){
        repository = liste;
    }


    public boolean creaContest(String nome, String descrizione, Utente animatore){
        return true;
                //Liste.creaContest(nome, descrizione, animatore);
    }



    public boolean iscriviti(int contestId, int utenteId, Contenuto contenuto) {

        List<Iscrizione> iscrizioni = null;
                //Liste.getListaIscrittiContest(contestId);
        int id = -1;
        for (Iscrizione iscr : iscrizioni) {
            id = iscr.getIdUtente();
            if (id == utenteId)
                return false;
        }
        Contest contest = null;
                //Liste.getContest();
        if (contest == null) {
            return false;
            //Liste.addIscrizione(new Iscrizione(contestId, utenteId, contenuto));
        }
        return true;
    }

}
