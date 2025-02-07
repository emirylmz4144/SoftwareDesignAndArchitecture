package Entity;

public class Admin extends Person{

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Admin() {}

    @Override
    public boolean barrow() {
        return false;
    }

    @Override
    public boolean returnItem() {
        return false;
    }
}
