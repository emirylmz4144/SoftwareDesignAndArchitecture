package Core;

import Business.ItemController;
import Entity.LibraryItem;

import java.util.ArrayList;
import java.util.List;

;

public class NameStrategy implements SearchStrategy{


    static ItemController itemController=new ItemController();
    @Override
    public ArrayList<LibraryItem> search(String query, String itemType) {
        ArrayList<LibraryItem> result = new ArrayList<>();
        // Koleksiyonunuzdaki öğeleri filtreliyoruz
        List<LibraryItem> allItems = getAllItems(); // Veritabanındaki ya da mevcut öğelerin listesi

        // Arama yapılan öğe türüne göre filtreleme yapıyoruz
        for (LibraryItem item : allItems) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())) {
                // Eğer başlıkta arama sorgusunun bir kısmı varsa, bu öğeyi sonuç listesine ekliyoruz
                result.add(item);
            }
        }
        return result;
    }

    private List<LibraryItem> getAllItems() {
        return itemController.getAll();
    }
}
