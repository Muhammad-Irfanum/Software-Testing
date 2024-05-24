/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.palindromcheck.PalindromeCheck;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author irfan
 */
public class PalindeomJUnitTest {
    
    public PalindeomJUnitTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }



    @Test
    public void testPalindrome() {
        
//         assertTrue(PalindromeCheck.isPalindrome("madam"));                       
        assertTrue(PalindromeCheck.isPalindrome(""));                      
        assertTrue(PalindromeCheck.isPalindrome("12321"));            
    }

        


}
