package com.jpa.series.entitymodel;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Season {

    @Id
    @GeneratedValue()
    private Long id;

    private Integer seasonNumber;

    @Transient
    private Integer numberOfEpisodes;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Series series;

    @Singular
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Episode> episodes;


    public Integer getNumberOfEpisodes(){
        return this.episodes.size();
    }
}
