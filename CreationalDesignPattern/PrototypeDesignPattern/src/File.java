public class File implements Cloneable
{
    public int id;
    public String name;
    public FileType type;
    public FileCategory category;
    public String content;

    public File(){}

    public File(int id, String name, FileType type, FileCategory category, String content) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public FileCategory getCategory() {
        return category;
    }

    public void setCategory(FileCategory category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", category=" + category +
                ", content='" + content + '\'' +
                '}';
    }

  //  //Shallov copy
  //  @Override
  //  protected File clone() throws CloneNotSupportedException {
  //      return (File) super.clone();
  //  }

      //Deep Copy
    @Override
    protected File clone() throws CloneNotSupportedException {
        File file =(File) super.clone();
        FileType fileType=file.getType().clone();
        FileCategory fileCategory=file.getCategory().clone();

        file.setType(fileType);
        file.setCategory(fileCategory);
        return file;

    }
}
