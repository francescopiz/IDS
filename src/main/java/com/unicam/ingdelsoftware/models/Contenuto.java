package com.unicam.ingdelsoftware.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Contenuto {
    private String nome;
    private String testo;
    private final List<File> fileMultimediali;
    private final int id;

    public Contenuto(int id, String nome, String testo, List<File> fileMultimediali) {
        this.id=id;
        this.nome = nome;
        this.testo = testo;
        this.fileMultimediali = fileMultimediali;
    }
    public Contenuto(int id, String nome, String testo) {
        this.id = id;
        this.nome = nome;
        this.testo = testo;
        this.fileMultimediali = new ArrayList<>();
    }
    public Contenuto(int id, String nome, List<File> fileMultimediali) {
        this.id = id;
        this.nome = nome;
        this.testo="";
        this.fileMultimediali = fileMultimediali;
    }

    public String getNome() { return nome;}
    public void setNome(String n){nome = n;}
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