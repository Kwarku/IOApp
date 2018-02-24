package pl.narodzinyprogramisty;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookToFileCVSWriter {
    public static void writeSortList(List<Book> bookList, String filename) throws IOException {
        FileUtils.writeLines(new File(filename), bookList);
    }
}
