package com.unicam.IDS.models.approvabili;

import com.unicam.IDS.repositorys.ApprovabiliRepository;

import java.util.List;

public class GestoreApprovabili {

    private final ApprovabiliRepository approvabiliRepository;

    public GestoreApprovabili(ApprovabiliRepository approvabiliRepository) {
        this.approvabiliRepository = approvabiliRepository;
    }

    public boolean addApprovabile(Approvabile approvabile) {
        if (approvabile == null || approvabiliRepository.existsById(approvabile.getId())) return false;
        this.approvabiliRepository.save(approvabile);
        return true;
    }

    public boolean deleteApprovabile(Approvabile approvabile) {
        if (approvabile == null || !approvabiliRepository.existsById(approvabile.getId())) return false;
        this.approvabiliRepository.delete(approvabile);
        return true;
    }

    public boolean getApprovabileById(int id) {
        return approvabiliRepository.existsById(id);
    }

    public List<Approvabile> getApprovabili() {
        return approvabiliRepository.findAll();
    }

    public List<Approvabile> getApprovabiliComune(int idComune) {
        return approvabiliRepository.findAll().stream().filter(approvabile -> approvabile.getIdComune() == idComune).toList();
    }

}
