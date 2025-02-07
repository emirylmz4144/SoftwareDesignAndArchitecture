public class RambacaCar {
    public static void main(String[] args) {

        Vehicle normalCar=VehicleBuilder
                .startNormalBuild("LemnaV4","1.6","Benzin","Beyaz",1_250_900)
                        .setSunroof(true)
                        .setWarrantyYears(2023)
                        .build();

        System.out.println(normalCar);

    }
}
