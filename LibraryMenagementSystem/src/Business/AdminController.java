package Business;

import Core.Helper;
import DAO.AdminDAO;
import Entity.Admin;
import Entity.Person;
import Entity.Student;

public class AdminController
{
    public AdminDAO adminDAO;

    public AdminController(){
        adminDAO = new AdminDAO();
    }
    public Admin findByLogin(String email, String password){
        if (!Helper.isEmailValid(email)) return null;
        return this.adminDAO.findByLogin(email,password);
    }

    public boolean save(Student student){
        return adminDAO.save(student);
    }


}
