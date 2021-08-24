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

    @Test
    public void twoValueSum(){
        Assert.assertEquals(6,calculator.add("2,4"));
    }

    @Test
    public void multiValueSum(){
        Assert.assertEquals(8,calculator.add("1,2,3,2"));
    }

    @Test
    public void twoDelimiterSeparationSum(){
        Assert.assertEquals(13,calculator.add("1,2\n6,4"));
    }

}
