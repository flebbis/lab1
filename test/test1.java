import java.awt.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class test1
{

    private Saab95 saab;
    private Volvo240 volvo;
    private Scania scania;
    private AutomobileTransport loader;

    @Before
    public void init()
    {
        saab = new Saab95();
        volvo = new Volvo240();
        scania = new Scania();
        loader = new AutomobileTransport();
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
    public void getEngineTest()
    {

        assertTrue(volvo.getEnginePower() == 100);
    }

    @Test
    public void getNrDoorsTest()
    {

        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void startEngineTest()
    {
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void setColorTest()
    {
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
        assertTrue(saab.currentSpeed == 0);
    }

    @Test
    public void gasOutOfRange()
    {
        saab.gas(1.5);
        assertTrue(saab.currentSpeed == 0);
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

    @Test
    public void getxPositionTest()
    {
        assertTrue(saab.getxPosition() == 0);
    }

    @Test
    public void getYPositionTest()
    {
       assertTrue(saab.getyPosition() == 0);
    }

    @Test
    public void tiltUpFlatbedTest()
    {
        scania.flatbedUp(75);
        scania.flatbedUp(30);
        assertTrue(scania.getCurrentDegree() == 30);
    }
    @Test
    public void tiltUpFlatbedTestFail()
    {
        scania.flatbedUp(65);
        scania.incrementSpeed(0.5);
        assertTrue(scania.getCurrentSpeed() == 0);
    }
    @Test
    public void tiltDownFlatbedTest()
    {
        scania.flatbedUp(45);
        scania.flatbedDown(30);
        assertTrue(scania.getCurrentDegree() == 15);
    }
    @Test
    public void incrementSpeedScaniaTest()
    {
        scania.gas(1);
        System.out.println(scania.getCurrentSpeed());
        assertTrue(scania.getCurrentSpeed() == scania.speedFactor());
    }
    @Test
    public void decrementSpeedScaniaTest()
    {
        scania.gas(1);
        scania.gas(1);
        scania.brake(1);
        System.out.println(scania.getCurrentSpeed());
        assertTrue(scania.getCurrentSpeed() == 4);
    }
    @Test
    public void loadTest()
    {
        loader.currentDegree = 70; //så vi kan lasta
        loader.load(saab);
        System.out.println(loader.storage[0]);
        assertTrue(loader.storage[0] == saab);
    }

    @Test
    public void flatbedChange()
    {
        loader.flatbedChange(true);
        loader.flatbedChange(false);
        loader.flatbedChange(true);
        assertTrue(loader.currentDegree == 70);
    }

    @Test
    public void unloadTest()
    {
        loader.flatbedChange(true);
        loader.load(saab);
        System.out.println(loader.storage[0]);
        loader.unload();
        System.out.println(loader.storage[0]);
        assertTrue(loader.storage[0] == null);
    }
    @Test
    public void getStorageTest()
    {
        loader.load(saab);
        assertTrue(loader.getStorage() == loader.storage);
    }

    @Test
    public void moveNegativeXTestAutomobile()
    {
        loader.flatbedChange(true);
        loader.load(saab);
        loader.load(volvo);
        loader.turnLeft();
        loader.startEngine();
        for (int i = 0; i < 10; i++)
        {
            this.loader.gas(1);
        }
        loader.move();
        System.out.println(loader.xPosition);
        System.out.println(saab.xPosition);
        assertTrue(saab.getxPosition() == loader.xPosition);
    }

    @Test
    public void movePosXTestAutomobile()
    {
        loader.turnRight();
        loader.startEngine();
        for (int i = 0; i < 10; i++)
        {
            this.loader.gas(1);
        }
        loader.move();
        assertTrue(loader.xPosition == loader.getCurrentSpeed());
    }

    @Test
    public void moveNegativeYTestAutomobile()
    {
        loader.turnLeft();
        loader.turnLeft();
        loader.startEngine();
        for (int i = 0; i < 10; i++)
        {
            this.loader.gas(1);
        }
        loader.move();
        assertTrue(loader.yPosition == -(loader.getCurrentSpeed()));
    }

    @Test
    public void movePosYTestAutomobile()
    {
        for (int i = 0; i < 10; i++)
        {
            this.loader.gas(1);
        }
        loader.move();
        assertTrue(loader.yPosition == (loader.getCurrentSpeed()));
    }

    @Test
    public void scaniarampchangewhenmovetest()
    {
        scania.gas(1);
        scania.flatbedUp(70);
    }

}
