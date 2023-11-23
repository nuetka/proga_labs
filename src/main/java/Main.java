import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Track[] tracks = new Track[5];
        tracks[0] = new Track("Track 1", "Genre 1", 240);
        tracks[1] = new Track("Track 2", "Genre 2", 250);
        tracks[2] = new Track("Track 3", "Genre 3", 260);
        tracks[3] = new Track("Track 4", "Genre 4", 270);
        tracks[4] = new Track("Track 5", "Genre 5", 280);

        System.out.println("\nКоличество созданных треков(использование статистического метода для получения значения статистической переменной): " + Track.getTrackCount());

        System.out.println("\nTrack array:\n");
        for (Track tr : tracks) {
            tr.printToConsole();
            System.out.println("\n");
        }

        Helper helper = new Helper(new Track("Track 1", "Genre 1", 240));
        int duration = helper.getTrackDuration();

        System.out.println("Возвращение Duration из метода(getTrackDuration()) осуществляется через вспомогательный класс Helper,duration: "+ duration);

        //Примеры обработки строк

        String name = "My Track";
        System.out.println("\nИсходная строка: " + name);

        // Преобразование строки в верхний регистр
        String upperCaseName = name.toUpperCase();

        System.out.println("\nСтрока в верхнем регистре: " + upperCaseName);

        //Проверка наличия подстроки
        boolean containsJava = name.contains("Track");
        System.out.println("\nСодержит 'Track': " + containsJava);

        //использование substring()
        String subString = name.substring(0, 4);
        System.out.println("\nПодстрока: " + subString);

        //Замена символов
        String replaced = name.replace(' ', '!');
        System.out.println("\nЗамененная строка: " + replaced);

        //Использование метода chatAt()
        char firstChar = name.charAt(0);
        System.out.println("\nПервый символ: " + firstChar);

        System.out.println("\nОператор this в сеттерах\nДо:"+tracks[0].getDuration());
        tracks[0].setDuration(-67);
        System.out.println("\nПосле добавления отрицательной продолжительности:"+tracks[0].getDuration());
        tracks[0].setDuration(180);
        System.out.println("\nПосле добавления допустимой продолжительности:"+tracks[0].getDuration());

    }
}
