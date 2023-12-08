import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarView extends JFrame implements TimerObserver{
    private static final int X = 1100;
    private static final int Y = 1100;

    private ArrayList<Vehicle> vehicles;
    private DrawVehiclesAndVehiclePanel drawVehiclesAndVehiclePanel;

    private JPanel controlPanel = new JPanel();
    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");
    private JButton addARandomCar = new JButton("Add a random car");
    private JButton removeCar = new JButton("Remove a random car");

    // Constructor
    public CarView(String framename, ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
        this.drawVehiclesAndVehiclePanel = new DrawVehiclesAndVehiclePanel(X, Y-300, vehicles);
        initComponents(framename);
    }

    public void addGasButtonListener(ActionListener listener) {
        gasButton.addActionListener(listener);
    }
    public void addBrakeButtonListener(ActionListener listener) {
        brakeButton.addActionListener(listener);
    }
    public void addTurboOnButtonListener(ActionListener listener) {
        turboOnButton.addActionListener(listener);
    }
    public void addTurboOffButtonListener(ActionListener listener) {
        turboOffButton.addActionListener(listener);
    }
    public void addLiftBedButtonListener(ActionListener listener) {
        liftBedButton.addActionListener(listener);
    }
    public void addLowerBedButtonListener(ActionListener listener) {
        lowerBedButton.addActionListener(listener);
    }
    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
    public void addStopButtonListener(ActionListener listener) {
        stopButton.addActionListener(listener);
    }
    public void addAddARandomCarButtonListener(ActionListener listener) {
        addARandomCar.addActionListener(listener);
    }
    public void addRemoveCarButtonListener(ActionListener listener) {
        removeCar.addActionListener(listener);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawVehiclesAndVehiclePanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        }
        );

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addARandomCar, 6);
        controlPanel.add(removeCar, 7);



        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actOnUpdate()
    {
        this.drawVehiclesAndVehiclePanel.addImagesToCars(vehicles);
        this.drawVehiclesAndVehiclePanel.repaint();
    }
}