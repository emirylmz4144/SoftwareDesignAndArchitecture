package Entity;

public class Magazine extends LibraryItem{
    String barcode;
    int pageNumber;
    String publisher;
    public Magazine(int id, String barcode,String title, String publisher,int pageNumber,boolean available,String type) {
        super(id, title, available,type);
        this.barcode = barcode;
        this.pageNumber = pageNumber;
        this.publisher = publisher;
    }

    public Magazine(String barcode,String title, String publisher,int pageNumber,boolean available,String type){
        super(title,available,type);
        this.barcode = barcode;
        this.pageNumber = pageNumber;
        this.publisher = publisher;
    }
    public Magazine(){}

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
