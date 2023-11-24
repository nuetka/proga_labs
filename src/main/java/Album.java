import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Album {
    private String name;
    private int year;
    private String artist;
    private List<Track> tracks;

    public Album() {
        name = "";
        year = 0;
        artist = "";
        tracks = new ArrayList<>();
    }

    public Album(String name, int year, String artist, List<Track> tracks) {
        this.name = name;
        this.artist = artist;
        try {
            if (year < 0) {
                throw new IllegalArgumentException("Year should be a non-negative integer.");
            }
            this.year = year;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid year: " + e.getMessage());
            this.year = 0;
        }
        this.tracks = new ArrayList<>(tracks);
    }

    public Album(String name) {
        this.name = name;
        year = 0;
        artist = "";
        tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        try {
            if (year < 0) {
                throw new IllegalArgumentException("Year should be a non-negative integer.");
            }
            this.year = year;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid year input: " + e.getMessage());
        }
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = new ArrayList<>(tracks);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter album name: ");
        String name = scanner.nextLine();
        setName(name);

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        setYear(year);
        scanner.nextLine();

        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();
        setArtist(artist);


        int trackCount=0;

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter track count: ");
                trackCount = scanner.nextInt();
                scanner.nextLine(); // символ новой строки
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // очистка неверного ввода
            }
        }

        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < trackCount; i++) {
            System.out.println("Track num " + (i + 1) + ":");
            System.out.print("  Name: ");
            String trackName = scanner.nextLine();
            System.out.print("  Genre: ");
            String genre = scanner.nextLine();
            System.out.print("  Duration: ");
            int duration = scanner.nextInt();
            scanner.nextLine();

            Track track = new Track(trackName, genre, duration);
            tracks.add(track);
        }

        setTracks(tracks);
    }

    public void printToConsole() {
        System.out.println("Album: " + name);
        System.out.println("Year: " + year);
        System.out.println("Artist: " + artist);
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println(track.getName());
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void removeTrack(String trackName) {
        tracks.removeIf(track -> track.getName().equals(trackName));
    }

    public static List<Album> findAlbumsByYear(List<Album> albums, int year) {
        List<Album> result = new ArrayList<>();
        for (Album album : albums) {
            if (album.getYear() == year) {
                result.add(album);
            }
        }
        return result;
    }
}