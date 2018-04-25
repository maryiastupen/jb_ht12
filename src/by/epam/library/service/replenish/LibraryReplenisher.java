package by.epam.library.service.replenish;

import by.epam.library.entity.Book;
import by.epam.library.entity.Library;
import by.epam.library.service.parse.CsvParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LibraryReplenisher {
    public static void replenishLibraryWithBooks(Library library) {
        final String FILE_NAME = "C:\\Users\\Maryia_Stupen\\IdeaProjects\\HT_10_Improved\\src\\by\\epam\\library\\subsidiary\\books.csv";
        final String CSV_SEPARATOR = ",";
        String line;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            while ((line = bufferedReader.readLine()) != null) {
                Book book = CsvParser.parseBook(line, CSV_SEPARATOR);
                library.add(book);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
