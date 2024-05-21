package com.unicam.ingdelsoftware.models;

import java.io.File;
import java.util.List;

public class Contenuto {
    private String testo;
    private List<File> fileMultimediali;
    private final String id;

    public Contenuto(String id, String testo, List<File> fileMultimediali) {
        this.id=id;
        this.testo = testo;
        this.fileMultimediali = fileMultimediali;
    }
    public Contenuto(String id, String testo) {
        this.id = id;
        this.testo = testo;
        this.fileMultimediali = null;
    }
    public Contenuto(String id, List<File> fileMultimediali) {
        this.id = id;
        this.testo=null;
        this.fileMultimediali = fileMultimediali;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public List<File> getFileMultimediali() {
        return fileMultimediali;
    }
    public void addFileMultimediale(File fileMultimediale) {
        this.fileMultimediali.add(fileMultimediale);
    }
    public void removeFileMultimediale(File fileMultimediale) {
        this.fileMultimediali.remove(fileMultimediale);
    }

    public String getId() {
        return id;
    }
}