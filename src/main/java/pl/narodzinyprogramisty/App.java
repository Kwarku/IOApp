package pl.narodzinyprogramisty;

import java.io.IOException;
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

    public static void main(String[] args) {

        try {
            SimpleExampleReader.simpleReadMethod(SIMPLE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }




        try {
            for (Users user : UsersFromFileReader.getUsersFromFile(USERS_FILE)){
                System.out.println(user.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\nTylko pełnoletnie kobiety\n");

        try {
            for (Users user : UsersFromFileReader.getOnlyWomen(USERS_FILE)) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\nTylko pełnoletni mężczyźni\n");
        try {
            for (Users user : UsersFromFileReader.getOnlyMen(USERS_FILE)) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n\n\n Książki");

        try {
            List<Book> bookList = BookFromFileCSVReader.read(BOOK_CSV_FILE);
            Collections.sort(bookList);
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
            BookToFileCVSWriter.writeSortList(bookList,SORTED_BOOK_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
