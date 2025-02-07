package View;

import Business.ItemController;
import Entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentDashboardUI extends JFrame{

    private JPanel conteiner;
    private JPanel pnl_top_left;
    private JPanel pnl_top_right;
    private JPanel pnl_bottom_left;
    private JPanel pnl_bottom_right;
    private JLabel lbl_icon;
    private JLabel lbl_info;
    private JLabel lbl_search;
    private JTextField txt_search;
    private JComboBox cmbx_item_type;
    private JButton btn_search;
    private JButton btn_my_items;
    private JButton btn_my_fines;
    private JLabel lbl_search_information;
    private JScrollPane scrll_items;
    private JTable tbl_items;
    private JTextField txt_product_barcode;
    private JLabel lbl_product_name;
    private JTextField txt_product_name;
    private JLabel lbl_product_author;
    private JTextField txt_product_author;
    private JLabel lbl_product_page_number;
    private JTextField txt_product_page_nmber;
    private JLabel lbl_product_available;
    private JComboBox cmbx_product_available;
    private JLabel lbl_product_type;
    private JComboBox cmbx_product_type;
    private JButton btn_log_out;
    private JLabel lbl_product_barcode;


    ItemController itemController;

    private DefaultTableModel tmbl_items;

    public StudentDashboardUI(Student student) {
        this.add(conteiner);
        //this.setResizable(false);
        this.setTitle("ÖĞRENCİ EKLEME EKRANI");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(1400,750);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);


        this.itemController=new ItemController();
        this.tmbl_items=new DefaultTableModel();
        this.tbl_items.setRowHeight(30);

        this.cmbx_product_available.setModel(new DefaultComboBoxModel<>(LibraryItem.Availability.values()));
        this.cmbx_product_available.setSelectedItem(null);

        this.cmbx_item_type.setModel(new DefaultComboBoxModel<>(LibraryItem.Type.values()));
        this.cmbx_item_type.setSelectedItem(null);

        this.cmbx_product_type.setModel(new DefaultComboBoxModel<>(LibraryItem.Type.values()));
        this.cmbx_product_type.setSelectedItem(null);


        ImageIcon imageIcon=new ImageIcon("Images/icons8-book-96.png");
        lbl_icon.setIcon(imageIcon);


        loadItems(null);

        btn_log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginUI loginUI=new LoginUI();
            }
        });
    }


    private void loadItems(ArrayList<LibraryItem> items) {
        Object [] titleOfTable={"ID","BARKOD NO","ÜRÜN ADI","ÜRÜN YAZARI","SAYFA SAYISI","DURUM","KATEGORİ"};
        this.tmbl_items.setColumnIdentifiers(titleOfTable);
        if (items==null){
            items=this.itemController.getAll();
        }

        items.sort(((o1, o2) -> o1.getID()>o2.getID()?1:-1));


        //Sıfırlama
        DefaultTableModel clearModel=(DefaultTableModel) tbl_items.getModel();
        clearModel.setRowCount(0);


        for (LibraryItem item:items){

            String availability;
            if (item.isAvailable())
                availability="MÜSAİT";
            else
                availability="ÖDÜNÇTE";

            if (item.getType().equals("Kitap")){
                Object [] rowObject={
                        item.getID(),
                        ((Book) item).getBarcode(),
                        item.getTitle(),
                        ((Book) item).getAuthor(),
                        ((Book) item).getPageNumber(),
                        availability,
                        item.getType(),
                };
                this.tmbl_items.addRow(rowObject);
            }
            else if (item.getType().equals("DVD")){
                Object [] rowObject={
                        item.getID(),
                        ((DVD) item).getBarcode(),
                        item.getTitle(),
                        ((DVD) item).getDirector(),
                        "--",
                        availability,
                        item.getType(),
                };
                this.tmbl_items.addRow(rowObject);
            }

            else if (item.getType().equals("Magazin")){
                Object [] rowObject={
                        item.getID(),
                        ((Magazine) item).getBarcode(),
                        ((Magazine) item).getTitle(),
                        ((Magazine) item).getPublisher(),
                        ((Magazine) item).getPageNumber(),
                        availability,
                        ((Magazine) item).getType()
                };
                this.tmbl_items.addRow(rowObject);
            }
        }
        this.tbl_items.setModel(tmbl_items);
        this.tbl_items.getTableHeader().setReorderingAllowed(false);
        this.tbl_items.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_items.setEnabled(false);


    }
}
