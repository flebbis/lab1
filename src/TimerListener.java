import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


/* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * */
class TimerListener implements ActionListener {
    //private final CarController carController;

    private final int delay = 50;

    private ArrayList<Vehicle> vehicles;
    public TimerObserver observer;



    public TimerListener(TimerObserver observer, ArrayList<Vehicle> vehicles)
    {
        this.observer = observer;
        this.vehicles = vehicles;
    }

    private Timer timer = new Timer(delay, this);

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : this.vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getxPosition());
            int y = (int) Math.round(vehicle.getyPosition());
            //moveit(x, y, vehicles); TOGS BORT VID LABB 4
            // repaint() calls the paintComponent method of the panel
            //carController.frame.drawVehiclesAndVehiclePanel.repaint();
            observer.actOnUpdate();
            checkOutOfBounds(vehicle);
        }

    }


    private void checkOutOfBounds(Vehicle vehicle)
    {
        Boolean outOfBoundNorth = vehicle.getyPosition() < 0;
        Boolean outOfBoundSouth = vehicle.getyPosition() > 500;
        Boolean outOfBoundEast = vehicle.getxPosition() > 685;
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
            hitWallHorizontalReposition(vehicle, 685);
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
    public static void addARandomCar(ArrayList<Vehicle> vehicles){
        vehicles.add(VehicleFactory.createRandomVehicle());
    }
    public static void removeACar(ArrayList<Vehicle> vehicles){
        if (vehicles.size() != 0){
            Random randint = new Random();
            vehicles.remove(randint.nextInt(vehicles.size()));
        }
    }
}
