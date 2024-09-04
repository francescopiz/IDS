package com.unicam.IDS.controllers;

import com.unicam.IDS.GestorePiattaformaBuilder;
import com.unicam.IDS.models.Comune;
import com.unicam.IDS.models.ruoli.GestorePiattaforma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ControllerComuni {
    private GestorePiattaforma gestorePiattaforma;

    @Autowired
    public ControllerComuni(GestorePiattaformaBuilder gestorePiattaformaBuilder) {
        this.gestorePiattaforma = GestorePiattaforma.getInstance(gestorePiattaformaBuilder);
    }

    public ControllerComuni(GestorePiattaforma gestorePiattaforma) {
        this.gestorePiattaforma = gestorePiattaforma;
    }

    public boolean addComune(Comune comune) {
        if (comune.getNome().isBlank() || comune.getProvincia().isBlank())
            return false;
        return gestorePiattaforma.getGestoreComuni().addComune(comune);
    }
    public Set<Comune> getComuni() {
        return gestorePiattaforma.getGestoreComuni().getComuni();
    }
}
