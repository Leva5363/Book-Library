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
        assertFalse(PasswordValidator.checkingPass("Sergei1"));//No special symbol
        assertFalse(PasswordValidator.checkingPass("sergei1!"));// No Upcase Char
        assertFalse(PasswordValidator.checkingPass("sergeiY!"));//No Digit
        assertFalse(PasswordValidator.checkingPass("SERGEI!4"));//No Downcase Char
    }

}
