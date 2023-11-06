import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    private Volvo240(){
        super(4, 100, Color.black, "Volvo240" );
    }


    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
