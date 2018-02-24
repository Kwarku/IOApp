package pl.narodzinyprogramisty;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookFromFileCSVReader {


    public static List<Book> read(String filename) throws IOException {
        List<Book> bookList = new ArrayList<>();
         File file = new File(filename);
        LineIterator lineIterator = FileUtils.lineIterator(file, "UTF-8");

        String[] line;

        String id;
        String name;
        double price;
        boolean inStock;
        String author;
        lineIterator.next();
        while (lineIterator.hasNext()) {
            line = lineIterator.nextLine().split(",");
            id = line[0];
            name = line[2];
            price = Double.valueOf(line[3]);
            inStock = Boolean.valueOf(line[4]);
            author = line[5];
            bookList.add(new Book(id, "", name, price, inStock, author, "", "", ""));

        }

        return bookList;
    }
}
