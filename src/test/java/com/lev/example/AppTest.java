package com.lev.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.lev.example.util.MyPasswordValidator;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrueAndFalse()
    {

        assertTrue(MyPasswordValidator.checkingPass("SergeiIs1!"));

        assertFalse(MyPasswordValidator.checkingPass("Serg!4"));//Less than 8 symbols
        assertFalse(MyPasswordValidator.checkingPass("Sergeasdi1"));//No special symbol
        assertFalse(MyPasswordValidator.checkingPass("sergeasfi1!"));// No Upcase Char
        assertFalse(MyPasswordValidator.checkingPass("sergeasdiY!"));//No Digit
        assertFalse(MyPasswordValidator.checkingPass("SERGEZSADI!4"));//No Downcase Char
    }

}
