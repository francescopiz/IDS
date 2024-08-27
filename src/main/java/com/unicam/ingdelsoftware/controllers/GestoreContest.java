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


    public boolean addContest(String nome, String descrizione, Utente animatore){
        return repository.addContest(nome, descrizione, animatore);
    }

    public boolean removeContest (int idContest){
        return repository.removeContest(idContest);
    }

    public boolean iscriviti(int contestId, int utenteId, Contenuto contenuto) {

        Contest contest = repository.getContest(contestId);
        if (contest == null) {
            return false;
        }
            List<Integer> utentiIscritti = contest.getListaIscritti();
            List<Integer> utentiAmmessi = contest.getListaAmmessi();
            if(utentiIscritti.contains(utenteId))
                return false;
            if(utentiAmmessi.size() > 0)
                if (!utentiAmmessi.contains(utenteId))
                    return false;
            Iscrizione iscrizione = new Iscrizione(contestId, utenteId, contenuto);
            repository.addIscrizione(iscrizione);
            contest.iscriviUtente(utenteId);

            return true;
    }

    public boolean decretaVincitoreContest (int idContest, Iscrizione iscrizione){

        return repository.getContest(idContest).setVincitore(iscrizione);
    }
}
