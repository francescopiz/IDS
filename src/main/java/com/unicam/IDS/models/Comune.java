package com.unicam.IDS.models;

import com.unicam.IDS.models.approvabili.Posizione;
import jakarta.persistence.*;

@Entity
public class Comune {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String provincia;
    @Embedded
    private Posizione posizioneComune;

    public Comune(String nome, String provincia, Posizione posizioneComune) {
        this.nome = nome;
        this.provincia = provincia;
        this.posizioneComune = posizioneComune;
    }

    public Comune() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public Posizione getPosizioneComune() {
        return posizioneComune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comune comune)) return false;
        return id == comune.getId();
    }

    @Override
    public String toString() {
        return "Comune{" +
                "nome='" + nome + '\'' +
                ", provincia='" + provincia + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}