package Business;

import Core.Helper;
import DAO.StudentDAO;
import Entity.LibraryItem;
import Entity.Person;
import Entity.Student;

import java.util.ArrayList;

public class StudentController {
    public StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentDAO();
    }

    public Student findByLogin(String email, String password){
        if (!Helper.isEmailValid(email)) return null;
        return this.studentDAO.findByLogin(email,password);
    }


    public ArrayList<Student> findStudentByName(String name){
        return studentDAO.findStudentByName(name);
    }
    public ArrayList<Student> findStudentEmail(String email){
        return studentDAO.findStudentByEmail(email);
    }
    public ArrayList<Student> getAll(){
        return this.studentDAO.getAll();
    }

    public boolean delete(int id){
        if (this.getById(id)==null){
            Helper.showAutoMessage(id+ "Kişi bulunamadı");
            return false;
        }
        return this.studentDAO.delete(id);
    }

    public Student getById(int id){
        return this.studentDAO.getById(id);
    }
}
