package pl.narodzinyprogramisty;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    private static final String USERS_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/users.txt";
    private static final String SIMPLE_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/simpleExample.txt";
    private static final String BOOK_CSV_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/books.csv";
    private static final String SORTED_BOOK_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/sortedBooks.csv";
    private static final String WEATHER_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/weather-data.csv";

    public static void main(String[] args) {


        try {
            System.out.println("\nSimple file");
            SimpleExampleReader.simpleReadMethod(SIMPLE_FILE);

            System.out.println("\nAll users\n");
            for (Users user : UsersFromFileReader.getUsersFromFile(USERS_FILE)) {
                System.out.println(user.toString());
            }


            System.out.println("\nTylko pełnoletnie kobiety\n");
            for (Users user : UsersFromFileReader.getOnlyWomen(USERS_FILE)) {
                System.out.println(user);
            }


            System.out.println("\nTylko pełnoletni mężczyźni\n");
            for (Users user : UsersFromFileReader.getOnlyMen(USERS_FILE)) {
                System.out.println(user);
            }

            System.out.println("\n\n\n Książki");
            List<Book> bookList = BookFromFileCSVReader.read(BOOK_CSV_FILE);
            Collections.sort(bookList);
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
            BookToFileCVSWriter.writeSortList(bookList, SORTED_BOOK_FILE);



            LocalDate firstData = LocalDate.of(2012, 12, 25);
            LocalDate lastData = LocalDate.of(2015, 1, 25);
            WeatherReader wr = new WeatherReader();
            System.out.println("Pogoda w dniu " + firstData.toString() + " to: " + wr.takeThisDayWeather(WEATHER_FILE, firstData));

            System.out.println("\n\nekstymalne wartości pogody miedzy " + firstData.toString() +
                    " a " + lastData.toString() + " to " + wr.extremeTempBetween(firstData, lastData, WEATHER_FILE));


            int average = 15;
            System.out.printf("Ilość dni cieplejszych niż %d stopni to %d",average,wr.numberOfWarmerDays(average,WEATHER_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
