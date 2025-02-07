package View;

import Business.ItemController;
import Business.StudentController;
import Core.Helper;
import Entity.LibraryItem;
import Entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BringBarrowUI extends  JFrame{
    private JPanel conteiner;
    private JLabel lbl_item_barcode;
    private JTextField txt_item_barcode;
    private JTextField txt_student_email;
    private JLabel lbl_student_email;
    private JButton btn_to_barrow;
    private JButton btn_to_take;

    ItemController itemController;
        StudentController studentController;

    public BringBarrowUI() {
        this.add(conteiner);
        //this.setResizable(false);
        this.setTitle("KİTAP ÖDÜNÇ EKRANI");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(500, 400);
        int screenX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().getWidth()) / 2);
        int screenY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().getHeight()) / 2);
        this.setLocation(screenX, screenY);

        itemController=new ItemController();
        studentController=new StudentController();

        btn_to_barrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] checkList={txt_student_email,txt_item_barcode};

                List<Student> studentList =studentController.findStudentEmail(txt_student_email.getText());
                List<LibraryItem> libraryItemList=itemController.findItemByBarcode(txt_item_barcode.getText());

                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }
                else if (studentList==null){
                    Helper.showAutoMessage("Böyle bir kitap yoktur");
                }
                else if (libraryItemList==null){
                    Helper.showAutoMessage("Öğrenci Bulunamadı");
                }
                else if (libraryItemList.get(0).isAvailable()==false) {
                    Helper.showAutoMessage("Bu kitap zaten ödünçte");
                } else {

                    Helper.confirm("sure");{
                        libraryItemList.get(0).setAvailable(false);
                        Helper.showAutoMessage("done");
                    }
                }
            }
        });

        btn_to_take.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] checkList={txt_student_email,txt_item_barcode};

                List<Student> studentList =studentController.findStudentEmail(txt_student_email.getText());
                List<LibraryItem> libraryItemList=itemController.findItemByBarcode(txt_item_barcode.getText());

                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }
                else if (studentList==null){
                    Helper.showAutoMessage("Böyle bir kitap yoktur");
                }
                else if (libraryItemList==null){
                    Helper.showAutoMessage("Öğrenci Bulunamadı");
                }
                else if (libraryItemList.getFirst().isAvailable()==true) {
                    Helper.showAutoMessage("Bu kitap zaten müsait");
                }
                else {
                    Helper.confirm("sure");{
                        libraryItemList.get(0).setAvailable(true);
                        Helper.showAutoMessage("done");
                    }
                }
            }

        });
    }
}
