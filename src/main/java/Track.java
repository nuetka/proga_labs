import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Track {
    private static int trackCount = 0; // Статическое поле
    private String name;
    private String genre;
    private int duration;

    // При создании нового трека увеличиваем значение статического поля
    public Track() {
        this.name = "";
        this.genre = "";
        this.duration = 0;
        trackCount++;

    }

    public Track(String name) {
        this.name = name;
        this.genre = "";
        this.duration = 0;
        trackCount++;
    }

    public Track(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        trackCount++;
        try {
            if (duration <= 0) {
                throw new IllegalArgumentException("Duration should be a positive integer.");
            }
            this.duration = duration;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid duration: " + e.getMessage());
            this.duration = 0;
        }
    }

    // Статический метод для получения количества треков
    public static int getTrackCount() {
        return trackCount;
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
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public void setGenre(String genre) {
        if(!genre.isEmpty()) {
            this.genre = genre;
        }
    }

    public void setDuration(int duration) {
        try {
            if (duration <= 0) {
                throw new IllegalArgumentException("Duration should be a positive integer.");
            }
            this.duration = duration;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid duration input: " + e.getMessage());
        }
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
        setName(scanner.nextLine());

        System.out.print("Enter track genre: ");
        setGenre(scanner.nextLine());

        System.out.print("Enter track duration (in seconds): ");
        setDuration(Integer.parseInt(scanner.nextLine()));
    }

    public void printToConsole() {
        System.out.println("Track Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " seconds");
    }

}
