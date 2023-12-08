import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state.
 */

public class CarController {
    // member fields:

    private CarView frame;
    private ArrayList<Vehicle> vehicles;

    public CarController(ArrayList<Vehicle> vehicles, CarView frame)
    {
        this.vehicles = vehicles;
        this.frame = frame;
    }

    public void initButtons()
    {
        frame.addGasButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            {
                Model.gas(frame.gasAmount, vehicles);}
            }
        });

        frame.addBrakeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    Model.brake(frame.gasAmount, vehicles);}
            }
        });

        frame.addTurboOnButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle saab : vehicles)
                {
                    if (saab instanceof Saab95)
                    {
                        ((Saab95) saab).setTurboOn();
                    }
                }
            }
        });

        frame.addTurboOffButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle saab : vehicles)
                {
                    if (saab instanceof Saab95)
                    {
                        ((Saab95) saab).setTurboOff();
                    }
                }
            }
        });

        frame.addLiftBedButtonListener(new ActionListener() {
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

        frame.addLowerBedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Vehicle car : vehicles)
                {
                    if (car instanceof Scania)
                    {
                        ((Scania) car).flatbedDown(70);
                    }
                }
            }
        });

        frame.addStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.startEngine(vehicles);
            }
        });

        frame.addStopButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.stopEngine(vehicles);
            }
        });

        frame.addAddARandomCarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.addARandomCar(vehicles);
            }
        });
        frame.addRemoveCarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.removeACar(vehicles);
            }
        });
    }
}
