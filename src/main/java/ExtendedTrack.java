import java.util.Scanner;

public class ExtendedTrack extends Track {
    private String additionalInfo;

    public ExtendedTrack(String name, String genre, int duration, String additionalInfo) {
        super(name, genre, duration);
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter track name: ");
        setName(scanner.nextLine());

        System.out.print("Enter track genre: ");
        setGenre(scanner.nextLine());

        System.out.print("Enter track duration (in seconds): ");
        setDuration(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter info: ");
        setAdditionalInfo(scanner.nextLine());
    }
    @Override
    public void printToConsole() {
        System.out.println("Track Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " seconds");
        System.out.println("Info: " + additionalInfo);
    }
    public void printToConsole(boolean includeBaseInfo) {
        if (includeBaseInfo) {
            super.printToConsole();
        }
        System.out.println("Additional Info: " + additionalInfo);
    }

    @Override
    public String toString() {
        return "Track Name: " + getName() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Duration: " + getDuration() + " seconds\n" +
                "Info: " + additionalInfo;
    }

}
