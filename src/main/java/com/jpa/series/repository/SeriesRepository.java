package com.jpa.series.repository;

import com.jpa.series.entitymodel.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
