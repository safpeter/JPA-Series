package com.jpa.series;

import com.jpa.series.entitymodel.Episode;
import com.jpa.series.entitymodel.Genre;
import com.jpa.series.entitymodel.Season;
import com.jpa.series.entitymodel.Series;
import com.jpa.series.repository.EpisodeRepository;
import com.jpa.series.repository.SeasonRepository;
import com.jpa.series.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class SeriesApplication {

    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired
    SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args ->{
            Episode pilot = Episode.builder()
                    .title("Pilot")
                    .description("A mobster passes out at a family barbecue and" +
                            " seeks therapy to understand why.")
                    .runtime(59)
                    .build();

            Episode moltisanti = Episode.builder()
                    .title("The Legend of Tennessee Moltisanti")
                    .description("The FBI begins closing in on the DiMeo family." +
                            " Tony and Carmela are angry over all the attention Italians" +
                            " get from the authorities, while Chris fumes that he's not" +
                            " getting enough attention.")
                    .runtime(49)
                    .build();

            Episode funhouse = Episode.builder()
                    .title("Funhouse")
                    .description("Tony gets sick from food poisoning and blames" +
                            " Artie's restaurant." +
                            " Pussy, meanwhile, reaches the end of the line..")
                    .runtime(60)
                    .build();

            Episode pine = Episode.builder()
                    .title("Pine Barrens")
                    .description("While Silvio has the flu, Chris and Paulie" +
                            " run his collections for him, which results in the pair" +
                            " getting lost in the woods and nearly freezing to death.")
                    .runtime(60)
                    .build();

            Season season1 = Season.builder()
                    .seasonNumber(1)
                    .episodes(Arrays.asList(pilot,moltisanti))
                   .build();

            Season season2 = Season.builder()
                    .seasonNumber(2)
                    .episode(funhouse)
                    .build();

            Season season3 = Season.builder()
                    .seasonNumber(3)
                    .episode(pine)
                    .build();

            Series sopranos = Series.builder()
                    .title("The Sopranos")
                    .firstReleased(LocalDate.of(1999, 1, 14))
                    .description("New Jersey mob boss Tony Soprano deals " +
                            "with personal and professional issues in his home" +
                            " and business life that affect his mental state," +
                            " leading him to seek professional psychiatric counseling.")
                    .genres(Arrays.asList(Genre.CRIME,Genre.DRAMA))
                    .seasons(Arrays.asList(season1,season2,season3))
                    .build();


            seriesRepository.save(sopranos);



        };
    }

}
