import java.awt.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class test1 {

    private Saab95 saab;
    private Volvo240 volvo;

    @Before
    public void init()
    {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void turboOnTest()
    {
        this.saab.setTurboOn();
        Saab95 saab1 = new Saab95();

        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
            saab1.gas(1);
        }

        assertTrue(saab1.currentSpeed != saab.currentSpeed);
    }

    @Test
    public void turboOffTest()
    {

        this.saab.setTurboOn();
        this.saab.setTurboOff();
        Saab95 saab1 = new Saab95();

        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
            saab1.gas(1);
        }

        assertTrue(saab1.currentSpeed == saab.currentSpeed);
    }

    @Test
    public void gasVolvoTest()
    {
        this.volvo.gas(1);
        assertTrue(1.25 == this.volvo.getCurrentSpeed());
    }

    @Test
    public void brakeVolvoTest()
    {
        for (int i = 0; i < 10; i++){
            this.volvo.gas(1);
        }
        this.volvo.brake(1);
        assertTrue(11.25 == this.volvo.currentSpeed);
    }

    @Test //Should work, doesn't.
    public void gasSaabTest()
    {
        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
        }
        assertTrue(12.5 == this.saab.currentSpeed);
    }

    @Test
    public void brakeSaabTest()
    {
        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
        }
        this.saab.brake(1);
        assertTrue(11.25 == this.saab.currentSpeed);
    }

    @Test
    public void getEngineTest() {

        assertTrue(volvo.getEnginePower() == 100);
    }

    @Test
    public void getNrDoorsTest() {

        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void startEngineTest() {
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void setColorTest(){
        volvo.setColor(Color.blue);
        assertTrue(volvo.getColor() == Color.blue);
    }


    @Test
    public void moveNegativeXTest()
    {
        saab.turnLeft();
        saab.startEngine();
        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
        }
        saab.move();
        assertTrue(saab.xPosition == -(saab.getCurrentSpeed()));
    }

    @Test
    public void movePosXTest()
    {
        saab.turnRight();
        saab.startEngine();
        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
        }
        saab.move();
        assertTrue(saab.xPosition == saab.getCurrentSpeed());
    }
    @Test
    public void moveNegativeYTest()
    {
        saab.turnLeft();
        saab.turnLeft();
        saab.startEngine();
        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
        }
        saab.move();
        assertTrue(saab.yPosition == -(saab.getCurrentSpeed()));
    }

    @Test
    public void movePosYTest()
    {
        for (int i = 0; i < 10; i++)
        {
            this.saab.gas(1);
        }
        saab.move();
        assertTrue(saab.yPosition == (saab.getCurrentSpeed()));
    }
    @Test
    public void brakeNegSpeed()
    {
        saab.brake(1);
        assertTrue(saab.currentSpeed == 0);
    }
    @Test
    public void brakeOutOfRange()
    {
        saab.brake(1.5);
    }
    @Test
    public void gasOutOfRange()
    {
        saab.gas(1.5);
    }
    @Test
    public void gasBigSpeed()
    {
        while (saab.currentSpeed < saab.enginePower)
        {
            saab.gas(1);
        }
        saab.gas(1);
        saab.gas(1);
        saab.gas(1);
        assertTrue(saab.currentSpeed <= saab.enginePower);

    }
}
