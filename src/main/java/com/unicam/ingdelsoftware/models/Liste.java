




package com.unicam.ingdelsoftware.models;


import java.util.ArrayList;
import java.util.List;

//classe univoca che contiene tutte le liste dei con tutte le varie istanze di oggetti
public class Liste {
    private List<Comune> listaComuni;




    public Liste(){
        listaComuni = new ArrayList<>();
    }

    public List<Comune> getListaComuni() {
        return listaComuni;
    }

    public void addComune(Comune comune) {
        this.listaComuni.add(comune);
    }
}
