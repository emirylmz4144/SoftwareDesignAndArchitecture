package Business;

import Core.Helper;
import Core.Item;
import DAO.ItemDAO;
import Entity.LibraryItem;
import Entity.Student;

import java.util.ArrayList;

public class ItemController {



    ItemDAO itemDAO;

    public ItemController() {
        itemDAO = new ItemDAO();
    }

    public ArrayList<LibraryItem> getAll(){
        return this.itemDAO.getAll();
    }

    public ArrayList<LibraryItem> filter(String productName, Item item){
        System.out.println("name "+productName);
        System.out.println("item "+item);
        String query="Select * from library_item";

        ArrayList<String> whereList=new ArrayList<>();
        if (productName!=null){
            whereList.add("title ilike '%"+productName+"%'");
        }

        if (item!=null){
            if (item.getKey()==1)
                whereList.add("type='Kitap'");
            else if (item.getKey()==2)
                whereList.add("type='DVD'");
            else
                whereList.add("type='Magazin'");

            if (whereList.size()>0){
                String wherequery=String.join(" and ",whereList);
                query+=" where "+wherequery;
            }
            return itemDAO.filterByQuery(query);
        }

        if (whereList.size()>0){
            String wherequery=String.join(" and ",whereList);
            query+=" where "+wherequery;
        }
        System.out.println("Item Controller :"+query);
        return this.itemDAO.filterByQuery(query);
    }


    public boolean save(LibraryItem item){
        return itemDAO.save(item);
    }
    public boolean delete(int id){
        if (this.getById(id)==null){
            Helper.showAutoMessage(id+ "Ürün bulunamadı");
            return false;
        }
        return this.itemDAO.delete(id);
    }

    public ArrayList<LibraryItem> findItemByBarcode(String barcode){
        return itemDAO.findItemByBarcode(barcode);
    }
    public LibraryItem getById(int id){
        return this.itemDAO.getById(id);
    }
}
