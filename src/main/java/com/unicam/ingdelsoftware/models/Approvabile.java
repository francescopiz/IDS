package com.unicam.ingdelsoftware.models;


public abstract class Approvabile {
    final int id;
    protected boolean approvato;

    public Approvabile (int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isApprovato() {
        return approvato;
    }

    public void setApprovato(boolean approvato) {
        this.approvato = approvato;
    }
}