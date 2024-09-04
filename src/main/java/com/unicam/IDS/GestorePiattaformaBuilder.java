package com.unicam.IDS;

import com.unicam.IDS.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorePiattaformaBuilder {
    private ApprovabiliRepository approvabiliRepository;
    private ComuniRepository comuniRepository;
    private ContestRepository contestRepository;
    private RichiesteRepository richiesteRepository;
    private UtentiRepository utentiRepository;

    @Autowired
    public GestorePiattaformaBuilder(ComuniRepository comuniRepository, RichiesteRepository richiesteRepository, ApprovabiliRepository approvabiliRepository, ContestRepository contestRepository, UtentiRepository utentiRepository) {
        this.comuniRepository = comuniRepository;
        this.richiesteRepository = richiesteRepository;
        this.approvabiliRepository = approvabiliRepository;
        this.contestRepository = contestRepository;
        this.utentiRepository = utentiRepository;
    }

    public ApprovabiliRepository getApprovabiliRepository() {
        return approvabiliRepository;
    }

    public void setApprovabiliRepository(ApprovabiliRepository approvabiliRepository) {
        this.approvabiliRepository = approvabiliRepository;
    }

    public ComuniRepository getComuniRepository() {
        return comuniRepository;
    }

    public void setComuniRepository(ComuniRepository comuniRepository) {
        this.comuniRepository = comuniRepository;
    }

    public ContestRepository getContestRepository() {
        return contestRepository;
    }

    public void setContestRepository(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public RichiesteRepository getRichiesteRepository() {
        return richiesteRepository;
    }

    public void setRichiesteRepository(RichiesteRepository richiesteRepository) {
        this.richiesteRepository = richiesteRepository;
    }

    public UtentiRepository getUtentiRepository() {
        return utentiRepository;
    }

    public void setUtentiRepository(UtentiRepository utentiRepository) {
        this.utentiRepository = utentiRepository;
    }

}
