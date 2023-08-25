package DAO.v1.dao;

import DAO.v1.module.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovie();
    Movie getById(int id);
    Movie getByNameKz(String nameKz);
    void createMovie(Movie movie);
    void deleteMovie(int id);
}
