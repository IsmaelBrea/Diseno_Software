package e3;

import java.util.Comparator;

public class SortByBiographySummary implements Comparator<Artist> {
    //Compara los resúmenes biográficos de los artistas en orden creciente

    @Override
    public int compare(Artist artist1, Artist artist2) {
        return artist1.getBiographySummary().getSummary().compareTo(artist2.getBiographySummary().getSummary());
    }
}