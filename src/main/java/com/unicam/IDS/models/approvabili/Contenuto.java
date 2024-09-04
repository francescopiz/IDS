package com.unicam.IDS.models.approvabili;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Contenuto extends Approvabile {
    private String nome;
    private String descrizione;

    @ManyToOne(fetch = FetchType.EAGER)
    private POI poi;

    @Transient
    private List<MultipartFile> fileMultimediali;

    public Contenuto(String nome, String descrizione, POI poi) {
        super(nome, descrizione);
        this.fileMultimediali = null;
        this.poi = poi;
    }

    public Contenuto(String nome, String descrizione, List<MultipartFile> fileMultimediali, POI poi) {
        this(nome, descrizione, poi);
        this.fileMultimediali = fileMultimediali;
    }

    public Contenuto() {
        this.fileMultimediali = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<MultipartFile> getFileMultimediali() {
        return fileMultimediali;
    }

    @Override
    public String toString() {
        return "Contenuto{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", fileMultimediali=" + fileMultimediali +
                '}';
    }
}