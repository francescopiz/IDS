package com.unicam.ingdelsoftware.models;

public class Comune {
    private String nome;
    private String id;
    private String provincia;
    private Posizione posizione;
    public Comune(String nome, String id, String provincia, Posizione posizione) {
        this.nome = nome;
        this.id = id;
        this.provincia = provincia;
        this.posizione = posizione;
    }
    public Comune(){}
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getProvincia() {
        return provincia;
    }
    public Posizione getPosizione() {
        return posizione;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comune comune)) return false;
        return id.equals(comune.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Comune{" +
                "nome='" + nome + '\'' +
                ", provincia='" + provincia + '\'' +
                ", id='" + id + '\'' +
                ", " + posizione.toString() +
                '}';
    }
}
