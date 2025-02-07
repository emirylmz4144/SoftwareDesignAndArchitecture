public class FileCategory implements Cloneable
{
    public int id;
    public String name;

    public FileCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FileCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected FileCategory clone() throws CloneNotSupportedException {
        return (FileCategory) super.clone();
    }
}
