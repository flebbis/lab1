import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

class Model implements ActionListener {
    private final int delay = 50;
    private ArrayList<Vehicle> vehicles;
    private TimerObserver observer;

    public Model(TimerObserver observer, ArrayList<Vehicle> vehicles)
    {
        this.observer = observer;
        this.vehicles = vehicles;
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : this.vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getxPosition());
            int y = (int) Math.round(vehicle.getyPosition());
            checkOutOfBounds(vehicle);
        }
        observer.actOnUpdate();
    }

    private void checkOutOfBounds(Vehicle vehicle)
    {
        Boolean outOfBoundNorth = vehicle.getyPosition() < 0;
        Boolean outOfBoundSouth = vehicle.getyPosition() > 500;
        Boolean outOfBoundEast = vehicle.getxPosition() > 985;
        Boolean outOfBoundWest = vehicle.getxPosition() < 0;

        if (outOfBoundNorth)
        {
            hitWallVerticalReposition(vehicle, 0);
        }
        else if (outOfBoundSouth)
        {
            hitWallVerticalReposition(vehicle, 500);
        }
        else if (outOfBoundEast)
        {
            hitWallHorizontalReposition(vehicle, 985);
        }
        else if (outOfBoundWest)
        {
            hitWallHorizontalReposition(vehicle, 0);
        }
    }

    private static void hitWallVerticalReposition(Vehicle vehicle, int position)
    {
        vehicle.stopEngine();
        vehicle.turnLeft();
        vehicle.turnLeft();
        vehicle.setyPosition(position);
        vehicle.startEngine();
    }

    private static void hitWallHorizontalReposition(Vehicle vehicle, int position)
    {
        vehicle.stopEngine();
        vehicle.turnLeft();
        vehicle.turnLeft();
        vehicle.setxPosition(position);
        vehicle.startEngine();
    }


    void moveit(int x, int y, ArrayList<Vehicle> vehicles)
    {
        int i = 0;
        for (Vehicle v : this.vehicles)
        {
            v.xPosition = vehicles.get(i).xPosition;
            v.yPosition = vehicles.get(i).yPosition;
            i++;
        }
    }

    // Calls the gas method for each car once
    public static void gas(int amount, ArrayList<Vehicle> vehicles) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
        {
            vehicle.gas(gas);
        }
    }
    public static void brake(int amount, ArrayList<Vehicle> vehicles){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
        {
            vehicle.brake(brake);
        }
    }
    public static void startEngine(ArrayList<Vehicle> vehicles)
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.startEngine();
        }
    }
    public static void stopEngine(ArrayList<Vehicle> vehicles)
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.stopEngine();
        }
    }
    public static void addARandomCar(ArrayList<Vehicle> vehicles)
    {
        if (vehicles.size() < 10)
            vehicles.add(VehicleFactory.createRandomVehicle());
    }
    public static void removeACar(ArrayList<Vehicle> vehicles){
        if (vehicles.size() != 0){
            Random randint = new Random();
            vehicles.remove(randint.nextInt(vehicles.size()));
        }
    }
}
