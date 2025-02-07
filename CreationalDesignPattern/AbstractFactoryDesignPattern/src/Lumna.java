public class Lumna implements Vehicle{

    public String model;
    public String engine;
    public String oilType;
    public String color;
    public int price;

    public Lumna(String model, String engine, String oilType, String color, int price) {
        this.model = model;
        this.engine = engine;
        this.oilType = oilType;
        this.color = color;
        this.price = price;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getEngine() {
        return engine;
    }

    @Override
    public String getOilType() {
        return oilType;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", oilType='" + oilType + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
