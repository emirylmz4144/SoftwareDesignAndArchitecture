public class JeptaFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String model, String engine, String oilType, String color, int price) {
        return new Jepta(model, engine, oilType, color, price);
    }
}
