package com.unicam.IDS.controllers;

import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.dtos.ApprovabileDto;
import com.unicam.IDS.models.Contest;
import com.unicam.IDS.models.Iscrizione;
import com.unicam.IDS.models.approvabili.Approvabile;
import com.unicam.IDS.models.ruoli.*;
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

    private final GestorePiattaforma gestorePiattaforma;

    @Autowired
    public ControllerComponenti(GestorePiattaformaBuilder gestorePiattaformaBuilder) {
        this.gestorePiattaforma = GestorePiattaforma.getInstance(gestorePiattaformaBuilder);
    }

    public boolean addApprovabile(ApprovabileDto approvabileDto, int idComune) {
        var comune = gestorePiattaforma.getGestoreComuni().getComuneById(idComune);
        var gestoreComunale = gestorePiattaforma.getGestoreComuni().getGestoreComunaleByIdComune(idComune);

        if (comune == null) {
            logger.severe("Comune with id " + idComune + " not found.");
            return false;
        }

        if (gestoreComunale == null) {
            logger.severe("GestoreComunale for comune with id " + idComune + " not found.");
            return false;
        }

        if (gestoreComunale.isPosizioneInComune(approvabileDto.posizione())) {
            var approvabile = gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().getApprovabileByApprovabileDto(approvabileDto);
            return gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().addApprovabile(approvabile, idComune);
        }
        return false;
    }

    public boolean deleteApprovabile(Approvabile approvabile) {
        return gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().deleteApprovabile(approvabile);
    }

    public Approvabile getApprovabileById(int id) {
        return gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().getApprovabileById(id);
    }

    public boolean existsApprovabileById(int idApprovabile) {
        return gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().existsApprovabileById(idApprovabile);
    }

    public boolean addContest(Contest contest) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().addContest(contest);
    }

    public boolean deleteContest(Contest contest) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().deleteContest(contest);
    }

    public Contest getContest(int idUtente) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().getContest(idUtente);
    }

    public boolean iscriviti(Contest contest, Utente utente, MultipartFile file) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().iscriviti(contest, utente, file);
    }

    public boolean decretaVincitoreContest(Contest contest, Iscrizione iscrizione) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().decretaVincitoreContest(contest, iscrizione);
    }

    public List<Contest> getContestByComune(int idComune) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().getContestByComune(idComune);
    }

    public Iscrizione getIscrizioniVincenti(int idContest) {
        return gestorePiattaforma.getGestoreComuni().getGestoreContest().getContestById(idContest).getVincitore();
    }

    public Set<Approvabile> getApprovabili(int idComune) {
        return gestorePiattaforma.getGestoreComuni().getGestoreApprovabili().getApprovabili().stream()
                .filter(approvabile -> approvabile.getIdComune() == idComune)
                .filter(Approvabile::isVisibile)
                .collect(Collectors.toSet());
    }
}