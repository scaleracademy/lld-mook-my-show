package com.bookmyshow.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends Auditable {
    @NotBlank
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private MPAARating mpaaRating;

    @NotBlank
    @Getter
    @Setter
    private String director;

    @NotBlank
    @Getter
    @Setter
    private String summary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    @JsonManagedReference
    @Getter
    @Setter
    private List<MovieShow> shows = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private List<Genre> genres = new ArrayList<>();

    public Movie() {
    }

    private Movie(String name, MPAARating mpaaRating) {
        this.name = name;
        this.mpaaRating = mpaaRating;
    }

    public static final class Builder {
        private @NotBlank String name;
        private MPAARating mpaaRating;
        private @NotBlank String director;
        private @NotBlank String summary;
        private List<MovieShow> shows;
        private List<Genre> genres;

        private Builder(String name, MPAARating mpaaRating) {
            this.name = name;
            this.mpaaRating = mpaaRating;
        }

        public static Builder aMovie(String name, MPAARating mpaaRating) {
            return new Builder(name, mpaaRating);
        }

        public Builder withDirector(String director) {
            this.director = director;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withShows(List<MovieShow> shows) {
            this.shows = shows;
            return this;
        }

        public Builder withGenres(List<Genre> genres) {
            this.genres = genres;
            return this;
        }

        public Movie build() {
            Movie movie = new Movie(name, mpaaRating);
            movie.setDirector(director);
            movie.setSummary(summary);
            movie.setShows(shows);
            movie.setGenres(genres);
            return movie;
        }
    }
}
