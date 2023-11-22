import java.awt.*;
import java.util.Stack;

public abstract class Truck extends Vehicle
{
    protected double currentDegree;
    protected Car[] storage;
//    protected Stack<Car> storage;
    protected final int storageCapacity;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int load)
    {
        super(nrDoors, enginePower, color, modelName);
        currentDegree = 0;
        storageCapacity = load;
        storage = new Car[storageCapacity];
    }

    public Car[] getStorage()
    {
        return storage;
    }

    protected double speedFactor()
    {
        return enginePower * 0.02;
    }

    public double getCurrentDegree()
    {
        return currentDegree;
    }

    @Override
    protected void incrementSpeed(double amount)
    {
        if (currentDegree == 0)
        {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;

        }
        else
        {
            System.out.println("lower the flatbed");
        }

    }

    @Override
    protected void decrementSpeed(double amount)
    {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

}
