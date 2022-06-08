/*
Leonard Bester
ST10026396
PROG5121
Task 1
*/
package st11026396_task_1_prog5121;

import javax.swing.JOptionPane;

public class kanbanLogin  // Start of kanbanLogin Class       
{
    
    
    // Declaring variables to store user input
    public String name, surname, username, password,loginUsername,loginPassword;
 
    // Declaring and setting constants
    final String TRUE_USERNAME = "Username successfully captured";
    final String FALSE_USERNAME = "Username is not correctly formatted,"
                                 + " please ensure that your username"
                                 + " contains an underscore and is no more"
                                 + " than 5 characters in length";
    final String TRUE_PASSWORD = "Password successfully captured";
    final String FALSE_PASSWORD = "Password is not correctly formatted,"
                                    + " please ensure that the password contains"
                                    + " at least 8 characters, a capital letter,"
                                    + " a number and a special character";
    final String ENTER_USERNAME_PROMPT ="Enter your username for registration"+"\n\n Must contain an underscore "+
                                    "\n Can not be longer than 5 characters";
    final String ENTER_PASSWORD_PROMPT = "Enter your password for registration"+"\n\n At least 8 characters long"
                                           +"\n Contain a capital letter"+"\n Contain a number"+"\n Contain a special character";
    
    
    
    public kanbanLogin()
    {
        // default constructor
    }
    
    
    
    
    //____________________inputUserDetails Method Start_______________________//
    public void inputUserDetails()
    {
         // Welcoming user with text message
        JOptionPane.showMessageDialog(null, "Welcome to Kanban ","welcome",1);
        
        // Inputting user's name and surname
        name = JOptionPane.showInputDialog(null,"Enter your name for registration.","Register",3);
        surname = JOptionPane.showInputDialog(null,"Enter your surname for registration.","Register",3); 
        
        // Inputing username variable from user
        username = JOptionPane.showInputDialog(null,ENTER_USERNAME_PROMPT,"Register",3);
        
        // Inputting users password
        password = JOptionPane.showInputDialog(null,ENTER_PASSWORD_PROMPT,"Register",3);   
        
        registerOutput();
    }
    //____________________inputUserDetails Method end_________________________//
    
    
    
    
    //____________________checkUserName Method Start__________________________//
    public boolean checkUserName()
    {
        int usernameLength;
        boolean underscore = false;
        
        // Finding the length of name variable
        usernameLength = username.length();
        
        // Checking every character of string to find an underscore
        if (username.contains("_"))
            underscore = true;
        
        
        // Checking if username meets all condtions
        if ((usernameLength <= 5) && (underscore))
            return(true);
        else
            return(false); 
    }
    //____________________checkUserName Method end____________________________//
    
    
    
    
    //____________________checkPasswordComplexity Method Start________________//
    public boolean checkPasswordComplexity()
    {
        int passwordLength;
        boolean specialCharacter = false;
        boolean number = false;
        boolean capitalLetter = false;
        boolean length = false;
        char inspect;
    
             // Finding the length of password
            passwordLength = password.length();
        
            // Checking each character in password for a capital letter
            for (int loop = 0; loop < passwordLength; loop++)
            {
                inspect = password.charAt(loop);
            
                if (Character.isUpperCase(inspect))           
                    capitalLetter = true;                                    
            }
        
            // Checking each character in password for a digit
            for (int loop = 0; loop < passwordLength; loop++)
            {
                inspect = password.charAt(loop);
            
                if (Character.isDigit(inspect))        
                    number = true;
            }
        
            // Checking each character in password is not a digit, letter or empty space
            for (int loop = 0; loop < passwordLength; loop++)
            {
                inspect = password.charAt(loop);
          
                if (!Character.isDigit(inspect) && !Character.isLetter(inspect) && !Character.isSpace(inspect))            
                    specialCharacter = true;
            }
            
            // Checking the length of the password
            if (passwordLength >= 8)
                length = true;
                
            
            // Checking to see if all conditions are met and returning result
            if (length && capitalLetter && number && specialCharacter)       
                return(true);
            else
                return(false);
    }
    //____________________checkPasswordComplexity Method end__________________//
    
    
    
    
    //____________________registerUser Method Start___________________________//
    public String registerUser()
    {   
        String registerStatus = "x";
        
        // Using if statements anc calling previous methods to determine the output variable
        // for the register status of the user
        
        if (checkUserName() && checkPasswordComplexity())
        {
            registerStatus = TRUE_USERNAME+"\n"+TRUE_PASSWORD;
        }
        
        if (checkUserName() && !checkPasswordComplexity())
        {
            registerStatus = FALSE_PASSWORD;
        }
        
        if (!checkUserName() && checkPasswordComplexity())
        {
            registerStatus = FALSE_USERNAME;
        }      
        
        if (!checkUserName() && !checkPasswordComplexity())
        {
            registerStatus = FALSE_USERNAME+"\n"+FALSE_PASSWORD;
        }        
        
        
        return(registerStatus);
    }
    //____________________registerUser Method end_____________________________//
    
    
    
    
    //____________________registerOutput Method Start_________________________//
    public void registerOutput()
    {
        // Calling the registerUser method to return the string
        String registerOutput = registerUser();
        JOptionPane.showMessageDialog(null, registerOutput);
        // Checking for registration failure and if so calling inputUserDetails
        if (registerOutput.equals(FALSE_USERNAME) || registerOutput.equals(FALSE_PASSWORD) || registerOutput.equals(FALSE_USERNAME+"\n"+FALSE_PASSWORD)) 
            inputUserDetails();
        else
           loginCapture();
    }
    //____________________registerOutput Method Start_________________________//
    
    
    
    
    //____________________loginCapture Method Start___________________________//
    public void loginCapture()
    {
        // Capturing the login details
        loginUsername = JOptionPane.showInputDialog(null,"Enter your username for login","Login",3);
        loginPassword = JOptionPane.showInputDialog(null,"Enter your password for login","Login",3); 
        returnLoginStatus();
    }
    //____________________loginCapture Method end_____________________________//
    
    
    
    
    //____________________loginStatus Method Start____________________________//
    public boolean loginUser()
    {
        boolean successStatus;
        // Comparing the login details with the register details
        if (loginUsername.equals(username) && loginPassword.equals(password))
            successStatus = true;
        else
            successStatus = false;
            
        return(successStatus);
    }
    //____________________loginStatus Method end______________________________//
    
    
    
    
    //____________________LoginStatusOutput Method Start______________________//    
    public void returnLoginStatus()
    {   
        // Outputing the result of the loginUser method and if failed the loginCapture will try again
        if (loginUser())
            JOptionPane.showMessageDialog(null,"Welcome "+name+", "+surname+" it is great to see you again.");
        else
        {
            JOptionPane.showMessageDialog(null,"Username or password incorrect, please try again");
            loginCapture();
        }
        
    }
    //____________________LoginStatusOutput Method End______________________//
        
    
} // end of kanbandClass




// Final Line of Program
/*_-_-_-_-_-_-_-_-_-_-_-_-_ See you next time _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-*/