package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private List<MovieDTO> movies = new ArrayList<>();

    public GenreDTO() { }

    public GenreDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO (Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public GenreDTO (Genre entity, List<Movie> movies) {
        this(entity);
        movies.forEach(movie -> this.movies.add(new MovieDTO(movie)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
