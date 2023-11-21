import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage[] vehicleImages = new BufferedImage[3];
    // To keep track of a single cars position
    Point vehiclePoint = new Point();
    String fileName;

    // TODO: Make this general for all cars
    void moveit(int x, int y, Vehicle vehicle){
        vehicle.setxPosition(x);
        vehicle.setyPosition(y);
        vehiclePoint.x = x;
        vehiclePoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles) { //TODO: Fixa så att bilderna fixas och flyttningen av bilen fixas.
//         String fileName = "pics/" + vehicle.getModelName() + ".jpg";
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block
        try {
            // Remember to right-click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            System.out.println("Case file is not found");
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
    }
}
