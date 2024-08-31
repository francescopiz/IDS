package com.unicam.IDS.models.approvabili;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Contenuto extends Approvabile {
    private String nome;
    private String descrizione;

    @Transient
    private List<MultipartFile> fileMultimediali;

    public Contenuto(int id, String nome, String descrizione, List<MultipartFile> fileMultimediali) {
        super(nome, descrizione);
        this.fileMultimediali = fileMultimediali;
    }

    public Contenuto(int id, String nome, String descrizione) {
        super(nome, descrizione);
        this.fileMultimediali = new ArrayList<>();
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