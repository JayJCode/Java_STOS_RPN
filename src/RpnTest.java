package Stack;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RpnTest {
    @Test
    public void RPN1() {
        Rpn rpn = new Rpn();
        String result = rpn.RPN("2 3 +");

        assertEquals("2+3", "5", result);
    }

    @Test
    public void RPN2() {
        Rpn rpn = new Rpn();
        String result = rpn.RPN("2 7 + 3 /");

        assertEquals("(2+7)/3", "3", result);
    }

    @Test
    public void RPN3() {
        Rpn rpn = new Rpn();
        String result = rpn.RPN("5 1 2 + 4 * + 3 -");

        assertEquals("5+(1+2)*4−3", "14", result);
    }

    @Test
    public void RPN4() {
        Rpn rpn = new Rpn();
        String result = rpn.RPN("12 2 3 4 * 10 5 / + * +");

        assertEquals("12+2×(3×4+10/5)", "40", result);
    }
}
