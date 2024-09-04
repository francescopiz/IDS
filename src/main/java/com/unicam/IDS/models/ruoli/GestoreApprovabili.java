package com.unicam.IDS.models.ruoli;

import com.unicam.IDS.dtos.ApprovabileDto;
import com.unicam.IDS.models.approvabili.Approvabile;
import com.unicam.IDS.models.approvabili.ApprovabileBuilder;
import com.unicam.IDS.repositorys.ApprovabiliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.Set;

/**
 * Classe che gestisce gli Approvabili.
 */
@Component
public class GestoreApprovabili {

    private final ApprovabiliRepository approvabiliRepository;

    @Autowired
    public GestoreApprovabili(ApprovabiliRepository approvabiliRepository) {
        this.approvabiliRepository = approvabiliRepository;
    }

    public Approvabile getApprovabileByApprovabileDto(ApprovabileDto approvabileDto) {
        ApprovabileBuilder approvabileBuilder = new ApprovabileBuilder();
        Approvabile approvabile = approvabileBuilder.setNome(approvabileDto.nome()).setDescrizione(approvabileDto.descrizione())
                .addIscritti(approvabileDto.iscritti()).setPosizione(approvabileDto.posizione())
                .addListaPOI(approvabileDto.listaPOI()).addFileMultimediali(approvabileDto.listafileMultimediali())
                .addElencoContenuti(approvabileDto.listaContenuti()).setTempo(approvabileDto.tempo())
                .setIsItinerario(approvabileDto.isItinerario()).setPOI(approvabileDto.poi()).build();
        approvabileBuilder.reset();
        return approvabile;
    }

    public boolean addApprovabile(Approvabile approvabile, int idComune) {
        if (approvabile == null || existsApprovabileById(approvabile.getId())) return false;
        approvabile.setIdComune(idComune);
        this.approvabiliRepository.save(approvabile);
        return true;
    }

    public boolean deleteApprovabile(Approvabile approvabile) {
        if (approvabile == null || !this.existsApprovabileById(approvabile.getId())) return false;
        this.approvabiliRepository.delete(approvabile);
        return true;
    }

    public Approvabile getApprovabileById(int id) {
        return approvabiliRepository.findById(id).orElse(null);
    }

    public List<Approvabile> getApprovabili() {
        return approvabiliRepository.findAll().stream().filter(Approvabile::isVisibile).toList();
    }

    public List<Approvabile> getApprovabiliComune(int idComune) {
        return approvabiliRepository.findAll().stream().filter(approvabile -> approvabile.getIdComune() == idComune)
                .filter(Approvabile::isVisibile).toList();
    }

    public boolean existsApprovabileById(int idApprovabile) {
        return approvabiliRepository.existsById(idApprovabile);
    }

}