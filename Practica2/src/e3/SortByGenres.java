package e3;

import java.util.Comparator;


public class SortByGenres implements Comparator<Artist> {
    //Compara el tamaño de las listas de géneros de los artistas para ordenar en orden decreciente

    @Override
    public int compare(Artist artist1, Artist artist2) {
        return Integer.compare(artist2.getGenres().size(), artist1.getGenres().size());
    }
}