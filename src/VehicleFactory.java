import java.util.Random;
public class VehicleFactory {

    public static Vehicle createSaab95()
    {
        return new Saab95();
    }

    public static Vehicle createVolvo240()
    {
        return new Volvo240();
    }

    public static Vehicle createScania()
    {
        return new Scania();
    }

    public static Vehicle createRandomVehicle()
    {
        Random randomInt = new Random();
        int pickedCar = randomInt.nextInt(3);

        switch (pickedCar){
            case 0:
                return createSaab95();
            case 1:
                return createVolvo240();
            case 2:
                return createScania();

        }

        return new Scania();
    }

}
