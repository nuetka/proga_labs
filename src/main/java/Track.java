import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Track {
    private String name;
    private String genre;
    private int duration;

    public Track() {
        this.name = "";
        this.genre = "";
        this.duration = 0;

    }

    public Track(String name) {
        this.name = name;
        this.genre = "";
        this.duration = 0;
    }

    public Track(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static List<Track> findTracksByGenre(List<Track> tracks, String genre) {
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getGenre().equals(genre)) {
                result.add(track);
            }
        }
        return result;
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter track name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter track genre: ");
        this.genre = scanner.nextLine();

        System.out.print("Enter track duration (in seconds): ");
        this.duration = scanner.nextInt();
    }

    public void printToConsole() {
        System.out.println("Track Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " seconds");
    }

}
