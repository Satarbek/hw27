package period4.hw.hw3.Task1;

import java.util.List;

public class FileService {

    private List<Movie> movies;



    public FileService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "FileService{" +
                "movies=" + movies +
                '}';
    }
}
