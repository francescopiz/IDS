package com.unicam.IDS.models.richieste;

import com.unicam.IDS.repositorys.RichiesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GestoreRichieste {

    private final RichiesteRepository richiesteRepository;

    @Autowired
    public GestoreRichieste(RichiesteRepository richiesteRepository) {
        this.richiesteRepository = richiesteRepository;
    }

    public boolean addRichiesta(Richiesta richiesta) {
        if (richiesta == null || richiesteRepository.existsById(richiesta.getId())) return false;
        richiesteRepository.save(richiesta);
        return true;
    }

    private boolean deleteRichiesta(Richiesta richiesta) {
        if (richiesta == null || !richiesteRepository.existsById(richiesta.getId())) return false;
        richiesteRepository.delete(richiesta);
        return true;
    }

    public boolean existRichiestaById(int id) {
        return richiesteRepository.existsById(id);
    }

    public boolean valutaRichiesta(Richiesta richiesta, boolean approva) {
        if (richiesteRepository.existsById(richiesta.getId())) {
            richiesteRepository.getReferenceById(richiesta.getId()).esegui(approva);
            deleteRichiesta(richiesta);
            return true;
        }
        return false;
    }

    public List<Richiesta> getRichiesteByComune(int idComune) {
        return richiesteRepository.findAll().stream()
                .filter(richiesta -> richiesta.getIdComune() == idComune)
                .toList();
    }

    public Richiesta getRichiestaById(int id) {
        return richiesteRepository.findById(id).orElse(null);
    }

    public Richiesta getRichiestaByIdApprovabile(int idApprovabile) {
        return richiesteRepository.findAll().stream()
                .filter(richiesta -> richiesta.getApprovabile().getId() == idApprovabile)
                .findFirst().orElse(null);
    }
}