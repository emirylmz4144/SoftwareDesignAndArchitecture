public class LumnaFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String model, String engine, String oilType, String color, int price) {
        return new Lumna(model, engine, oilType, color, price);
    }
}
