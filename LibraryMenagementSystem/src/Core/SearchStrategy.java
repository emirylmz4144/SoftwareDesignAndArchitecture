package Core;

import Entity.LibraryItem;

import java.util.ArrayList;

public interface SearchStrategy {
    ArrayList<LibraryItem> search(String query, String itemType);
}
