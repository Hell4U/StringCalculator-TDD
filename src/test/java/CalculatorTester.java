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

    @Test
    public void oneRandomDelimiterSeparationSum(){
        Assert.assertEquals(5,calculator.add("//;\n1;4"));
    }

    @Test
    public void oneNegativeNumberTesting(){
        try{
            calculator.add("1,4,5,-1,2");
        }catch (IllegalArgumentException e){
            Assert.assertEquals("negative not allowed: -1",e.getMessage());
        }

    }

    @Test
    public void multipleNegativeNumberTesting(){
        try{
            calculator.add("1,3,4,-2,-3");
        }catch(IllegalArgumentException e){
            Assert.assertEquals("negative not allowed: -2,-3",e.getMessage());
        }

    }

    @Test
    public void numberGreaterThan1000(){
        Assert.assertEquals(15,calculator.add("5,10,1002"));
    }

}
