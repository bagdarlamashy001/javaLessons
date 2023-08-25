package DAO.v1.daoimpl;

import DAO.v1.dao.MovieDao;
import DAO.v1.module.Movie;
import DAO.v1.module.MysqlConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
    @Override
    public List<Movie> getAllMovie() {
        List<Movie> movies = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(MysqlConnector.DB_URL, MysqlConnector.USER, MysqlConnector.PASS);
             Statement statement = conn.createStatement();){
            String sql = "SELECT * FROM movie";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                movies.add(
                        new Movie(resultSet.getInt("id"),
                                resultSet.getString("nameKz"),
                                resultSet.getString("description"))
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    @Override
    public Movie getById(int id) {
        Movie movie2 = null;
        for(Movie movie : getAllMovie()){
            if(movie.getId() == id) movie2 = movie;
        }
        return movie2;
    }

    @Override
    public Movie getByNameKz(String nameKz) {
        return null;
    }

    @Override
    public void createMovie(Movie movie) {
        try (Connection conn = DriverManager.getConnection(MysqlConnector.DB_URL, MysqlConnector.USER, MysqlConnector.PASS);
                Statement statement = conn.createStatement()){
            String sql = "INSERT INTO movie (nameKz, description) " +
                          "VALUES('"+movie.getNameKz()+"', '"+movie.getDescription()+"')";

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMovie(int id){
        try (Connection conn = DriverManager.getConnection(MysqlConnector.DB_URL, MysqlConnector.USER, MysqlConnector.PASS);
             Statement statement = conn.createStatement()){
            String sql = "DELETE FROM movie WHERE id = "+ id;

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
