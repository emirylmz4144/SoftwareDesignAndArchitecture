package DAO;

import Core.Database;
import Entity.Admin;
import Entity.LibraryItem;
import Entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO implements PersonDAO{

    Connection connection;

    public StudentDAO() {
        this.connection= Database.getInstance();
    }


    public ArrayList<Student> getAll() {
        ArrayList<Student> students= new ArrayList<Student>();
        try {
            ResultSet result=this.connection.createStatement().executeQuery("Select * from student");

            while (result.next()){
                students.add(this.match(result));
            }

        }catch (SQLException e){System.out.println(e.getMessage());}

        return students;
    }

    @Override
    public Student findByLogin(String email, String password){
        Student student=null;
        String query="Select * from student where email=? AND password=?";
        try {
            PreparedStatement queryPrepared=this.connection.prepareStatement(query);
            queryPrepared.setString(1, email);
            queryPrepared.setString(2, password);
            ResultSet resault=queryPrepared.executeQuery();

            while (resault.next()){
                student=this.match(resault);
            }

        }catch (SQLException sqlException){System.out.println(sqlException.getMessage());}

        return student;
    }

    public ArrayList<Student> findStudentByName(String name){
        ArrayList<Student> filtredStudent=new ArrayList<>();
        String query = "SELECT * FROM student WHERE name ILIKE ?";

        try {
            PreparedStatement queryPrepared=this.connection.prepareStatement(query);
            queryPrepared.setString(1, "%" + name + "%");
            System.out.println(query);
            ResultSet resault=queryPrepared.executeQuery();

            while (resault.next()){
                filtredStudent.add(this.match(resault));
            }

        }catch (SQLException sqlException){System.out.println(sqlException.getMessage());}

        return filtredStudent;
    }

    public ArrayList<Student> findStudentByEmail(String email){
        ArrayList<Student> filtredStudent=new ArrayList<>();
        String query = "SELECT * FROM student WHERE email ILIKE ?";

        try {
            PreparedStatement queryPrepared=this.connection.prepareStatement(query);
            queryPrepared.setString(1, "%" + email + "%");
            System.out.println(query);
            ResultSet resault=queryPrepared.executeQuery();

            while (resault.next()){
                filtredStudent.add(this.match(resault));
            }

        }catch (SQLException sqlException){System.out.println(sqlException.getMessage());}
        if(filtredStudent.size()==0){
            return null;
        }
        return filtredStudent;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM student WHERE id = ?";
        try {
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public Student getById(int id) {
        String query="SELECT * FROM student WHERE id = ?";
        Student student=null;
        try{
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                student=this.match(rs);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return student;
    }
    @Override
    public Student match(ResultSet result) throws SQLException{
        Student student=new Student();
        student.setId(result.getInt("id"));
        student.setName(result.getString("name"));
        student.setEmail(result.getString("email"));
        student.setPassword(result.getString("password"));
        return student;
    }
}
