package DAO;

import Core.Database;
import Core.ItemBuilder;
import Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
    Connection connection;

    public ItemDAO() {
        this.connection= Database.getInstance();
    }

    public ArrayList<LibraryItem> getAll() {
        ArrayList<LibraryItem> products= new ArrayList<LibraryItem>();
        try {
            ResultSet result=this.connection.createStatement().executeQuery("Select * from library_item");

            while (result.next()){
                products.add(this.match(result));
            }

        }catch (SQLException e){System.out.println(e.getMessage());}

        return products;
    }

    public ArrayList<LibraryItem> findItemByBarcode(String barcode){
        ArrayList<LibraryItem> filtredItem=new ArrayList<>();
        String query = "SELECT * FROM library_item WHERE barcode ILIKE ?";

        try {
            PreparedStatement queryPrepared=this.connection.prepareStatement(query);
            queryPrepared.setString(1, "%" + barcode + "%");
            System.out.println(query);
            ResultSet resault=queryPrepared.executeQuery();

            while (resault.next()){
                filtredItem.add(this.match(resault));
            }

        }catch (SQLException sqlException){System.out.println(sqlException.getMessage());}

        if (filtredItem.size()==0){
            return null;
        }
        return filtredItem;
    }
    public boolean save(LibraryItem item) {

        String query="INSERT INTO library_item " +
                "(" +
                "barcode, " +
                "title, " +
                "author, " +
                "page_number, " +
                "available, " +
                "type " +
                ")" +
                " VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps =this.connection.prepareStatement(query);
            ps.setString(6,item.getType());
            ps.setString(2,item.getTitle());
            if (item instanceof Book){
                ps.setString(1,((Book) item).getBarcode());
                ps.setString(3,((Book) item).getAuthor());
                ps.setInt(4,((Book) item).getPageNumber());
                ps.setBoolean(5,item.isAvailable());
            }
            else if (item instanceof Magazine){
                    ps.setString(1,((Magazine) item).getBarcode());
                    ps.setString(3,((Magazine) item).getPublisher());
                    ps.setInt(4,((Magazine) item).getPageNumber());
                    ps.setBoolean(5,item.isAvailable());
            }
            else if (item instanceof DVD){
                ps.setString(1,((DVD) item).getBarcode());
                ps.setString(3,((DVD) item).getDirector());
                ps.setInt(4,0);
                ps.setBoolean(5,item.isAvailable());

            }


            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public ArrayList<LibraryItem> filterByQuery(String query){
        ArrayList<LibraryItem> productList=new ArrayList<>();
        try {
            System.out.println("ProductDAO query "+query);
            ResultSet rs=this.connection.createStatement().executeQuery(query);
            while (rs.next()) {
                productList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public LibraryItem match(ResultSet result) throws SQLException{

        if (result.getString("type").equals("Kitap")){
            Book book = ItemBuilder.startBuild(result)
                    .setAuthor(result.getString("author"))
                    .setPageNumber(result.getInt("page_number"))
                    .setBarcode(result.getString("barcode"))
                    .buildBook();
            return book;
        }

        else if (result.getString("type").equals("DVD")) {
            DVD dvd =ItemBuilder.startBuild(result)
                    .setDirector(result.getString("author"))
                    .setBarcode(result.getString("barcode"))
                    .buildDVD();

            return dvd;
        }

        else {
            Magazine magazine =ItemBuilder.startBuild(result)
                    .setAuthor(result.getString("author"))
                    .setBarcode(result.getString("barcode"))
                    .setPageNumber(result.getInt("page_number"))
                    .buildMagazine();
            return magazine;
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM library_item WHERE id = ?";
        try {
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public LibraryItem getById(int id) {
        String query="SELECT * FROM library_item WHERE id = ?";
        LibraryItem item=null;
        try{
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                item=this.match(rs);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return item;
    }
}
