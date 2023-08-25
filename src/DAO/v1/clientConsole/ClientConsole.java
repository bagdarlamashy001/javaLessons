package DAO.v1.clientConsole;

import DAO.v1.dao.MovieDao;
import DAO.v1.daoimpl.MovieDaoImpl;
import DAO.v1.module.Movie;

import java.util.Scanner;

public class ClientConsole {
    private String nameKz, description;
    private Movie movie = new Movie();
    private MovieDao movieDao = new MovieDaoImpl();

    public static void main(String[] args) {
        String menu = "\"Жаңадан кино қосу үшін \"create\" сөзін еңгізіңіз. \n"+
                        "Кинолар тізімін көру үшін \"allMovie\" сөзін еңгізіңіз. \n" +
                        "Киноны id арқылы табу үшін \"getById\" сөзін еңгізіңіз. \n" +
                        "Киноны жою үшін \"deleteMovie\" сөзін еңгізіңіз. ";
        ClientConsole clientConsole = new ClientConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println(menu);
        switch (scanner.nextLine()){
            case "create" : clientConsole.createMovie();
            break;
            case "allMovie" : clientConsole.showAllMovie();
            break;
            case "getById" : clientConsole.getById();
            break;
            case "deleteMovie" : clientConsole.deleteMovie();
            break;
            default: System.out.println("Сізді түсінбедім!!! нұсқауды қайта қарап көріңіз:\n" + menu);
        }
    }

    public void createMovie(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кино атын еңгізініз: \t");
        nameKz = scanner.nextLine();
        System.out.print("Кино сипаттамасын еңгізініз: \t");
        description = scanner.nextLine();

        movie.setNameKz(nameKz);
        movie.setDescription(description);

        movieDao.createMovie(movie);

    }

    public void showAllMovie(){
        movieDao.getAllMovie().forEach(System.out::println);
    }

    public void getById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Киноны id арқылы табу үшін сан еңгізіңіз. Мысалы: 2 ");
        int id = scanner.nextInt();
        System.out.println(movieDao.getById(id));
    }

    public void deleteMovie(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Киноны жою үшін киноның id ңөмерін еңгізіңіз. Мысалы: 2 ");
        int id = scanner.nextInt();
        movieDao.deleteMovie(id);
    }
}
