import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Track track1 = new Track("Track1", "Genre1", 180);
        Track track2 = new Track("Track2", "Genre2", 190);
        Track track3 = new Track("Track3", "Genre3", 280);

        Track track4 = new Track();

        System.out.println("Entering track information from the console\n");
        track4.readFromConsole();

        Track track5 = new Track("Track5");

        List<Track> tracks = new ArrayList<>();

        // Добавляем в список уже созданные треки
        tracks.add(track1);
        tracks.add(track2);

        // Добавляем трек, который был считан с консоли
        tracks.add(track4);

        // Добавляем трек, созданный с помощью конструктора с одним аргументом
        tracks.add(track5);

        System.out.println("\nTrack array\n");
        for (Track tr : tracks) {
            tr.printToConsole();
            System.out.println("\n");
        }

        List<Track> tracksWithGenre2 = Track.findTracksByGenre(tracks, "Genre2");
        System.out.println("All tracks with genre 2\n");
        for (Track track : tracksWithGenre2) {
            track.printToConsole();
            System.out.println("\n");
        }

        System.out.println("Input album-info from console\n");
        Album album2 = new Album();
        album2.readFromConsole();
        System.out.println("Album filled in from the console\n");
        album2.printToConsole();

        Album album1 = new Album("Album1", 2022, "Artist1",tracks);
        System.out.println("\nAlbum1\n");
        album1.printToConsole();

        System.out.println("Adding Track3 and removing Track2 from the first album\n");
        album1.addTrack(track3);
        album1.removeTrack("Track2");
        album1.printToConsole();

        System.out.println("\nAlbum with 2022 release year \n");

        List<Album> albums = new ArrayList<>();

        albums.add(album1);
        albums.add(album2);

        List<Album> albums2022 = Album.findAlbumsByYear(albums,2022);
        for (Album a : albums2022) {
            a.printToConsole();
            System.out.println("\n");
        }

        Playlist playlist = new Playlist("Playlist1",tracks);
        Playlist playlist1 = new Playlist();
        System.out.println("\nInput playlist info from console \n");
        playlist1.readFromConsole();
        System.out.println("\nPlaylist filled in from the console \n");
        playlist1.printToConsole();

        List<Playlist> playlists = new ArrayList<>();
        playlists.add(playlist);
        playlists.add(playlist1);

        Library library = new Library(albums, playlists);
        System.out.println("\nLibrary \n");
        library.printToConsole();

        System.out.println("\nAfter adding the album to the library \n");
        Album albumNew = new Album("AlbumNew", 3333, "Artist666",tracks);
        library.addAlbum(albumNew);
        library.printToConsole();

    }
}
