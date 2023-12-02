import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Playlist implements ChangeVolume {
    private String name;
    private List<Track> tracks;

    public Playlist() {
        name = "";
        tracks = new ArrayList<Track>();
    }

    public Playlist(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = new ArrayList<Track>(tracks);
    }

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<Track>();
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return new ArrayList<Track>(tracks);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = new ArrayList<Track>(tracks);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя плейлиста: ");
        String name1 = scanner.nextLine();
        setName(name1);

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
            scanner.nextLine(); // Consume the newline character

            Track track = new Track(trackName, genre, duration);
            tracks.add(track);
        }

        setTracks(tracks);
    }

    public void printToConsole() {
        System.out.print("   Playlist: " + name);
        System.out.print("/Tracks:");
        for (Track track : tracks) {
            System.out.print(track.getName());
        }
    }

    @Override
    public void volumeUp() {
        System.out.println("Уаеличена громакость у плейлиста " + name );
    }
}

