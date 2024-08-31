package com.unicam.IDS.repositorys;

import com.unicam.IDS.models.richieste.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RichiesteRepository extends JpaRepository<Richiesta, Integer> {
}
