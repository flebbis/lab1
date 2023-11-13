import java.awt.*;
import java.util.ArrayList;

public class AutomobileTransport extends Truck
{
    public Car[] storage = new Car[2];


    public AutomobileTransport()
    {
        super(2,250, Color.blue, "Långtradare");
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
    public void load(Car type)
    {
        if (getCurrentDegree() == 0)
        {
            storage[0] = type;
        }
    }
    public void unload()
    {

    }
}

