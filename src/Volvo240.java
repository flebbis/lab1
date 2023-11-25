import java.awt.*;

public class Volvo240 extends Car
{
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.black, "Volvo240" );
    }

    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min((int)Math.round(getCurrentSpeed() + speedFactor() * amount), enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max((int)Math.round(getCurrentSpeed() - speedFactor() * amount), 0);
    }
}
