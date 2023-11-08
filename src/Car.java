import java.awt.*;

public abstract class Car implements Movable
{
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected int currentDirection;
    protected double xPosition;
    protected double yPosition;


    protected Car(int nrDoors, double enginePower, Color color, String modelName)
    {
        xPosition = 0;
        yPosition = 0;
        currentDirection = 0;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        setColor(color);
        stopEngine();
    }

    @Override
    public void move()
    {

        switch (((currentDirection % 4) + 4) % 4)
        {
            case 0:
                yPosition += currentSpeed;
                break;
            case 1:
                xPosition += currentSpeed;
                break;
            case 2:
                yPosition -= currentSpeed;
                break;
            case 3:
                xPosition -= currentSpeed;
                break;
        }
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

    public void gas(double amount)
    {
        if (amount > 0 && amount <= 1)
        {
            incrementSpeed(amount);        //checks if this surpasses the range
            if (currentSpeed > enginePower)
            {
                decrementSpeed(amount);
            }
        }
        else
        {
            System.out.println("Amount out of range");
        }
    }

    public void brake(double amount)
    {
        if (amount > 0 && amount <= 1)
        {
            decrementSpeed(amount);    //checks if this surpasses the range
            if (currentSpeed < 0)
            {
                incrementSpeed(amount);
            }
        }
        else
        {
            System.out.println("Amount out of range");
        }
    }
}
