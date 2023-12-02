public class Movie extends MediaItem implements Cloneable {
    private final String director;
    private final int releaseYear;

    public Movie(String title, int duration, String director, int releaseYear) {
        this.name=title;
        this.duration=duration;
        this.director = director;
        this.releaseYear = releaseYear;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + name + " directed by " + director);
    }
}
