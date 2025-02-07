package Core;

import Entity.Book;
import Entity.DVD;
import Entity.Magazine;

import java.sql.ResultSet;
import java.sql.SQLException;

//Builder Design Pattern

public class ItemBuilder
{
    int id;
    String barcode;
    String title;
    String author;
    int pageNumber;
    boolean available;
    String type;
    String director;
    String publisher;

    private static ResultSet resultSet;
    public static ItemBuilder startBuild(ResultSet result) throws SQLException {
        resultSet=result;
        ItemBuilder itemBuilder = new ItemBuilder();
        itemBuilder.id=resultSet.getInt("id");
        itemBuilder.title=resultSet.getString("title");
        itemBuilder.available=resultSet.getBoolean("available");
        itemBuilder.type=resultSet.getString("type");
        return itemBuilder;
    }

    public  Book buildBook() throws SQLException {
        Book book=new Book();
        book.setId(resultSet.getInt("id"));
        book.setBarcode(resultSet.getString("barcode"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setPageNumber(resultSet.getInt("page_number"));
        book.setAvailable(resultSet.getBoolean("available"));
        book.setType(resultSet.getString("type"));
        return book;
    }

    public  DVD buildDVD() throws SQLException {
        DVD dvd=new DVD();
        dvd.setId(resultSet.getInt("id"));
        dvd.setTitle(resultSet.getString("title"));
        dvd.setAvailable(resultSet.getBoolean("available"));
        dvd.setBarcode(resultSet.getString("barcode"));
        dvd.setDirector(resultSet.getString("author"));
        dvd.setType(resultSet.getString("type"));
        return dvd;
    }

    public Magazine buildMagazine() throws SQLException {
        Magazine magazine=new Magazine();
        magazine.setId(resultSet.getInt("id"));
        magazine.setTitle(resultSet.getString("title"));
        magazine.setAvailable(resultSet.getBoolean("available"));
        magazine.setBarcode(resultSet.getString("barcode"));
        magazine.setPageNumber(resultSet.getInt("page_number"));
        magazine.setPublisher(resultSet.getString("author"));
        magazine.setType(resultSet.getString("type"));
        return magazine;
    }


    public ItemBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ItemBuilder setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public ItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ItemBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public ItemBuilder setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public ItemBuilder setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public ItemBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ItemBuilder setDirector(String director) {
        this.director = director;
        return this;
    }

    public ItemBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
}
