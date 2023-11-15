import java.awt.*;

public abstract class Truck extends Vehicle
{
    protected double currentDegree;
    protected Car[] storage;
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
            currentSpeed = getCurrentSpeed() + amount * speedFactor();
        }
        else
        {
            System.out.println("lower the flatbed");
        }

    }

    public void flatbedUp(double amount)
    {
        if (getCurrentSpeed() == 0)
        {
            if (amount > 0 && (amount + getCurrentDegree()) <= 70)
            {
                currentDegree += amount;
            }
        }
        else
        {
            System.out.println("Stop the truck before trying to unload");
        }
    }

    public void flatbedDown(double amount)
    {
        if (amount > 0 && (getCurrentDegree() - amount > 0))
        {
            currentDegree -= amount;
        }
    }

    @Override
    protected void decrementSpeed(double amount)
    {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

}
