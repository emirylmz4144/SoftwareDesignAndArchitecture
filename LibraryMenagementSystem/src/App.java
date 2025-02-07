import Business.AdminController;
import Business.StudentController;
import Core.Helper;
import Entity.Admin;
import Entity.Student;
import View.AdminDashboradUI;
import View.LoginUI;
import View.StudentDashboardUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {

    public static void main(String[] args) {

        AdminController adminController=new AdminController();
        StudentController studentController=new StudentController();
        Helper.setTheme();
        Helper.setTextConfiguration();

        LoginUI loginUI=new LoginUI();
    }
}