import java.awt.*;

public class Scania extends Truck
{

    public Scania()
    {
        super(2,200, Color.red,"Scania",0);

    }

    public void flatbedDown(double amount)
    {
        if (amount > 0 && (getCurrentDegree() - amount >= 0))
        {
            currentDegree -= amount;
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
}
