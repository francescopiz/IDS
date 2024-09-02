package com.unicam.IDS.models.approvabili;

import com.unicam.IDS.models.Comune;
import com.unicam.IDS.repositorys.ComuniRepository;

import java.util.List;

public class GestoreComuni {

    private ComuniRepository comuniRepository;
    private int idComune;

    public GestoreComuni(ComuniRepository comuniRepository, int idComune) {
        this.comuniRepository = comuniRepository;
        this.idComune = idComune;
    }

    public boolean addComune(Comune comune) {
        if (!comuniRepository.existsById(comune.getId())) {
            this.comuniRepository.save(comune);
            return true;
        }
        return false;
    }

    public List<Comune> getListaComuni() {
        return comuniRepository.findAll();
    }

    public Comune getComune(int idComune) {
        return comuniRepository.findById(idComune).orElse(null);
    }

    public boolean removeComune(Comune comune) {
        if (comuniRepository.existsById(comune.getId())) {
            comuniRepository.delete(comune);
            return true;
        }
        return false;
    }

}
