package e3;

import java.util.Comparator;
public class SortByExternalLink implements Comparator<Artist> {
    //Compara la cantidad de enlaces externos de los artistas en orden decreciente

    @Override
    public int compare(Artist artist1, Artist artist2) {
        int size1 = artist1.getExternalLinks().size();
        int size2 = artist2.getExternalLinks().size();

        return Integer.compare(size2, size1);
    }
}