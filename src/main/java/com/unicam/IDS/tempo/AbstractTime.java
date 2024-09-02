package com.unicam.IDS.tempo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public abstract class AbstractTime implements Time {
    @Id
    @GeneratedValue
    private int id;
}
