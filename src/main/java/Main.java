import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("Производный класс:");

        ExtendedTrack ext_track = new ExtendedTrack("Song1", "Pop", 3, "Эта песня посвящена Кире"); // отрицательная продолжительность

        ext_track.printToConsole();
        System.out.println("-------------includeBaseInfo=true--------------");
        ext_track.printToConsole(true);
        System.out.println("---------includeBaseInfo=false---------------");
        ext_track.printToConsole(false);

        System.out.println("\nИспользование переопределённого метода toString");
        String trackInfo = ext_track.toString();
        System.out.println(trackInfo);

        System.out.println("\nИспользование интерфйеса ChangeVolumne");
        ext_track.volumeUp();
        Playlist playlist = new Playlist("PlaylistName");
        playlist.volumeUp();

        System.out.println("\nИспользование абстракотного класса MediaItem");
        ext_track.play();
        Movie movie = new Movie("MovieName", 1000, "АюАю", 3033);
        movie.play();


        Movie originalMovie = new Movie("Title", 3000, "John", 2022);

        Movie clonedMovie = (Movie) originalMovie.clone();

        System.out.println("\nМелкое клонирование");
        System.out.println("OriginalMovie: " + "Title:" + originalMovie.getName() + ";Duration:" + originalMovie.getDuration() + ";Director" + originalMovie.getDirector() + ";Release" + originalMovie.getReleaseYear());
        System.out.println("ClonedMovie: " + "Title:" + clonedMovie.getName() + ";Duration:" + clonedMovie.getDuration() + ";Director" + clonedMovie.getDirector() + ";Release" + clonedMovie.getReleaseYear());


        Track track1 = new Track("Song1", "Pop1", 3);
        Track track2 = new Track("Song2", "Pop2", 4);
        List<Track> someTracks = new ArrayList<>(Arrays.asList(track1, track2));

        System.out.println("\nГлубокое клонирование");
        Album originalAlbum = new Album("Name", 2022, "Artist", someTracks);
        Album clonedAlbum = (Album) originalAlbum.clone();
        System.out.println("\nOriginalAlbum");
        originalAlbum.printToConsole();

        System.out.println("\nClonedAlbum");
        clonedAlbum.printToConsole();


        System.out.println("\nиспользование шаблона \"Singleton\"");
        // Получаем единственный экземпляр библиотеки
        Library library = Library.getInstance();

        // Добавляем альбомы и плейлисты
        Album album1 = new Album("Album 1", 2022, "Artist 1", new ArrayList<>());
        Album album2 = new Album("Album 2", 2022, "Artist 2", new ArrayList<>());

        library.addAlbum(album1);
        library.addAlbum(album2);

        Playlist playlist1 = new Playlist("Playlist 1", new ArrayList<>());
        Playlist playlist2 = new Playlist("Playlist 2", new ArrayList<>());

        library.addPlaylist(playlist1);
        library.addPlaylist(playlist2);

        // Используем библиотеку
        List<Album> albums = library.getAlbums();
        List<Playlist> playlists = library.getPlaylists();

        for (Album album : albums) {
            System.out.println("Album: " + album.getName());
        }

        for (Playlist pl : playlists) {
            System.out.println("Playlist: " + pl.getName());
        }
    }

}
