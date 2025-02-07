package View;

import Business.StudentController;
import Core.Helper;
import Core.Item;
import Entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StudentDeleteUI extends JFrame {
    private JPanel conteiner;
    private JScrollPane scrll_student;
    private JTable tbl_student;
    private JPanel pnl_search_student;
    private JLabel lbl_search_student;
    private JButton btn_search;
    private JTextField txt_student_search;

    private DefaultTableModel tmbl_student;
    private StudentController studentController;

    private JPopupMenu popup_student_delete;

    public StudentDeleteUI() {
        this.add(conteiner);
        //this.setResizable(false);
        this.setTitle("ÖĞRENCİ SİLME EKRANI");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(800, 600);
        int screenX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().getWidth()) / 2);
        int screenY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().getHeight()) / 2);
        this.setLocation(screenX, screenY);


        this.tbl_student.setRowHeight(30);

        this.studentController = new StudentController();

        this.popup_student_delete = new JPopupMenu();
        this.tmbl_student = new DefaultTableModel();



        loadStudentPopUpMenu();
        loadStudent(null);

        btn_search.addActionListener(e -> {
            ArrayList<Student> filtredList = this.studentController.findStudentByName(txt_student_search.getText());
            loadStudent(filtredList);
        });


    }

    private void loadStudentPopUpMenu() {
        this.tbl_student.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_student.rowAtPoint(e.getPoint());
                if (selectedRow != -1) {
                    tbl_student.setRowSelectionInterval(selectedRow, selectedRow);
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popup_student_delete.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

        this.popup_student_delete.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int id = Integer.parseInt(tbl_student.getValueAt(tbl_student.getSelectedRow(), 0).toString());
                if (studentController.delete(id)) {
                    Helper.showAutoMessage("done");
                    loadStudent(null);
                } else {
                    Helper.showAutoMessage("error");
                }
            }
        });
    }
    private void loadStudent(ArrayList<Student> students) {
        Object[] titleOfTable = {"ID", "ÖĞRENCİNİN ADI", "ÖĞRENCİNİN E-MAİLİ", "ÖĞRENCİNİN ŞİFRESİ"};
        this.tmbl_student.setColumnIdentifiers(titleOfTable);
        if (students == null) {
            students = this.studentController.getAll();
        }

        students.sort(((o1, o2) -> o1.getId() > o2.getId() ? 1 : -1));


        //Sıfırlama
        DefaultTableModel clearModel = (DefaultTableModel) tbl_student.getModel();
        clearModel.setRowCount(0);


        for (Student student : students) {
            Object[] rowObject = {
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    "********"
            };

            this.tmbl_student.addRow(rowObject);


        }
        this.tbl_student.setModel(tmbl_student);
        this.tbl_student.getTableHeader().setReorderingAllowed(false);
        this.tbl_student.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_student.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tbl_student.setEnabled(false);




    }



}
