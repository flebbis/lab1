import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getxPosition());
                int y = (int) Math.round(vehicle.getyPosition());
                frame.drawPanel.moveit(x, y, vehicles);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

                checkOutOfBounds(vehicle);
            }

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

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
        {
            vehicle.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
        {
            vehicle.brake(brake);
        }
    }
    void stopEngine()
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.stopEngine();
        }
    }
}
