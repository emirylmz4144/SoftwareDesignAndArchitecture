public class VehicleBuilder
{
    private String model;
    private String engine;
    private String oilType;
    private String color;
    private int price;

    private String gearType;
    private int seatCount;
    private boolean sunroof;
    private String infotainmentSystem;
    private double fuelEfficiency;
    private int warrantyYears;

    public static VehicleBuilder startNormalBuild(String model,String engine,String oilType,String color,int price){
        VehicleBuilder vehicleBuilder = new VehicleBuilder();
        vehicleBuilder.model = model;
        vehicleBuilder.engine = engine;
        vehicleBuilder.oilType = oilType;
        vehicleBuilder.color = color;
        vehicleBuilder.price = price;
        return vehicleBuilder;
    }


    public Vehicle build(){
        Vehicle vehicle=new Vehicle();
        vehicle.setModel(model);
        vehicle.setEngine(engine);
        vehicle.setOilType(oilType);
        vehicle.setColor(color);
        vehicle.setPrice(price);
        vehicle.setGearType(gearType);
        vehicle.setSeatCount(seatCount);
        vehicle.setSunroof(sunroof);
        vehicle.setInfotainmentSystem(infotainmentSystem);
        vehicle.setFuelEfficiency(fuelEfficiency);
        vehicle.setWarrantyYears(warrantyYears);
        return vehicle;
    }



    public VehicleBuilder setGearType(String gearType) {
        this.gearType = gearType;
        return this;
    }

    public VehicleBuilder setSeatCount(int seatCount) {
        this.seatCount = seatCount;
        return this;
    }

    public VehicleBuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    public VehicleBuilder setInfotainmentSystem(String infotainmentSystem) {
        this.infotainmentSystem = infotainmentSystem;
        return this;
    }

    public VehicleBuilder setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        return this;
    }

    public VehicleBuilder setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
        return this;
    }
}
