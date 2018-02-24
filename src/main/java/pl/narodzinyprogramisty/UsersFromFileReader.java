package pl.narodzinyprogramisty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersFromFileReader {


    private static final int ADULT_AGE = 18;
    private static final String WOMAN_NAME_END_LETTER = "a";
    private static final String REGEX = " ";

    public static List<Users> getUsersFromFile(String filename) throws IOException {
        return getUsers(filename);
    }

    public static List<Users> getOnlyWomen(String filename) throws IOException {
        List<Users> womenUsers = new ArrayList<>();
        List<Users> allUsers = getUsers(filename);
        for (Users users : allUsers) {
            if (isAAdultWomen(users)) {
                womenUsers.add(users);
            }
        }
        return womenUsers;
    }

    public static List<Users> getOnlyMen(String filename) throws IOException {
        List<Users> menUsers = new ArrayList<>();
        List<Users> allUsers = getUsers(filename);
        for (Users user : allUsers) {
            if (isAAdultMen(user)) {
                menUsers.add(user);
            }
        }
        return menUsers;
    }



    private static List<Users> getUsers(String filename) throws IOException {
        List<Users> listUser = new ArrayList<>();

        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String[] line;
        String name;
        String surname;
        int age;
        while (br.readLine() != null) {
            line = br.readLine().split(REGEX);

            name = line[0];
            surname = line[1];
            age = Integer.valueOf(line[2]);

            listUser.add(new Users(name, surname, age));

        }

        br.close();
        return listUser;
    }

    private static boolean isAAdultWomen(Users users) {
        return isAWoman(users) && isAnAdult(users);
    }

    private static boolean isAWoman(Users users) {
        return users.getName().endsWith(WOMAN_NAME_END_LETTER);
    }

    private static boolean isAnAdult(Users users) {
        return users.getAge() > ADULT_AGE;
    }

    private static boolean isAAdultMen(Users users) {
        return !isAWoman(users) && isAnAdult(users);
    }
}
