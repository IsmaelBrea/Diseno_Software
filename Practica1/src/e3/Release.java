package e3;

import java.util.HashSet;
import java.util.Objects;
import java.util.List;
import  java.util.ArrayList;


//definimos la clase Release, que representa un lanzamiento musical (un disco)
public class Release {
    private final String id; //identificador único para el lanzamiento (no se puede modificar)
    private String titulo;  //representa el título del lanzamiento
    private String artista; //representa al artista del lanzamiento
    private final List<Track> tracklist; //lista de canciones o pistas que forman parte del lanzamiento

    public Release(String id) {
        this.id = id;
        tracklist = new ArrayList<>();
    }

    //creamos los métodos para leer y escribir los atributos de Release
    public void setTitle(String titulo) { //permite establecer el título del lanzamiento
        this.titulo = titulo;
    }
    public void setArtist(String artista) { //permite establecer el artista del lanzamiento
        this.artista = artista;
    }

    public void addTrack(Track track) { //permite añadir pistas al lanzamiento
        this.tracklist.add(track);
    }

    @Override
    public String toString() { //convertimos en String los atributos de Release en una cadena de texto
        StringBuilder builder = new StringBuilder();
        builder.append("Release: ").append(titulo).append(" by ").append(artista).append("\n");
        for (Track track : tracklist) {
            builder.append(track.toString()).append("\n");
        }
        return builder.toString();
    }

    // Implementa equals y hashCode para comparar los lanzamientos
    //dos lanzamientos son iguales si y solo si contienen exactamente las mismas grabaciones independientemente
    @Override
    public boolean equals(Object o) { //mismas condiciones que en el código de track, pero en este caso comprobamos que los lanzamientos pertenezcan a la misma grabación
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Release release = (Release) o;
        return new HashSet<>(tracklist).containsAll(release.tracklist) && new HashSet<>(release.tracklist).containsAll(tracklist);
    }

    @Override
    public int hashCode() {     //Este método calcula un valor hash para el objeto
        return Objects.hash(new HashSet<>(tracklist));  //Utiliza HashSet para garantizar que la ordenación de las pistas no afecte al hashCode
    }
}