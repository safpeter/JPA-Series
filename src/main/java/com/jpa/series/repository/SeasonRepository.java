package com.jpa.series.repository;

import com.jpa.series.entitymodel.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
