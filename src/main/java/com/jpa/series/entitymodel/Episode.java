package com.jpa.series.entitymodel;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private LocalDate releaseDate;

    private String description;

    private Integer runtime;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Season season;
}
