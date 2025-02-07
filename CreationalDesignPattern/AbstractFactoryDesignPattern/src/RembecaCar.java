public class RembecaCar {
    public static void main(String[] args) {

        VehicleFactory jeptaFactory=new JeptaFactory();
        Vehicle jepta=jeptaFactory.createVehicle("jeptanano","23","Benzin","Siyah",900000);

        System.out.println(jepta);
    }
}
