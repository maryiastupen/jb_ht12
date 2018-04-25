package by.epam.library.service.parse;

import by.epam.library.entity.Book;

public class CsvParser {
    public static Book parseBook (String line, String CSV_SEPARATOR) {
        String[] bookContent = line.split(CSV_SEPARATOR);
        Book book = new Book();
        book.setTitle(bookContent[0]);
        book.setPrice(Double.parseDouble(bookContent[1]));
        book.setYearOfPublishment(Integer.parseInt(bookContent[2]));
        book.setCoverType(bookContent[3]);
        book.setAuthor(bookContent[4]);
        return book;
    }
}
