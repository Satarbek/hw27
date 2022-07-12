package period4.hw.hw3.Task1;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){

        FileService movies = getMoviesList();
        System.out.println();
        String fmt = "%100s";
        System.out.println(String.format(fmt, "<<<<<<<<<<Movies collection>>>>>>>>>>"));
        printMoviesList(movies);
        System.out.println();
        getSortCollection(movies);
    }

    public static void printMoviesList(FileService movies){

        System.out.println("\n+-------------------------------------------+-----------------+-------------+---------------------+--------------------------------+");
        String fmtHead = "| %-41s | %-4s | %-9s | %-17s   | %-30s |";
        System.out.println(String.format(fmtHead, "Movie's name", "Year of release", "Description", "Director", "Cast"));
        System.out.println("+-------------------------------------------+-----------------+-------------+---------------------+--------------------------------+");
        for (Movie movie : movies.getMovies()){
            System.out.println(movie);
            System.out.println("+-------------------------------------------+-----------------+-------------+---------------------+--------------------------------+");
        }
    }

    public static FileService getMoviesList(){
        Gson gson = new Gson();
        String json = "";
        Path path = Paths.get("./movies.json");

        try {
            json = Files.readString(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        return gson.fromJson(json, FileService.class);
    }

    public static void getSortCollection(FileService movies){
        System.out.println("Please choose action: ");
        System.out.println("1 - sorted by release year <*****> 2 - sort by movie title <*****> 3 - sort by movie director");
        Scanner scanner = new Scanner(System.in);
        int actionNum = scanner.nextInt();
        switch (actionNum){
            case 1:
                getSortYear(movies);
                break;
            case 2:
                getSortTitle(movies);
                break;
            case 3:
                getSortDirector(movies);break;
            default:
                getSortCollection(movies);

        }
    }

    public static void getSortYear(FileService movies){
        System.out.println("Please, choose sort by ascending - a, desc - d");
        Scanner sortYear = new Scanner(System.in);
        String sortY = sortYear.nextLine().toLowerCase();
        switch (sortY){
            case "a":
                System.out.println();
                String fmt = "%100s";
                System.out.println(String.format(fmt, "<<<<<<<<<<Movies collection, sorted by year of release (ascending)>>>>>>>>>>"));

                Comparator releaseYear = Comparator.comparing(Movie:: getYear);
                movies.getMovies().sort(releaseYear);
                printMoviesList(movies);
                break;

            case "d":
                System.out.println();
                String fmt2 = "%100s";
                System.out.println(String.format(fmt2, "<<<<<<<<<<Movies collection, sorted by year of release (desc)>>>>>>>>>>"));

                Comparator releaseYear2 = Comparator.comparing(Movie:: getYear);
                movies.getMovies().sort(releaseYear2.reversed());
                printMoviesList(movies);
                break;

            default:
                getSortYear(movies);
        }


    }

    public static void getSortTitle(FileService movies){
        System.out.println("Please, choose sort from A to Z - a, from Z to A - z");
        Scanner sortTitle = new Scanner(System.in);
        String sortT = sortTitle.nextLine().toLowerCase();
        switch (sortT){
            case "a":
                System.out.println();
                String fmt = "%100s";
                System.out.println(String.format(fmt, "<<<<<<<<<<Movies collection, sorted by movie title (from A to Z)>>>>>>>>>>"));
                Comparator movieTitle = Comparator.comparing(Movie:: getName);
                movies.getMovies().sort(movieTitle);
                printMoviesList(movies);
                break;
            case "z":
                System.out.println();
                String fmt2 = "%100s";
                System.out.println(String.format(fmt2, "<<<<<<<<<<Movies collection, sorted by movie title (from Z to A)>>>>>>>>>>"));
                Comparator movieTitle2 = Comparator.comparing(Movie:: getName);
                movies.getMovies().sort(movieTitle2.reversed());
                printMoviesList(movies);
                break;
            default:
                getSortTitle(movies);
        }

    }

    public static void getSortDirector(FileService movies) {

        // в принципе сортируется. но именно на букву S как то выпадает. А остальные норм.

        System.out.println("Please, choose sort from A to Z - a, from Z to A - z");
        Scanner sortDirector = new Scanner(System.in);
        String sortD = sortDirector.nextLine().toLowerCase();
        switch (sortD) {
            case "a":
                System.out.println();
                String fmt = "%100s";
                System.out.println(String.format(fmt, "<<<<<<<<<<Movies collection, sorted by director (from A to Z)>>>>>>>>>>"));
                Comparator director = Comparator.comparing(Movie:: getName);
                movies.getMovies().sort(director);
                printMoviesList(movies);
                break;
            case "z":
                System.out.println();
                String fmt2 = "%100s";
                System.out.println(String.format(fmt2, "<<<<<<<<<<Movies collection, sorted by director (from Z to A)>>>>>>>>>>"));
                Comparator director2 = Comparator.comparing(Movie::getName);
                movies.getMovies().sort(director2.reversed());
                printMoviesList(movies);
                break;
            default:
                getSortDirector(movies);
        }
    }
}
