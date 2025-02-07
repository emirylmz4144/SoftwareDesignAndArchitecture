package Core;

import Entity.Book;
import Entity.DVD;
import Entity.LibraryItem;
import Entity.Magazine;

public class LibraryItemFactory {

    public static LibraryItem createItem(Object [] rowData){

        boolean available;
        if (rowData[5].equals("ÖDÜNÇTE"))
            available=false;
        else
            available=true;

        if (rowData[6].toString().equals("Kitap"))
                return new Book((int)rowData[0],(String)rowData[1],(String) rowData[2],(String) rowData[3],(int) rowData[4],available,(String)rowData[6] );
        else if (rowData[6].toString().equals("DVD"))
                return new DVD((int)rowData[0],(String)rowData[1],(String) rowData[2],(String) rowData[3],available,(String)rowData[6]);
        else
                return new Magazine((int)rowData[0],(String)rowData[1],(String) rowData[2],(String) rowData[3],(int) rowData[4],available,(String)rowData[6] );
        }
    }

