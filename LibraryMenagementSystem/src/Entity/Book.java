package Entity;

public class Book extends LibraryItem{
    String barcode;
    int pageNumber;
    String author;
    public Book(int id,String barcode,String title, String author,int pageNumber,boolean available,String type) {
        super(id, title, available,type);
        this.barcode=barcode;
        this.pageNumber=pageNumber;
        this.author = author;
    }
    public Book(String barcode,String title, String author,int pageNumber,boolean available,String type){
        super(title, available,type);
        this.barcode=barcode;
        this.pageNumber=pageNumber;
        this.author = author;

    }

    public Book (){}

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
