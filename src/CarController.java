import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state.
 */

public class CarController {
    // member fields:

    Random randint = new Random();
    CarView frame;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void initButtons()
    {
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {TimerListener.gas(frame.gasAmount, vehicles);}
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){TimerListener.brake(frame.gasAmount, vehicles);}
        });

        frame.stopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
               TimerListener.stopEngine(vehicles);
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
            public void actionPerformed(ActionEvent e) {for (Vehicle saab : vehicles)
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
            {TimerListener.startEngine(vehicles);
            }
        });
        frame.addARandomCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TimerListener.addARandomCar(vehicles);
            }
        });
        frame.removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               TimerListener.removeACar(vehicles);
            }
        });
    }
}
