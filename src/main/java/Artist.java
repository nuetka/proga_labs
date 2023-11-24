import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Artist {
    private String name;
    private List<Album> albums;

    public Artist() {
        name = "";
        albums = new ArrayList<>();
    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = new ArrayList<>(albums);
    }

    public Artist(String name) {
        this.name = name;
        albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return new ArrayList<>(albums);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = new ArrayList<>(albums);
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the artist's name: ");
        name = scanner.nextLine();

        System.out.print("Enter the number of albums: ");

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
    }

    public void printToConsole() {
        System.out.println("Artist: " + name);
        System.out.println("Albums:");
        for (Album album : albums) {
            System.out.println(album.getName());
        }
    }
}