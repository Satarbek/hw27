package period4.hw.hw3.Task1;

import java.util.List;

public class Movie{

    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    public Movie(String name, int year, String description, Director director, List<Cast> cast) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {

        String actor = "";

        String fmt = "| %-41s | %-15s | %-11s | %-17s   %s ";
        for (int i = 0; i < cast.size(); i++) {
            actor += cast.get(i).getFullName() + " | " + cast.get(i).getRole() + "\n|" + "                                           |                 |             |                     |  ";
        }
        String print = String.format(fmt, name, year, description, director.getFullName(),actor);
        return print;
    }
}
