package Entity;

public class DVD extends LibraryItem{
    public String director;
    String barcode;
    public DVD(int id, String barcode,String title,  String director,boolean available,String type) {
        super(id, title, available,type);
        this.barcode=barcode;
        this.director = director;
    }

    public DVD(String title,boolean available,String type,String barcode, String director) {
        super(title,available,type);
        this.barcode=barcode;
        this.director = director;

    }

    public DVD(){};

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
