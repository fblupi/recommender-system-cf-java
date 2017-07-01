package fblupi.rs.movielens;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Movies in Movie-Lens database
 */
public class Movies {
    /**
     * Map with the movie id as key and its name as value
     */
    private Map<Integer, String> movies;

    /**
     * Constructor
     */
    public Movies() {
        movies = new HashMap<>();
    }

    /**
     * Get number of movies
     * @return number of movies
     */
    public int size() {
        return movies.size();
    }

    /**
     * Get name of the movie with the id given
     * @param id id of the movie
     * @return
     */
    public String getName(int id) {
        return movies.get(id);
    }

    /**
     * Get the whole map with movies
     * @return map with movies
     */
    public Map<Integer, String> getMovies() {
        return  movies;
    }

    /**
     * Fill map with the films in the file with the filename given
     * @param filename name of the file with the films
     */
    public void readFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while (line != null) {
                String[] splitLine = line.split("\\|");
                movies.put(Integer.parseInt(splitLine[0]), splitLine[1]);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
