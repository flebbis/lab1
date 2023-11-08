import java.awt.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class test1 {

    private Saab95 saab;
    private Volvo240 volvo;

    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void turboOnTest() {

        this.saab.setTurboOn();
        this.saab.gas(10);

        Saab95 saab1 = new Saab95();
        saab1.gas(10);

        assertTrue(saab1.currentSpeed != saab.currentSpeed);
    }

    @Test
    public void turboOffTest() {

        this.saab.setTurboOn();
        this.saab.setTurboOff();

        this.saab.gas(10);

        Saab95 saab1 = new Saab95();

        saab1.gas(10);

        assertTrue(saab1.currentSpeed == saab.currentSpeed);
    }

    @Test
    public void gasVolvoTest(){
        this.volvo.gas(10);
        assertTrue(12.5 == this.volvo.getCurrentSpeed());
    }

    @Test
    public void brakeVolvoTest(){
        this.volvo.brake(10);
        assertTrue(0 == this.volvo.currentSpeed);
    }

    @Test //Should work, doesn't.
    public void gasSaabTest(){
        this.saab.gas(10);
        assertTrue(12.5 == this.saab.currentSpeed);
    }

    @Test
    public void brakeSaabTest(){
        this.saab.brake(10);
        assertTrue(-12.5 == this.saab.currentSpeed);
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
        saab.gas(10);
        saab.move();
        System.out.println(saab.xPosition);
        System.out.println(-(saab.getCurrentSpeed()));
        assertTrue(saab.xPosition == -(saab.getCurrentSpeed()));
    }

    @Test
    public void movePosXTest()
    {
        saab.turnRight();
        saab.startEngine();
        saab.gas(10);
        saab.move();
        assertTrue(saab.xPosition == saab.getCurrentSpeed());
    }
    @Test
    public void moveNegativeYTest()
    {
        saab.turnLeft();
        saab.turnLeft();
        saab.startEngine();
        saab.gas(10);
        saab.move();
        assertTrue(saab.yPosition == -(saab.getCurrentSpeed()));
    }

    @Test
    public void movePosYTest()
    {
        saab.gas(10);
        saab.move();
        assertTrue(saab.yPosition == (saab.getCurrentSpeed()));
    }

}
