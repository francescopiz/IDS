package com.unicam.IDS.models.ruoli;

import com.unicam.IDS.models.Contest;
import com.unicam.IDS.models.Iscrizione;
import com.unicam.IDS.repositorys.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class GestoreContest {

    private final ContestRepository contestRepository;

    @Autowired
    public GestoreContest(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }


    public boolean addContest(Contest contest) {
        try {
            contestRepository.save(contest);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public Contest getContest(int idUtente) {
        return contestRepository.findById(idUtente).orElse(null);
    }

    public boolean deleteContest(Contest contest) {
        if (contestRepository.existsById(contest.getId())) {
            this.contestRepository.delete(contest);
            return true;
        }
        return false;
    }


    public boolean iscriviti(Contest contest, Utente utente, MultipartFile file) {
        if (contest.utenteAbilitato(utente)) {
            contest.addIscrizione(new Iscrizione(utente, contest, file));
            return true;
        }
        return true;
    }

    public boolean decretaVincitoreContest(Contest contest, Iscrizione iscrizione) {
        return contest.setVincitore(iscrizione);
    }

    public List<Contest> getContestByComune(int idComune) {
        return contestRepository.findAll().stream().filter(contest -> contest.getIdComune() == idComune).toList();
    }
    public Contest getContestById(int id) {
        return contestRepository.findById(id).orElse(null);
    }
}
