import e3.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ArtistTest {
    // Crear lista de artistas
    List<Artist> artistList = new ArrayList<>();

    // Crear instancias de artistas con sus atributos

    //ARTISTA1
    Artist artist1 = new Artist(
            "TheBeatles",
            "b10bbbfc-cf9e-42e0-be17-e2c3e1d2600d",
            generateRatings(),
            List.of("Rock", "Pop", "Pop-rock", "Psychedelic pop", "Merseybeat"),
            new BiographySummary("Group", null, null, "England,United Kingdom"),
            List.of(new ExternalLink("Official HomePage", "https://www.thebeatles.com/"),
                    new ExternalLink("Twitter", "https://twitter.com/i/flow/login?redirect_after_login=%2Fthebeatles"),
                    new ExternalLink("Instagram", "https://www.instagram.com/thebeatles/"),
                    new ExternalLink("Twitter", "https://www.instagram.com/thebeatles/"),
                    new ExternalLink("45cat", "https://www.45cat.com/artist/the-beatles"),
                    new ExternalLink("AllMusic", "https://www.allmusic.com/artist/the-beatles-mn0000754032"),
                    new ExternalLink("Amazon Music US", "https://www.amazon.com/The-Beatles/e/B000APTK6K"),
                    new ExternalLink("Apple Music GB", "https://music.apple.com/gb/artist/the-beatles/136975"),
                    new ExternalLink("Apple Music US", "https://music.apple.com/us/artist/the-beatles/136975"),
                    new ExternalLink("BnF Catalogue", "https://catalogue.bnf.fr/ark:/12148/cb13891663s"),
                    new ExternalLink("Castalbums", "https://castalbums.org/people/The_Beatles/2150"),
                    new ExternalLink("CDJapan", "https://www.cdjapan.co.jp/person/000542638"),
                    new ExternalLink("Discogs", "https://www.discogs.com/artist/82730-The-Beatles"),
                    new ExternalLink("DNB", "https://d-nb.info/gnd/118510663"),
                    new ExternalLink("Genius", "https://genius.com/artists/The-beatles"),
                    new ExternalLink("IMDb", "https://www.imdb.com/name/nm1023707/"),
                    new ExternalLink("IMVDb", "https://imvdb.com/n/the-beatles"),
                    new ExternalLink("iTunes MX", "https://music.apple.com/mx/artist/the-beatles/136975"),
                    new ExternalLink("Library of Congress", "https://lccn.loc.gov/n96016806"),
                    new ExternalLink("mora", "https://mora.jp/package/43000004/00602567972617/"),
                    new ExternalLink("MusicMoz", "https://musicmoz.org/Bands_and_Artists/B/Beatles,_The/"),
                    new ExternalLink("Musik-Sammler", "https://www.musik-sammler.de/artist/the-beatles/"),
                    new ExternalLink("Musixmatch", "https://www.musixmatch.com/artist/The-Beatles"),
                    new ExternalLink("Muziekweb", "https://www.muziekweb.nl/en/Link/M00000000073"),
                    new ExternalLink("Muzikum", "https://muzikum.eu/en/120-2160/the-beatles/lyrics.html"),
                    new ExternalLink("Napster US", "https://us.napster.com/artist/the-beatles"),
                    new ExternalLink("Open Library", "https://openlibrary.org/authors/OL24098A/The_Beatles"),
                    new ExternalLink("Prog Archives", "https://www.progarchives.com/artist.asp?id=2143"),
                    new ExternalLink("Qobuz", "https://www.qobuz.com/es-es/interpreter/the-beatles/download-streaming-albums"),
                    new ExternalLink("Qobuz", "https://www.qobuz.com/gb-en/interpreter/the-beatles/download-streaming-albums"),
                    new ExternalLink("Rate Your Music", "https://rateyourmusic.com/artist/the-beatles"),
                    new ExternalLink("SecondHandSongs", "https://secondhandsongs.com/artist/664"),
                    new ExternalLink("setlist.fm", "https://www.setlist.fm/setlists/the-beatles-63d6be6b.html"),
                    new ExternalLink("Songkick", "https://www.songkick.com/artists/369224-beatles"),
                    new ExternalLink("SoundtrackCollector", "https://www.soundtrackcollector.com/catalog/composerdiscography.php?composerid=1273"),
                    new ExternalLink("Spirit of Rock", "https://www.spirit-of-rock.com/es/band/The_Beatles"),
                    new ExternalLink("Stream at Deezer", "https://www.deezer.com/en/artist/118"),
                    new ExternalLink("Stream at Migu Music", "https://m.music.migu.cn/v3/music/artist/11077"),
                    new ExternalLink("Stream at Spotify", "https://open.spotify.com/artist/3WrFJ7ztbogyGnTHbHJFl2"),
                    new ExternalLink("Stream at Tidal", "https://listen.tidal.com/artist/487"),
                    new ExternalLink("The Beatles", "https://www.thebeatles.com/"),
                    new ExternalLink("thebeatles", "https://twitter.com/i/flow/login?redirect_after_login=%2Fthebeatles"),
                    new ExternalLink("thebeatles", "https://www.instagram.com/thebeatles/"),
                    new ExternalLink("thebeatles", "https://www.45cat.com/artist/the-beatles"),
                    new ExternalLink("thebeatles", "https://www.facebook.com/thebeatles/"),
                    new ExternalLink("Trove", "https://trove.nla.gov.au/people/1064786"),
                    new ExternalLink("UK: B000APTK6K", "https://music.amazon.co.uk/artists/B000APTK6K/the-beatles"),
                    new ExternalLink("VIAF: 141205608", "https://viaf.org/viaf/141205608"),
                    new ExternalLink("WhoSampled", "https://www.whosampled.com/The-Beatles/"),
                    new ExternalLink("Wikidata: Q1299", "https://www.wikidata.org/wiki/Q1299"),
                    new ExternalLink("WorldCat", "https://www.worldcat.org/identities/lccn-no96016806/"),
                    new ExternalLink("YesAsia", "https://www.yesasia.com/global/the-beatles/0-aid162889-0/buy")
            )

    );


    //ARTISTA2
    Artist artist2 = new Artist(
            "Madonna",
            "79239441-bfd5-4981-a70c-55c3f15c1287",
            generateRatings2(),
            List.of("Pop", "Dance-pop", "Electropop", "Art-pop", "Electronic"),
            new BiographySummary("Person", "Female", 1958, "Bay City,Michigan,USA"),
            List.of(new ExternalLink("Official homepage", "https://www.madonna.com/"),
                    new ExternalLink("Blog", "https://www.madonna.com/news"),
                    new ExternalLink("@madonna", "https://twitter.com/madonna"),
                    new ExternalLink("@Madonna", "https://twitter.com/Madonna"),
                    new ExternalLink("45cat", "https://www.45cat.com/artist/madonna"),
                    new ExternalLink("AllMusic", "https://www.allmusic.com/artist/madonna-mn0000237205"),
                    new ExternalLink("Amazon Music US", "https://www.amazon.com/Madonna/e/B000APVKCI"),
                    new ExternalLink("Apple Music US", "https://music.apple.com/us/artist/madonna/20044"),
                    new ExternalLink("Bandsintown", "https://www.bandsintown.com/a/246-madonna"),
                    new ExternalLink("Beatport", "https://www.beatport.com/artist/madonna/628"),
                    new ExternalLink("BnF Catalogue", "https://catalogue.bnf.fr/ark:/12148/cb13897675p"),
                    new ExternalLink("Castalbums", "https://castalbums.org/people/Madonna/39242"),
                    new ExternalLink("Dailymotion", "https://www.dailymotion.com/madonna"),
                    new ExternalLink("Directlyrics", "https://www.directlyrics.com/madonna-artist.html"),
                    new ExternalLink("Discogs", "https://www.discogs.com/artist/18597-Madonna"),
                    new ExternalLink("DNB", "https://d-nb.info/gnd/124541279"),
                    new ExternalLink("Genius", "https://genius.com/artists/Madonna"),
                    new ExternalLink("IBDb", "https://www.imdb.com/name/nm0000187/"),
                    new ExternalLink("IMDb", "https://www.imdb.com/name/nm0000187/"),
                    new ExternalLink("IMVDb", "https://imvdb.com/n/madonna"),
                    new ExternalLink("iTunes JP", "https://music.apple.com/jp/artist/madonna/20044"),
                    new ExternalLink("iTunes US", "https://music.apple.com/us/artist/madonna/20044"),
                    new ExternalLink("Juno Download", "https://www.junodownload.com/artists/Madonna/"),
                    new ExternalLink("Library of Congress", "https://lccn.loc.gov/n92072608"),
                    new ExternalLink("madonna", "https://www.madonna.com/"),
                    new ExternalLink("madonna", "https://twitter.com/madonna"),
                    new ExternalLink("madonna", "https://www.facebook.com/madonna/"),
                    new ExternalLink("madonna", "https://www.instagram.com/madonna/"),
                    new ExternalLink("Madonna", "https://twitter.com/Madonna"),
                    new ExternalLink("MADONNAVEVO", "https://www.youtube.com/user/MadonnaVEVO"),
                    new ExternalLink("maniadb", "https://www.maniadb.com/artist/100102"),
                    new ExternalLink("mora", "https://mora.jp/package/43000004/00602547839508/"),
                    new ExternalLink("MusicMoz", "https://musicmoz.org/Bands_and_Artists/M/Madonna/"),
                    new ExternalLink("Musik-Sammler", "https://www.musik-sammler.de/artist/318"),
                    new ExternalLink("Musixmatch", "https://www.musixmatch.com/artist/Madonna"),
                    new ExternalLink("Muziekweb", "https://www.muziekweb.nl/en/Link/M00000000079"),
                    new ExternalLink("Muzikum", "https://muzikum.eu/en/120-27/madonna/lyrics.html"),
                    new ExternalLink("MVDbase", "https://www.mvdbase.com/person.php?id=A1080"),
                    new ExternalLink("Open Library", "https://openlibrary.org/authors/OL24098A/Madonna"),
                    new ExternalLink("Rate Your Music", "https://rateyourmusic.com/artist/madonna"),
                    new ExternalLink("Rolldabeats", "https://www.rolldabeats.com/artist/madonna"),
                    new ExternalLink("SecondHandSongs", "https://secondhandsongs.com/artist/337"),
                    new ExternalLink("setlist.fm", "https://www.setlist.fm/setlists/madonna-23d6b80b.html"),
                    new ExternalLink("SNAC", "http://snaccooperative.org/ark:/99166/w63v02rs"),
                    new ExternalLink("Songkick", "https://www.songkick.com/artists/390549-madonna"),
                    new ExternalLink("SoundtrackCollector", "https://www.soundtrackcollector.com/catalog/composerdiscography.php?composerid=798"),
                    new ExternalLink("Stream at Deezer", "https://www.deezer.com/us/artist/169"),
                    new ExternalLink("Stream at Spotify", "https://open.spotify.com/artist/6tbjWDEIzxoDsBA1FuhfPW"),
                    new ExternalLink("Stream at Tidal", "https://listen.tidal.com/artist/4780"),
                    new ExternalLink("TikTok", "https://www.tiktok.com/@madonnaofficial"),
                    new ExternalLink("Trove", "https://trove.nla.gov.au/people/560091"),
                    new ExternalLink("US: B000APIQE2", "https://music.amazon.com/artists/B000APIQE2/madonna"),
                    new ExternalLink("VIAF: 59270244", "https://viaf.org/viaf/59270244"),
                    new ExternalLink("Weibo", "https://www.weibo.com/u/5464755723"),
                    new ExternalLink("WhoSampled", "https://www.whosampled.com/Madonna/"),
                    new ExternalLink("Wikidata: Q1744", "https://www.wikidata.org/wiki/Q1744"),
                    new ExternalLink("WorldCat", "https://www.worldcat.org/identities/lccn-n92072608/")
            )
    );

    private List<Integer> generateRatings() { //añadir las puntuaciones del artista1
        List<Integer> ratings = new ArrayList<>();
        for (int i = 0; i < 62; i++) {
            ratings.add(5);
        }
        ratings.addAll(List.of(5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 2, 1)); // Añadir las puntuaciones adicionales respetando un total de 70 elementos
        return ratings;
    }

    private List<Integer> generateRatings2() {  //añadir las puntuaciones del artista2
        List<Integer> ratings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ratings.add(5);
        }
        for (int i = 0; i < 3; i++) {
            ratings.add(4);
        }
        for (int i = 0; i < 5; i++) {
            ratings.add(3);
        }
        ratings.addAll(List.of(2, 1)); // Añadir las puntuaciones adicionales
        return ratings;
    }



    @Test
    public void testArtistDetails() {
        // Establecer las calificaciones para artist1 y artist2
        artist1.setRatings(generateRatings());
        artist2.setRatings(generateRatings2());
        // Verificar las características del primer artista (artist1)
        assertEquals("TheBeatles", artist1.getNombre());
        assertEquals("b10bbbfc-cf9e-42e0-be17-e2c3e1d2600d", artist1.getId());
        assertEquals(generateRatings(), artist1.getRatings());
        assertEquals(
                List.of("Rock", "Pop", "Pop-rock", "Psychedelic pop", "Merseybeat"),
                artist1.getGenres()
        );
        // Verificar otras propiedades del artista 1 según tus requisitos
        assertEquals("Group", artist1.getBiographySummary().type());
        assertNull(artist1.getBiographySummary().gender());
        assertNull(artist1.getBiographySummary().bornDate());
        assertEquals("England,United Kingdom", artist1.getBiographySummary().area());
        // Verificar los enlaces externos del artista 1
        assertEquals(52, artist1.getExternalLinks().size());
        assertEquals(
                "https://m.music.migu.cn/v3/music/artist/11077",
                artist1.getExternalLinks().get(37).getUrl()
        );
        assertEquals("45cat", artist1.getExternalLinks().get(4).getTitle());

        // Verificar el valor promedio de calificación del artista 1
        assertEquals(4.814285714285714, artist1.getAverageRatingValue(),0.01);

        // Verificar las características del segundo artista (artist2)
        assertEquals("Madonna", artist2.getNombre());
        assertEquals("79239441-bfd5-4981-a70c-55c3f15c1287", artist2.getId());
        assertEquals(generateRatings2(), artist2.getRatings());
        assertEquals(
                List.of("Pop", "Dance-pop", "Electropop", "Art-pop", "Electronic"),
                artist2.getGenres()
        );
        // Verificar otras propiedades del artista 2 según tus requisitos
        assertEquals("Person", artist2.getBiographySummary().type());
        assertEquals("Female", artist2.getBiographySummary().gender());
        assertEquals(1958, artist2.getBiographySummary().bornDate());
        assertEquals("Bay City,Michigan,USA", artist2.getBiographySummary().area());
        // Verificar los enlaces externos del artista 2
        assertEquals(57, artist2.getExternalLinks().size());
        assertEquals(
                "https://openlibrary.org/authors/OL24098A/Madonna",
                artist2.getExternalLinks().get(38).getUrl()
        );
        // Verificar el valor promedio de calificación del artista 2
        assertEquals(4.333333333333333, artist2.getAverageRatingValue());
    }

    @Test
    public void testSortingArtistsById() { //comparamos la lista de artistas por orden natural de id con Comparable
        // Agregar artistas a la lista
        artistList.add(artist1);
        artistList.add(artist2);

        // Ordenar la lista de artistas por ID
        Collections.sort(artistList);

        // Verificar si el ordenamiento se realizó correctamente
        assertEquals("79239441-bfd5-4981-a70c-55c3f15c1287", artistList.get(0).getId());
        assertEquals("b10bbbfc-cf9e-42e0-be17-e2c3e1d2600d", artistList.get(1).getId());

    }

    @Test
    public void testSortingArtistsByAverageRating() {
        // Crear una lista de artistas
        List<Artist> artistList = new ArrayList<>();

        // Agregar artistas a la lista
        artistList.add(artist1);
        artistList.add(artist2);

        artist1.setRatings(generateRatings());
        artist2.setRatings(generateRatings2());

        // Ordenar la lista de artistas por puntuación media en orden creciente usando el comparador SortByAverageRating
        Collections.sort(artistList, new SortByAverageRating());

        // Verificar si el ordenamiento se realizó correctamente
        assertEquals(4.333333333333333, artistList.get(0).getAverageRatingValue(), 0.01);
        assertEquals(4.814285714285714, artistList.get(1).getAverageRatingValue(), 0.01);
    }

    @Test
    public void testSortByArtistbyGenres(){
        // Crear una lista de artistas
        List<Artist> artistList = new ArrayList<>();

        // Agregar artistas a la lista
        artistList.add(artist1);
        artistList.add(artist2);

        // Ordenar la lista de artistas por el tamaño de las listas de géneros en orden decreciente usando el comparador SortByGenres
        Collections.sort(artistList, new SortByGenres());

        // Verificar si el ordenamiento se realizó correctamente
        assertEquals(5, artistList.get(0).getGenres().size());
        assertEquals(5, artistList.get(1).getGenres().size());
    }

    @Test
    public void testSortingArtistsByBiographySummary() {
        // Crear una lista de artistas
        List<Artist> artistList = new ArrayList<>();

        // Agregar artistas a la lista
        artistList.add(artist1);
        artistList.add(artist2);

        // Ordenar la lista de artistas por resúmenes biográficos en orden creciente usando el comparador SortByBiographySummary
        Collections.sort(artistList, new SortByBiographySummary());

        // Verificar si el ordenamiento se realizó correctamente, manejando los casos de resúmenes biográficos nulos
        assertEquals("Group",
                artistList.get(0).getBiographySummary() != null && "Group".equals(artistList.get(0).getBiographySummary().type())
                        ? "Group" : null);
        assertEquals("Person",
                artistList.get(1).getBiographySummary() != null && "Person".equals(artistList.get(1).getBiographySummary().type())
                        ? "Person" : null);
    }




    @Test
    public void testSortingArtistsByGenresSize() {
        // Crear una lista de artistas
        List<Artist> artistList = new ArrayList<>();

        // Agregar artistas a la lista
        artistList.add(artist1);
        artistList.add(artist2);

        // Ordenar la lista de artistas por el tamaño de las listas de géneros en orden decreciente usando el comparador SortByGenres
        Collections.sort(artistList, new SortByExternalLink());

        // Verifier si el ordenamiento se realizó correctamente
        assertEquals(57, artistList.get(0).getExternalLinks().size());
        assertEquals(52, artistList.get(1).getExternalLinks().size());
    }


}