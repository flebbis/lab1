import javax.swing.*;
import java.util.ArrayList;

public class ApplicationDrivingGame {

    public static void main(String[] args)
    {
        final int delay = 50;
        CarController cc = new CarController();

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(VehicleFactory.createVolvo240());
        vehicles.add(VehicleFactory.createSaab95());
        vehicles.add(VehicleFactory.createScania());

        cc.vehicles = vehicles;


        CarView frame = new CarView("CarSim 1.0", vehicles);
        cc.frame = frame;

        Timer timer = new Timer(delay, new TimerListener(frame, vehicles));

        cc.initButtons();
        timer.start();
    }

}
