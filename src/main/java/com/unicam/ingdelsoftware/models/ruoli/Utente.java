package com.unicam.ingdelsoftware.models.ruoli;

public class Utente {
    String userName;
    int id;
    String email;

    public Utente(String userName, int id, String email) {
        this.userName = userName;
        this.id = id;
        this.email=email;
    }

    public String getNome() {
        return userName;
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
        return "userName: " + userName + "/ id: " + id + "/ email: " + email;
    }

}
