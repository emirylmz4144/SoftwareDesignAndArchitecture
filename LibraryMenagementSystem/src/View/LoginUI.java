package View;

import Business.AdminController;
import Business.StudentController;
import Core.Helper;
import Entity.Admin;
import Entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginUI extends JFrame {
    private JPanel conteiner;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_info;
    private JPanel pnl_student;
    private JPanel pnl_admin;
    private JLabel lbl_student_info;
    private JLabel lbl_admin_info;
    private JLabel lbl_student_email;
    private JTextField txt_student_email;
    private JLabel lbl_student_password;
    private JButton btn_student_login;
    private JLabel lbl_admin_email;
    private JTextField txt_admin_email;
    private JLabel lbl_admin_password;
    private JButton btn_admin_login;
    private JPasswordField pass_student_password;
    private JPasswordField pass_admin_password;

    private AdminController adminController;
    private StudentController studentController;

    public LoginUI(){
        this.add(conteiner);
        this.setResizable(false);
        this.setTitle("Müşteri yönetim paneli");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(800,400);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);


        this.adminController=new AdminController();
        this.studentController=new StudentController();


        btn_student_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField[] checkList={txt_student_email,pass_student_password};

                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }
                else if (!Helper.isEmailValid(txt_student_email.getText()))
                    Helper.showAutoMessage("Lütfen geçerli bir e-mail giriniz");
                else {
                    System.out.println(txt_student_email.getText());
                    System.out.println(pass_student_password.getText());
                    Student student=studentController.findByLogin(txt_student_email.getText(),pass_student_password.getText());

                    if (student==null){
                        Helper.showAutoMessage("Öğrenci bulunamadı");
                    }
                    else {
                        dispose();
                        StudentDashboardUI studentDashboard=new StudentDashboardUI(student);
                    }
                }
            }
        });




        btn_admin_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] checkList={txt_admin_email,pass_admin_password};

                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }
                else if (!Helper.isEmailValid(txt_admin_email.getText()))
                    Helper.showAutoMessage("Lütfen geçerli bir e-mail giriniz");
                else {
                    System.out.println(txt_admin_email.getText());
                    System.out.println(pass_admin_password.getText());
                    Admin admin=adminController.findByLogin(txt_admin_email.getText(),pass_admin_password.getText());

                    if (admin==null){
                        Helper.showAutoMessage("Admin bulunamadı");
                    }
                    else {
                        dispose();
                        AdminDashboradUI adminDashborad=new AdminDashboradUI(admin);
                    }
                }
            }
        });
    }


}
