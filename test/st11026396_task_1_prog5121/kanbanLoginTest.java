/*
Leonard Bester
ST10026396
PROG5121
Task 1
*/
package st11026396_task_1_prog5121;

import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class kanbanLoginTest // Start of kanbanLoginTest class
{
    kanbanLogin login;
    
    public kanbanLoginTest()
    {
    }
    
    @Before
    public void setUp()
    {
        login = new kanbanLogin();
    }
    
    @After
    public void tearDown()
    {
        login = null;
    }
    
    
    
    
    //________________testCheckUserNameTrue Unit Test Start___________________//
    @Test
    public void testCheckUserNameTrue()
    {
        kanbanLogin fetch = new kanbanLogin();
        fetch.username = "kyl_1";
        
        assertTrue(fetch.checkUserName());
    }
    //________________testCheckUserNameTrue Unit Test End_____________________//
    
    
    
    
    //____________testCheckUserNameFalse Unit Test Start______________________//
    @Test
    public void testCheckUserNameFalse()
    {
        kanbanLogin fetch = new kanbanLogin();
        fetch.username = "kyle!!!!!!!!";
        
        assertFalse(fetch.checkUserName());       
    }   
    //________________testCheckUserNameFalse Unit Test End____________________//
    
    
    
    
    //________________testCheckPasswordComplexityTrue Unit Test Start_________//
    @Test
    public void testCheckPasswordComplexityTrue()
    {
        kanbanLogin fetch = new kanbanLogin();
        
        fetch.password = "Ch&&sec@ke99!";
        assertTrue(fetch.checkPasswordComplexity());
    }
    //________________testCheckPasswordComplexityTrue Unit Test End___________//
    
    
    
    
    //________________testCheckPasswordComplexityFalse Unit Test Start________//
    @Test
    public void testCheckPasswordComplexityFalse()
    {
        kanbanLogin fetch = new kanbanLogin();
        
        fetch.password = "password";
        assertFalse(fetch.checkPasswordComplexity());
    }
    //________________testCheckPasswordComplexityFalse Unit Test Ends_________//
    
    
    
    
    
    //________________testRegisterUserBothTrue Unit Test Start________________//
    @Test
    public void testRegisterUserBothTrue()
    {
    kanbanLogin fetch = new kanbanLogin();
    fetch.username = "kyl_1";
    fetch.password = "Ch&&sec@ke99!";
    String result = fetch.registerUser();
    String expected =fetch.TRUE_USERNAME+"\n"+fetch.TRUE_PASSWORD;
    
    assertEquals(expected,result);
    }
    //________________testRegisterUserBothTrue Unit Test End__________________//
    
    
    
    
    //____________testRegisterUserUsernameTrue Unit Test Start________________//
    @Test
    public void testRegisterUserUsernameTrue()
    {
    kanbanLogin fetch = new kanbanLogin();
    fetch.username = "kyl_1";
    fetch.password = "password";
    String result = fetch.registerUser();
    String expected =fetch.FALSE_PASSWORD;
    
    assertEquals(expected,result);
    }
    //____________testRegisterUserUsernameTrue Unit Test Start________________//
    
    
    
    
    //____________testRegisterUserPasswordTrue Unit Test Start________________//
    @Test
    public void testRegisterUserPasswordTrue()
    {
    kanbanLogin fetch = new kanbanLogin();
    fetch.username = "kyle!!!!!!!";
    fetch.password = "Ch&&sec@ke99!";
    String result = fetch.registerUser();
    String expected =fetch.FALSE_USERNAME;
    
    assertEquals(expected,result);
    }
    //____________testRegisterUserPasswordTrue Unit Test Start________________//
    
    
    

    //____________testRegisterUserBothFalse Unit Test Start___________________//
    @Test
    public void testRegisterUserBothFalse()
    {
    kanbanLogin fetch = new kanbanLogin();
    fetch.username = "kyle!!!!!!!";
    fetch.password = "password";
    String result = fetch.registerUser();
    String expected =fetch.FALSE_USERNAME+"\n"+fetch.FALSE_PASSWORD;
    
    assertEquals(expected,result);
    }
    //____________testRegisterUserBothFalse Unit Test Start___________________//    

    
    
    
    
    //________________testLoginUserTrue Unit Test Start_______________________//
    @Test
    public void testLoginUserTrue()
    {
        kanbanLogin fetch = new kanbanLogin();
        fetch.loginPassword = "Ch&&sec@ke99!";
        fetch.loginUsername = "kyl_1";
        fetch.username = "kyl_1";
        fetch.password = "Ch&&sec@ke99!";
        boolean result = fetch.loginUser();
        
        assertTrue(result);
    }
    //________________testLoginUserTrue Unit Test End_________________________//
    
    
    
    //________________testLoginUserFalse Unit Test Start______________________//
    @Test
    public void testLoginUserFalse()
    {
        kanbanLogin fetch = new kanbanLogin();
        fetch.loginPassword = "password";
        fetch.loginUsername = "kyle!!!!!!!!";
        fetch.username = "kyl_1";
        fetch.password = "Ch&&sec@ke99!";
        boolean result = fetch.loginUser();
        
        assertFalse(result);
    }
    //________________testLoginUserFalse Unit Test End________________________//    
   
} // End of kanbanLoginTest class




// Final Line of Program
/*_-_-_-_-_-_-_-_-_-_-_-_-_ See you next time _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-*/
