package e3;

import java.util.Objects;

//definimos el registro Track, que representa a las pistas (canciones) de un lanzamiento (Release)
public record Track(String posicion, String idgrabacion, String artista , String titulo, int duracion) {  //definimos los parámetros que se le pasan en el test


    @Override
    public String toString() { // Convertimos en String los atributos de track (excepto idgrabacion porque no es un string cuando se crea un objeto en el test)
        return posicion + " " + artista + " " + titulo + " " + duracion;
    }


    // Implementamos equals y HashCode para comparar las pistas
    //dos pistas son iguales si y solo si corresponden a la misma grabación
    @Override
    public boolean equals(Object o) {
        if (this == o) { //verificamos si lod dos objetos son la misma instancia en memoria
            return true;
        } else if (o == null || getClass() != o.getClass()) { //si "o" es nulo o si no s una instancia de la clase
            return false; //devuelve false
        }
        Track track = (Track) o; // Convierte el objeto genérico "o" en un objeto de tipo Track.
        return idgrabacion.equals(track.idgrabacion);  // Compara el valor de idgrabacion de ambos objetos
    }

    @Override
    public int hashCode() {  //Este método calcula un valor hash para el objeto
        return Objects.hash(idgrabacion);  // Devuelve el valor hash basado en el idgrabacion del objeto
    }
}


