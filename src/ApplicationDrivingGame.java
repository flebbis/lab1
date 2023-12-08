import javax.swing.*;
import java.util.ArrayList;

public class ApplicationDrivingGame {

    public static void main(String[] args)
    {
        final int delay = 50;

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(VehicleFactory.createVolvo240());
        vehicles.add(VehicleFactory.createSaab95());
        vehicles.add(VehicleFactory.createScania());

        CarView frame = new CarView("CarSim 1.0", vehicles);

        CarController cc = new CarController(vehicles, frame);

        Timer timer = new Timer(delay, new Model(frame, vehicles));

        cc.initButtons();
        timer.start();
    }
}
