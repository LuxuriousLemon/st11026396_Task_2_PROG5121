/*
Leonard Bester
ST10026396
PROG5121
Task 2
*/
package st11026396_task_1_prog5121;

import javax.swing.JOptionPane;
import st11026396_task_1_prog5121.kanbanLogin;

public class kanbanTasks
{
    
    // Declarations of variables
    String taskName,taskDescription,taskStatus, taskDuration,developerSurname, developerName;
    int taskAmount, taskStatusChoice, taskNumber = 0, taskLoop =0;
    
    String[][] arrayTasks = new String[20][7];
    
    
    kanbanLogin fetch = new kanbanLogin();
    
    
    // Declarations of constants
    final String TASK_DURATION_ERROR = "Please enter digits for Task Duration";
    final String TASK_DESCRIPTION_ERROR = "Please enter a task description of less than 50 words";
    final String TASK_STATUS_ERROR = "Please enter a valid task status";
    final String TASK_AMOUNT = "Enter the amount of tasks you would like to create";
    final String TASK_VALIDITY = "Task successfully captured";

    
    
    public kanbanTasks()
    {
        // default constructor
    }   
    
    public void userWelcome()
    {
       String userGreeting = "Welcome to EasyKanban";

        // Greeting the user
        JOptionPane.showMessageDialog(null,userGreeting );    
        taskChoice();
    }
    
    
    //____________________taskChoice Method Start_____________________________//    
    public void taskChoice()
    {
        // Declarations
        String taskChoiceError = "Please enter a valid choice in Task Choice selection",
        taskPrompt = "To add a task press 1"+"\n\n To show report press 2 - Feature Coming Soon "+"\n\n To exit press 3";
                

        boolean choiceVerification = false;
        

        
        // Using an input dialog box to capture the users choice
        int taskChoice = Integer.parseInt(JOptionPane.showInputDialog(null,taskPrompt,"TASKS",3));
        
        // Checking to see if user inputs acceptable input
        if ((taskChoice == 1)||(taskChoice == 3)) 
                choiceVerification = true;
        
        // If there is unacceptable input the user is prompted to start again
        if ((!choiceVerification)||(taskChoice == 2))
        {
            JOptionPane.showMessageDialog(null,taskChoiceError);
            taskChoice();            
        }

        // Checking which choice was made and calling the corresponding method
       switch(taskChoice)
       {
           case 1:
               taskAmounts();
               break;
           case 3:
               quiteTask();
               break;
       }   
    }
    //____________________taskChoice Method End_______________________________// 

    
    
    
    //____________________testAmount Method Start_____________________________//
    public void taskAmounts()
    {
        taskAmount = Integer.parseInt(JOptionPane.showInputDialog(null,TASK_AMOUNT,"TASK AMOUNT",2));
        taskLoop();
    }
    //____________________testAmount Method End_______________________________//



    
    //____________________taskLoopMethod Start________________________________//     
    public void taskLoop()
    {
        for (int loop = taskLoop; loop < taskAmount; loop++)
        {
            inputTask();
        }
        printTotalHours();
    }
    //____________________taskLoopMethod Start________________________________// 

    
    
    //____________________returnTotalHours Method Start_______________________//
    public int returnTotalHours()
    {
        int totalHours = 0;
        String findHours;
        
        for (int outer = 0; outer < taskAmount; outer++)
        {
            totalHours = totalHours + Integer.parseInt(arrayTasks[outer][6]);
        }
        
        return(totalHours);
    }
    //____________________returnTotalHours Method End_________________________//
    
    
    
    
    //____________________printTotalHours Method Start________________________//
    public void printTotalHours()
    {
        int totalHours = returnTotalHours();
        String displayOutput = "The total amount of hours required for all tasks to be completed is "
                                +"\n\n"+totalHours+" hours";
        JOptionPane.showMessageDialog(null,displayOutput);
        
        taskChoice();
    }
    //____________________printTotalHours Method End__________________________//
    
    
    
    
    //____________________inputTask Method Start______________________________//
    public void inputTask()
    {
            String taskChoice = "Enter the task status \n\n"+"Press 1 to enter 'To Do' \n\n"+" Press 2 to enter 'Doing' \n\n"
                                + "Press 3 to enter 'Done'";    
            String taskDurationPrompt = "Enter the amount of estimated time the task requirs or required to complete in hours";
            String developerNamePrompt = "Enter the developer's name";
            String developerSurnamePrompt = "Enter the developer's surname";
            String taskDescriptionPrompt = "Enter the task description";
            String taskNamePrompt = "Enter the task name";

        
       // Inputing users details for the task being created
        taskName = JOptionPane.showInputDialog(null,taskNamePrompt,"NAME",3);
        developerName = JOptionPane.showInputDialog(null,developerNamePrompt,"DEVELOPER NAME",3);
        developerSurname = JOptionPane.showInputDialog(null,developerSurnamePrompt,"DEVELOPER NAME",3);
        taskDescription = JOptionPane.showInputDialog(null,taskDescriptionPrompt,"DESCRIPTION",3);
        taskDuration = JOptionPane.showInputDialog(null,taskDurationPrompt,"DURATION",3);
        taskStatusChoice = Integer.parseInt(JOptionPane.showInputDialog(null,taskChoice,"STATUS",3));
        validateTaskInput();
    }
    //____________________inputTask Method End________________________________//  
    
    
    
    
    //____________________createTaskID Method Start___________________________//   
    public String createTaskID()
    {
        // Declarations
        String taskID,lastThreeLettersName;
        char firstLetter, secondLetter;
        int nameLength;
        
        // Setting first two characters of taskName
        firstLetter = taskName.charAt(0);
        secondLetter = taskName.charAt(1);
        
        nameLength = developerName.length();
        
        // Finding the last three letters of developer name
        lastThreeLettersName = (Character.toString(developerName.charAt(nameLength-3)))
                                + (Character.toString(developerName.charAt(nameLength-2)))
                                + (Character.toString(developerName.charAt(nameLength-1)));
        
        // Building the taskID string
        taskID = Character.toString(firstLetter).toUpperCase() + Character.toString(secondLetter).toUpperCase()+":"+taskNumber+":"+lastThreeLettersName.toUpperCase();
        
        // Returning string value
        return(taskID);
    }
    //____________________createTaskID Method Start___________________________//  
    
    
    
    
    //____________________checkTaskStatus Method Start________________________//     
    public boolean checkTaskStatus()
    {
        // Declarations
        boolean statusChoice = false;
        
        // Checking if the user's input is acceptable
        if ((taskStatusChoice > 0) || (taskStatusChoice < 4))
        {
            statusChoice = true;
            
            switch(taskStatusChoice)
            {
                case 1:
                    taskStatus = "To Do";
                    break;
                    
                case 2:
                    taskStatus = "Doing";
                    break;
                    
                case 3: 
                    taskStatus = "Done";
                    break;
            }
        }
        
        // Returning the result boolean
        return(statusChoice);
    }
    //____________________checkTaskStatus Method End__________________________//
    
    
    
    
    //____________________checkTaskDuration Method Start______________________//    
    public boolean checkTaskDuration()
    {
        // Declarations
        boolean durationValid = false;
        // Checking if the first two values of the duration are digits
        if ((Character.isDigit(taskDuration.charAt(0))))
            durationValid = true;
        
        // Returning the result boolean
        return(durationValid);
    }
    //____________________checkTaskDuration Method End________________________//     
    
    
    
    
   //_________________checkTaskDescription Method Start_______________________//
   public boolean checkTaskDescription()
   {
       // Declarations
       boolean taskDescriptionValidation = true;
       
       // finding the length of testDescriptions
       int length = taskDescription.length();
       
       // Checking  if task description is smaller than 50 characters
       if (length > 50)
           taskDescriptionValidation = false;
       
       // Returning the result boolean
       return(taskDescriptionValidation);
   }
   //____________________checkTaskDescription Method End______________________//  
   
   
   
   
   //____________________validateTaskInputStatus Method Start_________________//   
   public String validateTaskInputStatus()
   {
      // Declarations
       String taskInputValidity = "x";
       
       // Using if statements to detirmine which checks have failed
       if ((!checkTaskStatus())&&(checkTaskDescription())&&(checkTaskDuration()))
            taskInputValidity = TASK_STATUS_ERROR;
       
       
       if ((!checkTaskStatus())&&(!checkTaskDescription())&&(checkTaskDuration()))
            taskInputValidity = TASK_STATUS_ERROR + "\n" + TASK_DESCRIPTION_ERROR;
       
       
       if ((!checkTaskStatus())&&(!checkTaskDescription())&&(!checkTaskDuration()))
            taskInputValidity = TASK_STATUS_ERROR + "\n" + TASK_DESCRIPTION_ERROR + "\n" + TASK_DURATION_ERROR;
              
       
       if ((checkTaskStatus())&&(!checkTaskDescription())&&(!checkTaskDuration()))
            taskInputValidity = TASK_DURATION_ERROR + "\n" + TASK_DESCRIPTION_ERROR;
              
       
       if ((checkTaskStatus())&&(checkTaskDescription())&&(!checkTaskDuration()))
              taskInputValidity = TASK_DURATION_ERROR;
            
       
       if ((checkTaskStatus())&&(checkTaskDescription())&&(checkTaskDuration()))
           taskInputValidity = TASK_VALIDITY;
       // returning string
       return(taskInputValidity);
   }
   //____________________validateTaskInputStatus Method End___________________//     
    
   
    //____________________validateTaskInput Method Start______________________//  
    public void validateTaskInput()
    {
        String validateResult = validateTaskInputStatus();
        
        if ((validateResult.equals(TASK_STATUS_ERROR))||(validateResult.equals(TASK_STATUS_ERROR + "\n" + TASK_DESCRIPTION_ERROR))
                ||(validateResult.equals(TASK_STATUS_ERROR + "\n" + TASK_DESCRIPTION_ERROR + "\n" + TASK_DURATION_ERROR))
                ||(validateResult.equals(TASK_DURATION_ERROR + "\n" + TASK_DESCRIPTION_ERROR))
                ||(validateResult.equals(TASK_DURATION_ERROR)))
        {
            JOptionPane.showMessageDialog(null,validateResult);
            inputTask();
        }
        
        if (validateResult.equals(TASK_VALIDITY))
        {
            JOptionPane.showMessageDialog(null,TASK_VALIDITY);
            insertTask();
        }
    }
    //____________________validateTaskInput Method End________________________//   
    
    
    //____________________insertTask Method Start_____________________________//    
    public void insertTask()
    {
        
        String taskID = createTaskID();
        // Inserting the taskInformation into the task array
        arrayTasks[taskNumber][0] = taskStatus;
        arrayTasks[taskNumber][1] = developerName +" " +developerSurname;
        arrayTasks[taskNumber][2] ="Task Number: "+ String.valueOf(taskNumber);
        arrayTasks[taskNumber][3] = taskName;
        arrayTasks[taskNumber][4] = taskDescription;
        arrayTasks[taskNumber][5] = taskID;
        arrayTasks[taskNumber][6] = taskDuration;
        
        // Returning the string
        displayTaskDetails();
    }
    //____________________insertTask Method End_______________________________//  
    
    
    
    
    //____________________printTaskDetails Method Start_______________________//    
    public String printTaskDetails()
    {
        // Declarations
        String taskDetails = "";
        
        // Using a for loop to build a string that contains all the task details
        for (int outer = 0; outer < 1; outer++)
        {
            for (int inner = 0; inner < 7; inner++)
            {
                taskDetails = taskDetails+"\n"+arrayTasks[outer][inner];
            }
        }
        // Returning the string
        return(taskDetails);
    }
    //____________________printTaskDetails Method End_________________________//  
    
    
    
    
   //____________________displayTaskDetails Method Start______________________//   
   public void displayTaskDetails()
   {
       // Declarations
       int taskDisplayNumber = taskNumber;
       
       // Displaying the task details
       JOptionPane.showMessageDialog(null,"These are the task details you entered for "+taskDisplayNumber+"\n\n"+printTaskDetails());
       
        // Incrementing the task number variables
        taskNumber++; 
        taskLoop++;
        taskLoop();
   }
   //____________________displayTaskDetails Method Start______________________//    
    
   
   
   
    //____________________createTask Method Start_____________________________//
    public void quiteTask()
    {
        System.exit(0);
    }
    //____________________createTask Method End_______________________________//       
}

