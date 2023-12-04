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

        cc.vehicles.add(VehicleFactory.createVolvo240());
        cc.vehicles.add(VehicleFactory.createSaab95());
        cc.vehicles.add(VehicleFactory.createScania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc.vehicles);
        cc.initButtons();
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
                moveit(x, y, vehicles);
                // repaint() calls the paintComponent method of the panel
                frame.drawVehiclesAndVehiclePanel.repaint();

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

    
    void moveit(int x, int y, ArrayList<Vehicle> vehicles)
    {
        int i = 0;
        for (Vehicle v : frame.drawVehiclesAndVehiclePanel.vehicles)
        {
            v.xPosition = vehicles.get(i).xPosition;
            v.yPosition = vehicles.get(i).yPosition;
            i++;
        }
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
    void startEngine()
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.startEngine();
        }
    }
    void stopEngine()
    {
        for (Vehicle vehicle : vehicles)
        {
            vehicle.stopEngine();
        }
    }
    private void initButtons()
    {
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {gas(frame.gasAmount);}
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){brake(frame.gasAmount);}
        });

        frame.stopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stopEngine();
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   for (Vehicle saab : vehicles)
            {
                if (saab instanceof Saab95)
                {
                    ((Saab95) saab).setTurboOn();
                }
            }
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    for (Vehicle saab : vehicles)
            {
                if (saab instanceof Saab95)
                {
                    ((Saab95) saab).setTurboOff();
                }
            }
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : vehicles)
                {
                    if (car instanceof Scania)
                    {
                        ((Scania) car).flatbedUp(70);
                    }
                }
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : vehicles)
                {
                    if (car instanceof Scania)
                    {
                        ((Scania) car).flatbedDown(70);
                        System.out.println(((Scania) car).getCurrentDegree());
                    }
                }
            }
        });

        frame.startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               startEngine();
            }
        });
    }
}
