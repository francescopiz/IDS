package com.unicam.IDS.models;
import com.unicam.IDS.GestoreComunale;
import com.unicam.IDS.GestoreContest;
import com.unicam.IDS.models.approvabili.GestoreApprovabili;
import com.unicam.IDS.models.richieste.GestoreRichieste;
import com.unicam.IDS.repositorys.ApprovabiliRepository;
import com.unicam.IDS.repositorys.ComuniRepository;
import com.unicam.IDS.repositorys.ContestRepository;
import com.unicam.IDS.repositorys.RichiesteRepository;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import java.util.Set;
public class GestoreComuni {
    private ComuniRepository comuniRepository;
    private final Set<GestoreComunale> gestoriComunali;
    private final GestoreApprovabili gestoreApprovabili;
    private final GestoreRichieste gestoreRichieste;
    private final GestoreContest gestoreContest;


    public GestoreComuni(ComuniRepository comuniRepository, ApprovabiliRepository approvabiliRepository, RichiesteRepository richiesteRepository, ContestRepository contestRepository) {
        this.comuniRepository = comuniRepository;
        this.gestoriComunali = new HashSet<GestoreComunale>();
        this.gestoreApprovabili = new GestoreApprovabili(approvabiliRepository);
        this.gestoreRichieste = new GestoreRichieste(richiesteRepository); //TODO dobbiamo ancora cambiare e metterli a singleton, è giusto così, non cambiare anche se da errore
        this.gestoreContest = new GestoreContest(contestRepository);//TODO dobbiamo ancora cambiare e metterli a singleton
    }


    public boolean addComune(Comune comune) {
        if (!comuniRepository.existsById(comune.getId())) {
            this.comuniRepository.save(comune);
            return gestoriComunali.add(new GestoreComunale(comuniRepository, gestoreApprovabili, gestoreRichieste,gestoreContest, comune));
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


    public Set<Comune> getComuni() {
        return new HashSet<>(comuniRepository.findAll());
    }


    public Comune getComuneDaNomeOSM(String nomeOSM) {
        Stream<Comune> comune = comuniRepository.findAll().stream().filter(x -> x.getNomeOSM().equals(nomeOSM));
        return comune.findFirst().orElse(null);
    }


    public GestoreComunale getGestoreComunaleByComune(Comune comune) {
        return gestoriComunali.stream().filter(gc -> gc.getComune().equals(comune)).findFirst().orElse(null);
    }



    public Set<GestoreComunale> getGestoriComunali() {
        return gestoriComunali;
    }
}