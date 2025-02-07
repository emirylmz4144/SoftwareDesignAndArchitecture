package Core;

import Entity.LibraryItem;

import java.util.ArrayList;

public class SearchContext {
    private SearchStrategy strategy;

    // Strateji set etme
    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    // Stratejiyi çalıştırma
    public ArrayList<LibraryItem> executeStrategy(String query, String itemType) {
        System.out.println("Çalışma: "+query+" "+itemType);
        return strategy.search(query, itemType);
    }
}

