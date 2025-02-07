public class Vehicle {

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

    public Vehicle(){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public String getInfotainmentSystem() {
        return infotainmentSystem;
    }

    public void setInfotainmentSystem(String infotainmentSystem) {
        this.infotainmentSystem = infotainmentSystem;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    public void setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", oilType='" + oilType + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", gearType='" + gearType + '\'' +
                ", seatCount=" + seatCount +
                ", sunroof=" + sunroof +
                ", infotainmentSystem='" + infotainmentSystem + '\'' +
                ", fuelEfficiency=" + fuelEfficiency +
                ", warrantyYears=" + warrantyYears +
                '}';
    }
}
