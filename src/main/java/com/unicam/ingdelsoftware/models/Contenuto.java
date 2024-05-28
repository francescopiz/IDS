package com.unicam.ingdelsoftware.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Contenuto {
    private String testo;
    private final List<File> fileMultimediali;
    private final int id;

    public Contenuto(int id, String testo, List<File> fileMultimediali) {
        this.id=id;
        this.testo = testo;
        this.fileMultimediali = fileMultimediali;
    }
    public Contenuto(int id, String testo) {
        this.id = id;
        this.testo = testo;
        this.fileMultimediali = new ArrayList<>();
    }
    public Contenuto(int id, List<File> fileMultimediali) {
        this.id = id;
        this.testo="";
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

    //public void addFileMultimediale(File fileMultimediale) {
    //    this.fileMultimediali.add(fileMultimediale);
    //}
    //public void removeFileMultimediale(File fileMultimediale) {
    //    this.fileMultimediali.remove(fileMultimediale);
    //}

    public int getId() {
        return id;
    }
}