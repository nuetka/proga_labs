import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Track tr = new Track("DS", "Rock", 202);
        ExtendedTrack etr = new ExtendedTrack("EDS", "KPOP", 300,  "Jgz");
        Track tr1 = new Track("Mill", "Bambam", 20);
        ExtendedTrack etr1 = new ExtendedTrack("Akka", "Wow", 303, "jjj");

        List<Track> tracks = new ArrayList<>();
        tracks.add(tr);
        tracks.add(etr);
        tracks.add(tr1);
        tracks.add(etr1);

        System.out.println("Сортировка треков по названию:");
        tracks.sort((a, b) -> a.getName().compareTo(b.getName()));
        printTracksToConsole(tracks);

        System.out.println("\nСортировка треков по продолжительности:");
        tracks.sort((a, b) -> Integer.compare(a.getDuration(), b.getDuration()));
        printTracksToConsole(tracks);

        System.out.println("\nПоиск треков по жанру Rock:");
        String genreToSearch = "Rock";
        List<Track> foundTracks = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getGenre().equals(genreToSearch)) {
                foundTracks.add(track);
            }
        }
        printTracksToConsole(foundTracks);
    }

    private static void printTracksToConsole(List<Track> tracks) {
        for (Track track : tracks) {
            track.printToConsole();
        }
    }

}
