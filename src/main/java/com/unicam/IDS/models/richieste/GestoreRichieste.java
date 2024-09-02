
package com.unicam.IDS.models.richieste;

import com.unicam.IDS.repositorys.RichiesteRepository;

import java.util.List;

public class GestoreRichieste {

    private final RichiesteRepository richiesteRepository;
    private final int idComune;

    public GestoreRichieste(RichiesteRepository richiesteRepository, int idComune) {
        this.richiesteRepository = richiesteRepository;
        this.idComune = idComune;
    }

    public boolean addRichiesta(Richiesta richiesta) {
        if (richiesta == null || richiesteRepository.existsById(richiesta.getId())) return false;
        richiesta.setIdComune(this.idComune);
        this.richiesteRepository.save(richiesta);
        return true;
    }

    private boolean deleteRichiesta(Richiesta richiesta) {
        if (richiesta == null || !richiesteRepository.existsById(richiesta.getId())) return false;
        this.richiesteRepository.delete(richiesta);
        return true;
    }

    public boolean getRichiestaById(int id) {
        return richiesteRepository.existsById(id);
    }

    public boolean valutaRichiesta(Richiesta richiesta, boolean approva) {
        if (this.richiesteRepository.existsById(richiesta.getId())) {
            richiesteRepository.getReferenceById(richiesta.getId()).esegui(approva);
            this.deleteRichiesta(richiesta);
            return true;
        }
        return false;
    }

    public List<Richiesta> getRichiesteComune() {
        return richiesteRepository.findAll().stream().filter(richiesta -> richiesta.getIdComune() == this.idComune).toList();
    }

    //TODO toString
}
