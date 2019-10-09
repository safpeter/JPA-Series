package com.jpa.series.repository;

import com.jpa.series.entitymodel.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long>{

}
