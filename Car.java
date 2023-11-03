import java.awt.*;

public abstract class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    public int currentDirection;
    public int xPosition;
    public int yPosition;


    public Car(int nrOfDoors, double enginePow, Color colour, String nameOfCar) {
        xPosition = 0;
        yPosition = 0;
        currentDirection = 0;
        nrDoors = nrOfDoors;
        enginePower = enginePow;
        color = colour;
        modelName = nameOfCar;
        stopEngine();
    }

    @Override
    public void move()
    {
        if (currentDirection % 4 == 0)
            yPosition += currentSpeed;
        else if (currentDirection % 4 == 2)
            yPosition -= currentSpeed;
        else if (currentDirection % 4 == 1)
            xPosition += currentSpeed;
        else
            xPosition -= currentSpeed;
    }



    @Override
    public void turnRight() {
        currentDirection += 1;
    }

    @Override
    public void turnLeft() {
        currentDirection -= 1;
    }


    private int getNrDoors(){
        return nrDoors;
    }
    private double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    private Color getColor(){
        return color;
    }

    private void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }



    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}

