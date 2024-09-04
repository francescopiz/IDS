package com.unicam.IDS.tempo;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class AbstractTime implements Tempo {
    @Id
    @GeneratedValue
    private int id;
}