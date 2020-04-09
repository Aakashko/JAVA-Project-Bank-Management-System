package bank.transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;  
public class Update
{   
	
	
	public void UpdateUser()
	{

		
		Scanner scan=new Scanner(System.in);
		int choice=0;
		System.out.println("Enter your choice for  Update : ");
		System.out.println("1. Account Holder Name");
		System.out.println("2. Contact Number");
		System.out.println("3. Pin Number");
		System.out.println("4. Exit");
		choice=scan.nextInt();
		
		switch(choice)
		{
		case 1:
			String Oldname=new String();
			String Newname=new String();
			System.out.println("Enter the user name : ");
			Oldname=scan.next();
			System.out.println("Enter the updated user name : ");
			Newname=scan.next();
			Name(Oldname,Newname);
			break;
		case 2:
			String Oldname1=new String();
			String Oldname2=new String();
			String Newname1=new String();
			System.out.println("Enter the user name : ");
			Oldname1=scan.next();
			System.out.println("Enter the old contact no. of the user : ");
			Oldname2=scan.next();
			System.out.println("Enter the updated contact no. of the user : ");
			Newname1=scan.next();
			Contact(Oldname2,Newname1);
			break;
		case 3:
			String Oldname3=new String();
			String Oldname4=new String();
			String Newname3=new String();
			System.out.println("Enter the user name : ");
			Oldname3=scan.next();
			System.out.println("Enter the old pin no. of the user : ");
			Oldname4=scan.next();
			System.out.println("Enter the updated pin no. of the user : ");
			Newname3=scan.next();
			Pin(Oldname4,Newname3);
			break;
		case 4:
			break;
			
			default :
				System.out.println("Oops! You have entered wrong choice....");
				break;
		}
		scan.close();
	}

     void Name( String oldString, String newString)
    {
    	 
    	 
    	 String filePath="userdetails.txt";
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    	 
    	 
    	
    }
     
     
     void Contact(String oldString, String newString)
 	{

    	 String filePath="userdetails.txt";
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
 		
 	}
 	void Pin(String oldString, String newString)
 	{
 	
 		 String filePath="userdetails.txt";
         File fileToBeModified = new File(filePath);
          
         String oldContent = "";
          
         BufferedReader reader = null;
          
         FileWriter writer = null;
          
         try
         {
             reader = new BufferedReader(new FileReader(fileToBeModified));
              
             //Reading all the lines of input text file into oldContent
              
             String line = reader.readLine();
              
             while (line != null) 
             {
                 oldContent = oldContent + line + System.lineSeparator();
                  
                 line = reader.readLine();
             }
              
             //Replacing oldString with newString in the oldContent
              
             String newContent = oldContent.replaceAll(oldString, newString);
              
             //Rewriting the input text file with newContent
              
             writer = new FileWriter(fileToBeModified);
              
             writer.write(newContent);
         }
         catch (IOException e)
         {
             e.printStackTrace();
         }
         finally
         {
             try
             {
                 //Closing the resources
                  
                 reader.close();
                  
                 writer.close();
             } 
             catch (IOException e) 
             {
                 e.printStackTrace();
             }
         }
 		
 	}
}

