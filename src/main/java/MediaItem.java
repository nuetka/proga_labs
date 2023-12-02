public abstract class MediaItem {
    protected String name;
    protected int duration;

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public abstract void play();
}
