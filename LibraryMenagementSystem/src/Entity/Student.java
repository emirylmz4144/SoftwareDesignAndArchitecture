package Entity;

import java.util.List;

public class Student extends Person
{

    public Student(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Student(){}

    @Override
    public boolean barrow() {
        return false;
    }

    @Override
    public boolean returnItem() {
        return false;
    }

    public List<ILibraryItem> barrowedItem(){
        return null;
    }
}
