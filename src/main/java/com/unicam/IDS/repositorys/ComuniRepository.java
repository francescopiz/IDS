package com.unicam.IDS.repositorys;

import com.unicam.IDS.models.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuniRepository extends JpaRepository<Comune, Integer> {
}
