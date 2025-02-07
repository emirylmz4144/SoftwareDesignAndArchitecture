package View;

import Business.AdminController;
import Core.Helper;
import Entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StudentCreateUI extends JFrame{
    private JPanel conteiner;
    private JLabel lbl_student_name;
    private JTextField txt_addstudent_name;
    private JTextField txt_addstudent_email;
    private JButton btn_save;
    private JLabel lbl_student_email;
    private JLabel lbl_student_password;
    private JPasswordField pass_student_password;

    private Student student;
    private AdminController adminController;

    public StudentCreateUI() {
        this.add(conteiner);
        //this.setResizable(false);
        this.setTitle("ÖĞRENCİ EKLEME EKRANI");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(400,400);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);


        this.student=new Student();
        this.adminController=new AdminController();

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField [] checkList={txt_addstudent_name,txt_addstudent_email,pass_student_password};
                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }
                else if (!Helper.isEmailValid(txt_addstudent_email.getText())){
                    Helper.showAutoMessage("Lütfen geçerli değer giriniz");
                }
                else {
                    boolean result=false;
                    student.setName(txt_addstudent_name.getText());
                    student.setEmail(txt_addstudent_email.getText());
                    student.setPassword(pass_student_password.getText());

                    if (student.getId()==0)
                        result= adminController.save(student);


                    if (result){
                        Helper.showAutoMessage("done");
                        dispose();
                    }
                    else {
                        Helper.showAutoMessage("error");
                    }
                }
            }
        });
    }
}
