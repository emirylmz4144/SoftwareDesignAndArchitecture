package Core;

import Business.ItemController;
import Entity.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class TypeStrategy implements SearchStrategy{

    public static ItemController itemController=new ItemController();
    @Override
    public ArrayList<LibraryItem> search(String query, String itemType) {
        ArrayList<LibraryItem> result = new ArrayList<>();
        // Koleksiyonunuzdaki öğeleri filtreliyoruz
        List<LibraryItem> allItems = getAllItems(); // Veritabanındaki ya da mevcut öğelerin listesi

        // Belirtilen tür ile öğeleri filtreliyoruz
        for (LibraryItem item : allItems) {
            if (item.getType().equals(itemType)) {
                result.add(item);
            }
        }
        return result;
    }

    private List<LibraryItem> getAllItems() {
        return itemController.getAll();
    }
}
