public class NanumFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String model, String engine, String oilType, String color, int price) {
        return new Nanum(engine,model,oilType,color,price);
    }
}
