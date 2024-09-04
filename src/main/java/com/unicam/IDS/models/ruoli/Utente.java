package com.unicam.IDS.models.ruoli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    int id;
    String nome;
    String email;

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Utente() {
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Utente utente)) return false;
        return utente.getId().equals(id);
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "userName: " + nome + "/ id: " + id + "/ email: " + email;
    }

}
