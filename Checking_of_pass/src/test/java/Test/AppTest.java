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
    public void shouldAnswerWithTrue()
    {
        assertTrue(PasswordValidator.checkingPass("Sergei1!"));
        assertTrue(PasswordValidator.checkingPass("5$ASDd"));
        assertTrue(PasswordValidator.checkingPass("&fG7"));
        assertTrue(PasswordValidator.checkingPass("df&2U"));
        assertTrue(PasswordValidator.checkingPass("Of%^f5"));
    }
    @Test
    public void shouldAnswerWithFalse(){
        assertFalse(PasswordValidator.checkingPass("234`132"));
        assertFalse(PasswordValidator.checkingPass("Sergei1"));
        assertFalse(PasswordValidator.checkingPass("sergei1!"));
        assertFalse(PasswordValidator.checkingPass("sergeiY!"));
        assertFalse(PasswordValidator.checkingPass("SERGEI!4"));


    }
}
