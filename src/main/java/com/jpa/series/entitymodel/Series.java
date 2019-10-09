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
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private LocalDate firstReleased;

    private String description;

    @Singular
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;
}
