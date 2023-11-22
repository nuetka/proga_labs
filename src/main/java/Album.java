import java.util.ArrayList;
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
        this.year = year;
        this.artist = artist;
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
        this.year = year;
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

        System.out.print("Enter track count: ");
        int trackCount = scanner.nextInt();
        scanner.nextLine();

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