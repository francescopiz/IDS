package com.unicam.IDS.controllers;

import com.unicam.IDS.dtos.ApprovabileDto;
import com.unicam.IDS.models.Contest;
import com.unicam.IDS.models.Iscrizione;
import com.unicam.IDS.models.approvabili.Approvabile;
import com.unicam.IDS.models.ruoli.GestoreApprovabili;
import com.unicam.IDS.models.ruoli.GestoreComuni;
import com.unicam.IDS.models.ruoli.GestoreContest;
import com.unicam.IDS.models.ruoli.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ControllerComponenti {

    private static final Logger logger = Logger.getLogger(ControllerComponenti.class.getName());

    private final GestoreApprovabili gestoreApprovabili;
    private final GestoreComuni gestoreComuni;
    private final GestoreContest gestoreContest;

    @Autowired
    public ControllerComponenti(GestoreApprovabili gestoreApprovabili, GestoreComuni gestoreComuni, GestoreContest gestoreContest) {
        this.gestoreApprovabili = gestoreApprovabili;
        this.gestoreComuni = gestoreComuni;
        this.gestoreContest = gestoreContest;
    }

    public boolean addApprovabile(ApprovabileDto approvabileDto, int idComune) {
        var comune = gestoreComuni.getComuneById(idComune);
        var gestoreComunale = gestoreComuni.getGestoreComunaleByIdComune(idComune);

        if (comune == null) {
            logger.severe("Comune with id " + idComune + " not found.");
            return false;
        }

        if (gestoreComunale == null) {
            logger.severe("GestoreComunale for comune with id " + idComune + " not found.");
            return false;
        }

        if (gestoreComunale.isPosizioneInComune(approvabileDto.posizione())) {
            var approvabile = gestoreApprovabili.getApprovabileByApprovabileDto(approvabileDto);
            return gestoreApprovabili.addApprovabile(approvabile, idComune);
        }
        return false;
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

    public Set<Approvabile> getApprovabili(int idComune) {
        return gestoreApprovabili.getApprovabili().stream()
                .filter(approvabile -> approvabile.getIdComune() == idComune)
                .filter(Approvabile::isVisibile)
                .collect(Collectors.toSet());
    }
}