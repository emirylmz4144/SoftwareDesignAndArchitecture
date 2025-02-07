package Entity;

public abstract class LibraryItem implements ILibraryItem {

    public int id;
    public String title;
    public boolean available;
    String type;

    public LibraryItem(int id, String title, boolean available,String type) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.type = type;
    }

    public LibraryItem(String title, boolean available,String type){
        this.title = title;
        this.available = available;
        this.type = type;
    }

    public LibraryItem(){}






    @Override
    public int getID() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available=available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static enum Type{
        KİTAP,
        DVD,
        MAGAZİN
    }

    public static enum Availability{
        MÜSAİT,
        ÖDÜNÇTE
    }
}
