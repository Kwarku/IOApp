package pl.narodzinyprogramisty;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static final String USERS_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/users.txt";
    private static final String SIMPLE_FILE = "/home/qwarq/IdeaProjects/IOApps/src/main/resources/simpleExample.txt";

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
    }
}
