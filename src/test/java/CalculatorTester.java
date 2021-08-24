import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTester {
    Calculator calculator ;

    @Before
    public void init(){
        calculator=new Calculator();
    }

    @Test
    public void emptyStringTest(){
        Assert.assertEquals(0,calculator.add(""));
    }

    @Test
    public void singleValueString(){
        Assert.assertEquals(4,calculator.add("4"));
    }
}
