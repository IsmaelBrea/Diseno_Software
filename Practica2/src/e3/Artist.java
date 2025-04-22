package e3;

import java.util.List;

public class Artist implements Comparable<Artist> {
    //atributos de artista de distinto tipo
    private final String nombre;
    private final String id;
    private  List<Integer> ratings;  //colección de puntuaciones del artista (puntuaciones entre 0 y 5)
    private  List<String> genres;  //colección de géneros (eclectismo)
    private final BiographySummary biographySummary; //resumen de la información del artista
    private List<ExternalLink> externalLinks;  //lista con links externos del artista
    private double averageRatingValue; //puntuación media del artista


    //método constructor
    public Artist(String nombre, String id, List<Integer> ratings, List<String> genres, BiographySummary biographySummary, List<ExternalLink> externalLinks) {
        if (nombre == null || id == null) {
            throw new IllegalArgumentException("Nombre e ID no pueden ser nulos");
        }
        this.nombre = nombre;
        this.id = id;
        this.ratings = ratings != null ? ratings : List.of(); //inicializamos las listas
        this.genres = genres != null ? genres : List.of();    //inicializamos las listas
        this.biographySummary = biographySummary;
        this.externalLinks = externalLinks != null ? externalLinks : List.of();  //inicializamos las listas
        //averageRatingValue no se inicializa porque es el valor medio de las puntuaciones introducidas en la lista ratings
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public List<Integer> getRatings() {
        return ratings;
    }


    public void setRatings(List<Integer> ratings) {
        if (ratings == null) {
            throw new IllegalArgumentException("La lista de puntuaciones no puede ser nula");
        }
        this.ratings = ratings;

        this.averageRatingValue = calculateAverageRating();
    }

    public List<String> getGenres() {
        return genres;
    }


    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public BiographySummary getBiographySummary() {
        return biographySummary;
    }


    public List<ExternalLink> getExternalLinks() {
        return externalLinks;
    }

    public double getAverageRatingValue() {
        return averageRatingValue;
    }

    public double calculateAverageRating() {
        double sum = 0;
        int count = 0;

        for (Integer rating : ratings) {
            if (rating >= 0 && rating <= 5) {
                sum += rating;
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
    }


    @Override
    public int compareTo(Artist otherArtist) {  //método compareTo de Comparable para comparar los id de los artistas
        return this.id.compareTo(otherArtist.getId());
    }

}