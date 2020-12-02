package bean;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormulaTest {
    Formula formula ;
    @Before
    public void setUp() throws Exception {
        formula = new Formula(1,50,30);
    }

    @Test
    public void getOp() {
        assertEquals(formula.getOp(),1);
    }

    @Test
    public void getA() {
        assertEquals(formula.getA(),50);
    }

    @Test
    public void getB() {
        assertEquals(formula.getB(),30);
    }

    @Test
    public void getAns() {
        formula.setAns(formula.getA()+formula.getB());
        assertEquals(formula.getAns(),80);
    }
}