package com.unicam.IDS.models;

import com.unicam.IDS.models.ruoli.Utente;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Iscrizione {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Utente iscritto;
    @ManyToOne
    private Contest contest;
    @Transient
    private MultipartFile file;

    private String descrizione;


    public Iscrizione(Utente iscritto, Contest contest, MultipartFile file) {
        this.iscritto = iscritto;
        this.contest = contest;
        this.file = file;
    }

    public Iscrizione(Utente iscritto, Contest contest, String descrizione) {
        this.descrizione = descrizione;
    }

    public Iscrizione() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Iscrizione that)) return false;
        return iscritto.equals(that.iscritto) && contest.equals(that.contest);
    }

    @Override
    public int hashCode() {
        return iscritto.hashCode() + contest.hashCode();
    }

    @Override
    public String toString() {
        return "Iscrizione{" +
                "iscritto=" + iscritto.toString() +
                ", contest=" + contest.toString() +
                ", file=" + file +
                '}';
    }

    public Utente getIscritto() {
        return iscritto;
    }
    public Contest getContest() {
        return contest;
    }
}