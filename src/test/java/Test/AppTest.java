package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest


{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrueAndFalse()
    {

        assertTrue(PasswordValidator.checkingPass("SergeiIs1!"));

        assertFalse(PasswordValidator.checkingPass("Serg!4"));//Less than 8 symbols
        assertFalse(PasswordValidator.checkingPass("Sergeasdi1"));//No special symbol
        assertFalse(PasswordValidator.checkingPass("sergeasfi1!"));// No Upcase Char
        assertFalse(PasswordValidator.checkingPass("sergeasdiY!"));//No Digit
        assertFalse(PasswordValidator.checkingPass("SERGEZSADI!4"));//No Downcase Char
    }

}
