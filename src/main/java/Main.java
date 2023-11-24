public class Main {
    public static void main(String[] args) {
        System.out.println("Обработка исключения при инициализации объекта:");

        Track track1 = new Track("Song1", "Pop", -3); // отрицательная продолжительность

        System.out.println("После ввода отрицательной продолжительности она устанавливается в 0:");

        track1.printToConsole();

        System.out.println("Обработка исключения при использовании сеттера:");
        Album album = new Album();

        album.setYear(-2022);

        Track[] trackArray = new Track[2];
        Playlist[][] playlistArray = new Playlist[2][2];

        System.out.println("\nодномерный массив треков:\n");
        for (int i = 0; i < trackArray.length; i++) {
            trackArray[i] = new Track();
            trackArray[i].readFromConsole();
        }

        System.out.println("\nСозданный одномерный массив треков:\n");
        for (Track track : trackArray) {
            track.printToConsole();
        }

        System.out.println("\nдвумерный массив плейлистов\n");
        for (int i = 0; i < playlistArray.length; i++) {
            for (int j = 0; j < playlistArray[i].length; j++) {
                playlistArray[i][j] = new Playlist();
                playlistArray[i][j].readFromConsole();
            }
        }
        System.out.println("\nСозданный двумерный массив плейлистов:\n");
        for (int i = 0; i < playlistArray[0].length; i++) {
            for (int j = 0; j < playlistArray.length; j++) {
                playlistArray[i][j].printToConsole();
            }
            System.out.println();
        }
    }


}
