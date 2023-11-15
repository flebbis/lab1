import java.awt.*;
import java.util.ArrayList;

public class AutomobileTransport extends Truck
{

    public AutomobileTransport()
    {
        super(2,250, Color.blue, "Långtradare", 2);
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
        if (getCurrentDegree() == 70) //  && sqrt(((car.getxPosition - this.getxPosition)**2) + ((car.getxposition - this.getxposition)**2)) < maxDistance
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
            for (int i = storageCapacity - 1; i <= 0; i--)
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
        switch (((currentDirection % 4) + 4) % 4)    //converts negative modulus to positive
        {
            case 0: //0 is NORTH
                yPosition += currentSpeed;
                break;
            case 1: //1 is EAST
                xPosition += currentSpeed;
                break;
            case 2: //2 is SOUTH
                yPosition -= currentSpeed;
                break;
            case 3: //3 is WEST
                xPosition -= currentSpeed;
                break;
        }
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

