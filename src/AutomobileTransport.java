import java.awt.*;
import java.util.ArrayList;

public class AutomobileTransport extends Truck
{

    public AutomobileTransport()
    {
        super(2, 250, Color.blue, "Långtradare", 2);
    }

    public void flatbedChange(boolean rampActiveOrInactive)
    {
        if (rampActiveOrInactive)
        {
            currentDegree = 70;
        }
        else
        {
            currentDegree = 0;
        }
    }

    public void load(Car car)
    {
        if (getCurrentDegree() == 70 && Math.sqrt((Math.pow(car.getxPosition() - this.getxPosition(), 2) + (Math.pow(car.getyPosition() - this.getyPosition(), 2)))) < 1)
        {
            for (int i = 0; i < storageCapacity; i++)
            {
                if (storage[i] == null)
                {
                    storage[i] = car;
                    carOnTruckMover(); //Så bilens position uppdateras
                }
            }
        }
    }

    public void unload()
    {
        if (getCurrentDegree() == 70)
        {
            for (int i = storage.length - 1; i >= 0; i--)
            {
                if (storage[i] != null)
                {
                    storage[i].setyPosition(this.getyPosition() - 1);
                    storage[i] = null;
                }
            }
        }
    }

    @Override
    public void move()
    {
        super.move();
        carOnTruckMover();
    }

    private void carOnTruckMover()
    {
        for (Car element : storage)
        {
            if (element != null)
            {
                element.setxPosition(this.getxPosition());
                element.setyPosition(this.getyPosition());
            }
        }
    }
}
