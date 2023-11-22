import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    private List<Album> albums;
    private List<Playlist> playlists;

    public Library() {
        albums = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public Library(List<Album> albums, List<Playlist> playlists) {
        this.albums = albums;
        this.playlists = playlists;
    }

    public Library(List<Album> albums) {
        this.albums = albums;
        playlists = new ArrayList<>();
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of albums: ");
        int numAlbums = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numAlbums; i++) {
            Album album = new Album();
            album.readFromConsole();
            albums.add(album);
        }

        System.out.print("Enter the number of playlists: ");
        int numPlaylists = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlaylists; i++) {
            Playlist playlist = new Playlist();
            playlist.readFromConsole();
            playlists.add(playlist);
        }
    }

    public void printToConsole() {
        System.out.println("Albums:");
        for (Album album : albums) {
            System.out.println(album.getName());
        }

        System.out.println("Playlists:");
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getName());
        }
    }


}
