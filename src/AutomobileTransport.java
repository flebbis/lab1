import java.awt.*;
import java.util.ArrayList;

public class AutomobileTransport extends Truck
{

    public AutomobileTransport()
    {
        super(2,250, Color.blue, "Långtradare", 2);
    }
    public void changeRamp(double bite)
    {
        if (bite == 1)
        {
            flatbedUp(70);
        }
        else if (bite == 0)
        {
            flatbedDown(70);
        }
        else
            System.out.println("Only accepts the values 0 or 1. One being up 0 being down");
    }
    public void load(Car car)
    {
        if (getCurrentDegree() == 70) //  && sqrt(((car.getxPosition - this.getxPosition)**2) + ((car.getxposition - this.getxposition)**2)) < maxDistance
        {
            for (int i = 0; i < storageCapacity; i++)
            {
                if (storage[i] == null)
                {
                    storage[i] = car;
                }
            }
        }
    }
    public void unload()
    {
        if (getCurrentDegree() == 70)
        {
            for (int i = storageCapacity - 1; i <= 0; i--)
            {
                if (storage[i] != null)
                {
                    storage[i] = null;
                }
            }
        }
    }

    @Override
    public void move()    // update the load aswell
    {}
}

