package com.unicam.IDS;

import com.unicam.IDS.models.ruoli.GestorePiattaforma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GestorePiattaformaConfiguration {
    private GestorePiattaformaBuilder gestorePiattaformaBuilder;
    @Autowired
    public GestorePiattaformaConfiguration(GestorePiattaformaBuilder gestorePiattaformaBuilder){
        this.gestorePiattaformaBuilder = gestorePiattaformaBuilder;

    }
    @Bean
    public GestorePiattaforma gestorePiattaforma() {
        return GestorePiattaforma.getInstance(gestorePiattaformaBuilder);
    }

}