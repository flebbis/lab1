import java.awt.*;

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

        this.saab.setTurboOff();

        this.saab.gas(10);


    }

    @Test //Should work, doesn't.
    public void gas(){
        this.saab.gas(10);
        assertEquals(12.5,this.saab.currentSpeed);
    }

    @Test
    public void brake(){
        this.saab.brake(10);
        assertEquals(-12.5,this.saab.currentSpeed);
    }

}
