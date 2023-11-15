import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Workshop<AbritaryVehicle extends Vehicle>
{
    private LinkedList<AbritaryVehicle> vehicles;
    private int capacity;


    public Workshop(int capacity)
    {
        this.capacity = capacity;
        vehicles = new LinkedList<AbritaryVehicle>();
    }

    public LinkedList<AbritaryVehicle> getVehicles()
    {
        return vehicles;
    }


    public void load(AbritaryVehicle c)
    {
        if (vehicles.size() <= this.capacity)
        {
            vehicles.add(c);
        }
        else
            System.out.println("Workshop is full");
    }


    public AbritaryVehicle unLoad(AbritaryVehicle c)
    {
        AbritaryVehicle vehicleToBeRemoved = vehicles.get(vehicles.indexOf(c));
        vehicles.remove(c);
        return vehicleToBeRemoved;
    }
}
