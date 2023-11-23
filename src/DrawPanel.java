import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

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

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        try  // Prints an error message in case file is not found with a try/catch block
        {
            for (Vehicle v : vehicles) //Dynamically inputs the correct image to the correct vehicle
            {
                v.vehicleImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + v.getModelName() + ".jpg"));
            }
        }
        catch (IOException ex)
        {
            System.out.println("Case file is not found");
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int separator = 0; //Separator separates cars along the x-axis
        for (Vehicle v : this.vehicles)
        {
            g.drawImage(v.vehicleImage, (int)Math.round(v.xPosition), (int)(Math.round(v.yPosition) + separator), null);
            separator += 200;
        }
    }
}
