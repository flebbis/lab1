import java.awt.*;

public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected int currentDirection;
    protected int xPosition;
    protected int yPosition;


    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        xPosition = 0;
        yPosition = 0;
        currentDirection = 0;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
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

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
