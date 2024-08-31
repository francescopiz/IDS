package com.unicam.IDS.repositorys;

import com.unicam.IDS.models.ruoli.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository extends JpaRepository<Utente, Integer> {
}
