import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Library {
    private static Library instance;
    private List<Album> albums;
    private List<Playlist> playlists;

    private Library() {
        albums = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
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
    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        int numAlbums=0;

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter albums count: ");
                numAlbums = scanner.nextInt();
                scanner.nextLine(); // символ новой строки
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // очистка неверного ввода
            }
        }

        for (int i = 0; i < numAlbums; i++) {
            Album album = new Album();
            album.readFromConsole();
            albums.add(album);
        }

        int numPlaylists=0;

        boolean validInput1 = false;
        while (!validInput1) {
            try {
                System.out.print("Enter playlists count: ");
                numPlaylists = scanner.nextInt();
                scanner.nextLine(); // символ новой строки
                validInput1 = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // очистка неверного ввода
            }
        }

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
