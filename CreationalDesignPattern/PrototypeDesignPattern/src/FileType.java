public class FileType implements Cloneable
{
    public int id;
    public String name;

    public FileType() {
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
        return "FileType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected FileType clone() throws CloneNotSupportedException {
        return (FileType) super.clone();
    }
}
