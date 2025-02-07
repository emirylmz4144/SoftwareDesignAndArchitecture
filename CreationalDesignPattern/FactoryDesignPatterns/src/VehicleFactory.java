public class VehicleFactory
{
    public static Vehicle createVehicle(String model,String engine,String oilType,String color,int price){
        if (model.equalsIgnoreCase("Lumna"))
            return new Lumna(model,engine,oilType,color,price);
        else if (model.equalsIgnoreCase("Nanum"))
            return new Nanum(model,engine,oilType,color,price);
        else if (model.equalsIgnoreCase("Jepta"))
            return new Jepta(model,engine,oilType,color,price);
        else
            throw new IllegalArgumentException("Üretim Dışı arabaa modeli girildi");
    }
}
