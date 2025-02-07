
public class Service {

    public FileType findFileTypeById(int id){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileType fileType = new FileType();
        fileType.setId(id);

        String name;
        if (id == 1)
            name = "Kişisel";
        else if (id==2)
            name = "Kurumsal";
        else
            name = "Genel";


        fileType.setName(name);

        return fileType;
    }

    public FileCategory findFileCategoryById(int id){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileCategory fileCategory = new FileCategory();
        fileCategory.setId(id);

        String name;
        if (id == 1)
            name = "Özel";
        else if (id==2)
            name = "İş";
        else
            name = "Genel";

        fileCategory.setName(name);

        return fileCategory;
    }

    public File findFileById(int id) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File file = new File();
        file.setId(id);
        file.setCategory(findFileCategoryById(id));
        file.setType(findFileTypeById(id));

        String name;
        String content;
        if (id==1){
            name = "Mektup";
            content = "Sevgili dostum Ahmet, ....";
        } else if (id==2){
            name = "Rapor";
            content = "Bu rapor genel müdüre verilmek üzere hazırlanmıştır..";
        } else {
            name = "Trafik Kuralları";
            content = "Sağa dönüşte yayaya yol ver!";
        }

        file.setName(name);
        file.setContent(content);

        return file;
    }
}