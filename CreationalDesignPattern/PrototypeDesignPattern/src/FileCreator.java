import java.util.Date;

public class FileCreator {
    public static void main(String[] args)  {
        Service service=new Service();

        Date startDate=new Date();
        File file =service.findFileById(2);
        Date endDate=new Date();

        System.out.println(file);
        System.out.println(calculateTime(startDate,endDate));

        Date startDate2=new Date();
        File cloneFile=null;
       try{
           cloneFile=file.clone();
       }catch(CloneNotSupportedException e){
           System.out.println(e.getMessage());
       }
       Date endDate2=new Date();
       System.out.println(calculateTime(startDate2,endDate2));

       cloneFile.getType().setName("Gizli");

        System.out.println(cloneFile);
        System.out.println(file);
       //Tehlikeli durum shallov clone durumunda geçerli olur
       if (cloneFile.getType()==file.getType()){
           System.out.println("İç nesne referansları aynı");
       }
       //Deep Copy
       else {
           System.out.println("İç nesne referansları farklı");
       }

    }

    public static Long calculateTime(Date first, Date second) {
        return ((second.getTime()/1000)-(first.getTime()/1000));
    }
}
