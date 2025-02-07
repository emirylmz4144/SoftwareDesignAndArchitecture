package DAO;

import Core.Database;
import Entity.Admin;
import Entity.Person;
import Entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO implements PersonDAO{
    Connection connection;

    public AdminDAO() {
        this.connection= Database.getInstance();
    }

    @Override
    public Admin findByLogin(String email, String password){
        Admin admin=null;
        String query="Select * from admin where email=? AND password=?";
        try {
            PreparedStatement queryPrepared=this.connection.prepareStatement(query);
            queryPrepared.setString(1, email);
            queryPrepared.setString(2, password);
            ResultSet resault=queryPrepared.executeQuery();

            while (resault.next()){
                admin=this.match(resault);
            }

        }catch (SQLException sqlException){System.out.println(sqlException.getMessage());}

        return admin;
    }

    public boolean save(Student student) {
        String query = "INSERT INTO student " +
                "(" +
                "name," +
                " email, " +
                "password" +
                ") " +
                "VALUES (?, ?, ?)";  // Sütunlar arasına virgül eklenmiş

        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, student.getName()+" "+student.getEmail());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    @Override
    public Admin match(ResultSet result) throws SQLException{
        Admin admin=new Admin();
        admin.setId(result.getInt("id"));
        admin.setName(result.getString("name"));
        admin.setEmail(result.getString("email"));
        admin.setPassword(result.getString("password"));
        return admin;
    }
}
