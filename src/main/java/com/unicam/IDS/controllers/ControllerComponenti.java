package com.unicam.IDS.controllers;

import com.unicam.IDS.dtos.ApprovabileDto;
import com.unicam.IDS.models.Contest;
import com.unicam.IDS.models.Iscrizione;
import com.unicam.IDS.models.approvabili.*;
import com.unicam.IDS.models.ruoli.GestoreApprovabili;
import com.unicam.IDS.models.ruoli.GestorePiattaforma;
import com.unicam.IDS.models.ruoli.Utente;
import com.unicam.IDS.tempo.AbstractTime;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unicam.IDS.models.ruoli.GestoreContest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ControllerComponenti {

    GestoreApprovabili gestoreApprovabili;

    GestoreContest gestoreContest;


    public ControllerComponenti() {
    }

    @Autowired
    public ControllerComponenti(GestoreApprovabili gestoreApprovabili) throws JSONException {
        this.gestoreApprovabili = gestoreApprovabili;
    }

    public boolean addApprovabile(ApprovabileDto approvabileDto) {
        return gestoreApprovabili.addApprovabile(gestoreApprovabili.getApprovabileByApprovabileDto(approvabileDto));
    }


    public boolean deleteApprovabile(Approvabile approvabile) {
        return gestoreApprovabili.deleteApprovabile(approvabile);
    }

    public Approvabile getApprovabileById(int id) {
        return gestoreApprovabili.getApprovabileById(id);
    }

    public boolean existsApprovabileById(int idApprovabile) {
        return gestoreApprovabili.existsApprovabileById(idApprovabile);
    }

    public boolean addContest(Contest contest) {
        return gestoreContest.addContest(contest);
    }

    public boolean deleteContest(Contest contest) {
        return gestoreContest.deleteContest(contest);
    }

    public Contest getContest(int idUtente) {
        return gestoreContest.getContest(idUtente);
    }

    public boolean iscriviti(Contest contest, Utente utente, MultipartFile file) {
        return gestoreContest.iscriviti(contest, utente, file);
    }

    public boolean decretaVincitoreContest(Contest contest, Iscrizione iscrizione) {
        return gestoreContest.decretaVincitoreContest(contest, iscrizione);
    }

    public List<Contest> getContestByComune(int idComune) {
        return gestoreContest.getContestByComune(idComune);
    }

    public Iscrizione getIscrizioniVincenti(int idContest) {
        return gestoreContest.getContestById(idContest).getVincitore();
    }
}