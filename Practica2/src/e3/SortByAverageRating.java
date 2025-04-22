package e3;

import java.util.Comparator;

public class SortByAverageRating implements Comparator<Artist> {
    //Compara las puntuaciones medias de los artistas en orden ascendente

    @Override
    public int compare(Artist a1, Artist a2) {
        return Double.compare(a1.getAverageRatingValue(), a2.getAverageRatingValue());
    }
}