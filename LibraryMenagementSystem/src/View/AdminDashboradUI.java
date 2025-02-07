package View;

import Business.ItemController;
import Core.*;
import Entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class AdminDashboradUI extends JFrame {

    private JPanel conteiner;
    private JPanel pnl_top_left;
    private JPanel pnl_top_right;
    private JPanel pnl_bottom_left;
    private JPanel pnl_bottom_right;
    private JLabel lbl_icon;
    private JLabel lbl_barrcode;
    private JTextField txt_search;
    private JLabel lbl_information;
    private JButton btn_add_student;
    private JButton btn_delete_student;
    private JLabel lbl_admin_info;
    private JScrollPane scrl_items;
    private JTable tbl_items;
    private JButton btn_search;
    private JComboBox<Item> cmbx_item_type;
    private JTextField txt_product_barcode;
    private JTextField txt_product_name;
    private JTextField txt_product_author;
    private JTextField txt_product_page_nmber;
    private JComboBox cmbx_product_available;
    private JComboBox cmbx_product_type;
    private JButton btn_product_add;
    private JButton btn_product_delete;
    private JLabel lbl_product_barcode;
    private JLabel lbl_product_name;
    private JLabel lbl_product_author;
    private JLabel lbl_product_page_number;
    private JLabel lbl_product_available;
    private JLabel lbl_product_type;
    private JButton btn_to_barrow_and_take;
    private JButton btn_log_out;
    private JPanel pnl_button_of_actions_product;


    private  ItemController itemController;

    private DefaultTableModel tmbl_items;
    private SearchContext searchContext;

    public AdminDashboradUI(Admin admin) {


        this.add(conteiner);
        //this.setResizable(false);
        this.setTitle("ADMİN EKRANI");
        this.setVisible(true); //UI'ın görünebilmesi için
        this.setSize(1400,750);
        int screenX=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getSize().getWidth())/2);
        int screenY=(int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getSize().getHeight())/2);
        this.setLocation(screenX, screenY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.cmbx_item_type.addItem(new Item(1,"Kitap"));
        this.cmbx_item_type.addItem(new Item(2,"DVD"));
        this.cmbx_item_type.addItem(new Item(3,"Magazin"));
        this.cmbx_item_type.setSelectedItem(null);


        this.tmbl_items=new DefaultTableModel();
        this.itemController=new ItemController();
        this.tbl_items.setRowHeight(30);


        this.cmbx_item_type.setSelectedItem(null);

        this.cmbx_product_available.setModel(new DefaultComboBoxModel<>(LibraryItem.Availability.values()));
        this.cmbx_product_available.setSelectedItem(null);

        this.cmbx_product_type.setModel(new DefaultComboBoxModel<>(LibraryItem.Type.values()));
        this.searchContext=new SearchContext();
        this.cmbx_product_type.setSelectedItem(null);



        ImageIcon imageIcon=new ImageIcon("Images/icons8-user-96.png");
        lbl_icon.setIcon(imageIcon);

        loadItems(null);
        loadCustomerPopUpMenu();


        btn_log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")){
                    dispose();
                    LoginUI loginUI=new LoginUI();
                }
            }
        });

        btn_search.addActionListener(e ->{



            String selectedItem = cmbx_item_type.getSelectedItem().toString();
            System.out.println(selectedItem);

            // Şu an isme göre arama yapıyoruz
            searchContext.setStrategy(new TypeStrategy());

        //     Arama yapılır ve sonuçlar tabloya yüklenir
        //    ArrayList<LibraryItem> filteredItems = searchContext.executeStrategy(txt_search.getText(),selectedItem);
        //    loadItems(filteredItems); // Arama sonuçlarına göre tabloları yükle
        //
        //    for (LibraryItem item : filteredItems) {
        //        System.out.println(item.getType());
        //    }

                ArrayList<LibraryItem> filtredList=this.itemController.filter(
                        txt_search.getText(),
                        (Item) cmbx_item_type.getSelectedItem()
                );
        loadItems(filtredList);


        });


        btn_add_student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentCreateUI studentCreateUI=new StudentCreateUI();
            }
        });


        btn_delete_student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentDeleteUI studentDeleteUI=new StudentDeleteUI();
            }
        });

        btn_product_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")){
                    int id=Integer.parseInt(tbl_items.getValueAt(tbl_items.getSelectedRow(),0).toString());
                    if (itemController.delete(id)){
                        Helper.showAutoMessage("done");
                        loadItems(null);
                    }
                    else {
                        Helper.showAutoMessage("error");
                    }
                }
            };

        });


        btn_product_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode=txt_product_barcode.getText();
                String name=txt_product_name.getText();
                String author=txt_product_author.getText();
                int pageNumber=Integer.parseInt(txt_product_page_nmber.getText());
                boolean available=Boolean.parseBoolean(cmbx_product_available.getSelectedItem().toString());
                String type=cmbx_product_type.getSelectedItem().toString();

                LibraryItem libraryItem=null;

                JTextField [] checkList={txt_product_barcode,txt_product_name,txt_product_author,txt_product_page_nmber};
                if (Helper.isFieldListEmpty(checkList)){
                    Helper.showAutoMessage("fill");
                }

                else {
                    boolean result=false;
                    if (type.equals("KİTAP")){
                        libraryItem=new Book(barcode,name,author,pageNumber,available,type);
                    }
                    else if (type.equals("DVD")){
                        libraryItem =new DVD(name,available,type,barcode,author);
                    }
                    else if (type.equals("MAGAZİN")){
                        libraryItem=new Magazine(barcode,name,author,pageNumber,available,type);
                    }

                    if (libraryItem.getID()==0){
                        result= itemController.save(libraryItem);
                    }

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
        btn_to_barrow_and_take.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BringBarrowUI bringBarrowUI=new BringBarrowUI();
            }
        });
    }



    private void loadCustomerPopUpMenu() {
        this.tbl_items.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_items.rowAtPoint(e.getPoint()); // Seçilen satırı alıyoruz

                // Eğer zaten seçili satıra tekrar tıklanıyorsa, seçimi kaldır
                if (!tbl_items.isRowSelected(selectedRow)) {
                    // Farklı bir satıra tıklanıyorsa, o satırı seç
                    tbl_items.setRowSelectionInterval(selectedRow, selectedRow);  // Seçimi uygula
                    btn_product_add.setEnabled(false); // Butonu devre dışı bırak
                    txt_product_barcode.setEnabled(false);
                    txt_product_name.setEnabled(false);
                    txt_product_author.setEnabled(false);
                    txt_product_page_nmber.setEnabled(false);
                    cmbx_product_available.setEnabled(false);
                    cmbx_product_type.setEnabled(false);
                }
                else {
                    tbl_items.removeRowSelectionInterval(selectedRow, selectedRow);  // Seçimi kaldır
                    btn_product_add.setEnabled(true); // Butonu tekrar aktif yap

                    txt_product_barcode.setText("");
                    txt_product_barcode.setEnabled(true);



                    txt_product_name.setEnabled(true);
                    txt_product_name.setText("");

                    txt_product_author.setEnabled(true);
                    txt_product_author.setText("");

                    txt_product_page_nmber.setEnabled(true);
                    txt_product_page_nmber.setText("");

                    cmbx_product_available.setEnabled(true);
                    cmbx_product_type.setSelectedItem(null);

                    cmbx_product_type.setEnabled(true);
                    cmbx_product_type.setSelectedItem(null);

                    return;
                }

                // Seçilen satırdaki tüm veriyi alıyoruz
                if (selectedRow != -1) {
                    Object[] rowData = new Object[tmbl_items.getColumnCount()];

                    // Satırdaki tüm veriyi rowData dizisine alıyoruz
                    for (int col = 0; col < tmbl_items.getColumnCount(); col++) {
                        rowData[col] = tmbl_items.getValueAt(selectedRow, col);
                    }

                    LibraryItem libraryItem=LibraryItemFactory.createItem(rowData);
                    txt_product_name.setText(libraryItem.getTitle());
                    cmbx_product_type.setSelectedIndex(1);

                    if (libraryItem.isAvailable()){
                        cmbx_product_available.setSelectedIndex(0);
                    }
                    else
                        cmbx_product_available.setSelectedIndex(1);

                    if (libraryItem instanceof DVD){
                        txt_product_barcode.setText(((DVD) libraryItem).getBarcode());
                        txt_product_author.setText(((DVD) libraryItem).getDirector());
                        txt_product_page_nmber.setText("--");
                    }

                    else if (libraryItem instanceof Book)
                    {
                        txt_product_barcode.setText(((Book) libraryItem).getBarcode());
                        txt_product_author.setText(((Book) libraryItem).getAuthor());
                        txt_product_page_nmber.setText(Integer.toString(((Book) libraryItem).getPageNumber()));
                    }
                    else if (libraryItem instanceof Magazine)
                    {
                        txt_product_barcode.setText(((Magazine) libraryItem).getBarcode());
                        txt_product_author.setText(((Magazine) libraryItem).getPublisher());
                        txt_product_page_nmber.setText(Integer.toString(((Magazine) libraryItem).getPageNumber()));
                    }


                }



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
