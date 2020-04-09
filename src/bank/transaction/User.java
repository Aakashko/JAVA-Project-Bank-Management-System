package bank.transaction;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class User extends Operations{
	String name,actype,ac,contact,pass;
	float  amnt;
	Scanner scan=new Scanner(System.in);
	
	
	public void NewUser() 
	{
		int c=0;
		String line;
		String lread;
		char nm[]=new char[6];
		
		System.out.println("\t\tEnter your Details\n");
		System.out.println("******************************************");
		
		try {
			PrintWriter outs=new PrintWriter(new FileWriter("userdetails.txt",true));
			BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
		     
			
			do
			{
				c=0;
				System.out.println("Please enter your full name");
				name=scan.nextLine().trim();
				
				if(name.length()<3)
				{
					System.out.println("\n Name should be greater than 2 characters");
					c++;
					
				}
				else if(name.matches(".*?[\\{Punct}&&[^_]].*")||name.matches("[a-zA-Z]"))
				{
					System.out.println("\n Enter a valid name....");
					c++;
				}
			}while(c==1);
			
			System.out.println("*************************************************************");
			
			
			do
			{
				c=0;
				System.out.println("Enter your contact number");
				contact=scan.nextLine().trim();
				
				if(contact.length()<10)
				{
					System.out.println("\n Contact Number should be greater than 10 digits");
					c++;
					
				}
				else if(contact.matches(".*?[\\{Punct}&&[^_]].*")||name.matches("[a-zA-Z]"))
				{
					System.out.println("\n Enter a valid name....");
					c++;
				}
			}while(c==1);
			
System.out.println("********************************************************");

do
{
	c=0;
	System.out.println("Enter your initial amount :");
	amnt=scan.nextFloat();
	
		if(amnt<1000)
	{
		
		{
			System.out.println("Initial amount should be greater than 1000");
			c++;
		}
	}
}while(c==1);


System.out.println("*****************************************************");
do
{
	System.out.println("Enter your account type (Saving or Current) : ");
	ac=scan.next();
	actype=ac.toLowerCase();
	if(!(actype.equals("saving")||actype.equals("current")))
	{
		System.out.println("Account type should be saving or current");
	}	
		
	}while(!(actype.equals("saving")||actype.equals("current")));
	
	if(actype.equals("saving"))
	{
		actype="saving";
		
	}
	
	System.out.println();
	System.out.println("Account created successfully");
	System.out.println("*******************************************************");
	
	Random rnd =new Random();
	
	String username;
	name.getChars(0, 3, nm, 0);
	username=String.valueOf(nm).trim();
	
	if(username.length()<2)
	{
		username=username+(10000+rnd.nextInt(90000));
	}
	else if(username.length()<3)
	{
		username=username+(1000+rnd.nextInt(9000));
	}
	else
	{
		username=username+(100+rnd.nextInt(900));
	}
	
	
	if(username.contains(" "))
	{
		username=username.replace(" ", "a");
	}
	
	
	int acnt;
	do
	{
		acnt=10000 + rnd.nextInt(90000);
		c=0;
		BufferedReader br=new BufferedReader(new FileReader("userdetails.txt"));
		while((lread=br.readLine())!=null)
		{
			if(lread.contains(acnt+" "))
			{
				c++;
				break;
			}
		}
		br.close();
		
	}while(c==1);
	
	
	int pass=1000+rnd.nextInt(9000);
	System.out.println("\nUsername : "+username);
	System.out.println("Pin Number : "+pass);
	System.out.println("Account Number : "+acnt);
	System.out.println("Initial Balance : "+amnt);
	System.out.println("*********************************************************************************");
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/M/yyyy  hh:mm:ss");
	String date=sdf.format(new Date());
	
	bw.write(username+" "+acnt+"  "+amnt+"   initial"+"    "+amnt+"   "+date);
	
	bw.newLine();
	bw.close();
	outs.println(username+" "+pass+"  "+acnt+"   "+actype+"  "+contact+"  "+amnt);
	outs.close();
	
	BufferedWriter wr=new BufferedWriter(new FileWriter("name.txt",true));
	wr.write(username+" "+pass+"   "+name);
	wr.newLine();
	wr.close();
	
	System.out.println("\nThank You");
	System.out.println("                 For Banking......");
	System.out.println("*************************************************************************");
}
		
catch(InputMismatchException e)
{
	System.out.println("\nOops! You have entered wrong input....");
	System.out.println("******************************************************");

}
catch(Exception a) {}
		
	}
		
	char account[]=new char[6];
	
	
	
public void ExistingUser()
	{
		Scanner scan=new Scanner(System.in);
		int count=0;
		String name=null,pass=null,amt=null,cont=null,actyp=null;
		System.out.println("Enter User name : ");
		String uname=scan.next();
		System.out.println("Enter your pin number : ");
		String upass=scan.next();
		
		String userpass=uname+" "+upass+" ";
		char cnt=' ';
		int choice;
		String line1,line2,fullname;
		char full[]=new char[100];
		
		try {
			BufferedReader ins=new BufferedReader(new FileReader("userdetails.txt"));
			
			while((line1=ins.readLine())!=null)
			{
				if(line1.contains(userpass))
				{
					System.out.println("\nLogged in Successfully!!!");
					System.out.println("*******************************************************");
					BufferedReader nmf=new BufferedReader(new FileReader("name.txt"));
					
					while((line2=nmf.readLine())!=null)
					{
						if(line2.contains(userpass))
						{
							line2.getChars(13, line2.length(),full,0);
							fullname=String.valueOf(full).trim();
							System.out.println("Welcome , "+fullname);
							
						}
					}
					nmf.close();
					
					line1.getChars(12, 18, account, 0);
					String ac=String.valueOf(account).trim();
					String userac=uname+" "+ac;
					
					do
					{
						System.out.println("**************************************************************");
						System.out.println("Please Enter your choice : ");
						System.out.println("1. Deposit");
						System.out.println("2. Withdraw");
						System.out.println("3. Balance Inquiry");
						System.out.println("4. Mini Statement");
						choice=scan.nextInt();
						System.out.println("******************************************************************");
						
						
						switch(choice)
						{
						case 1:
							ins.close();
							deposit(userpass);
							break;
						case 2:
							ins.close();
							withdraw(userpass);
							break;
						case 3:
							ins.close();
							inquiry(userpass);
							break;
						case 4:
							ins.close();
							statement(userac);
							break;
							default:
								System.out.println("Oops! You have entered wrong choice");
								System.out.println("****************************************************************************");
								break;
								
						}
						System.out.println("Do you want to continue (Y/N) : ");
						cnt=scan.next().charAt(0);
					}while(cnt=='Y'||cnt=='y');
					if(cnt!='y'||cnt!='Y')
					{
						System.out.println("*****************************************************************************");
						System.out.println("Thank You");
						System.out.println("       For Banking......");
						System.out.println("******************************************************************************");
						
					}
					count=1;
					break;
					
				}
				
			}
			if(count==0)
			{
				System.out.println("Oops! You have entered wrong User/Password (PIN)....");
				System.out.println("**********************************************************************************");
				
			}
			ins.close();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Oops! You have entered wrong input....");
			System.out.println("**********************************************************************************");
			
		}
		catch(Exception e) {}
		
	}	
		
		void DeleteAccount()
		{
			String OldFilename="userdetails.txt";
			String tmpFilename="out.txt";
			System.out.println("Enter User Name : ");
			String uname=scan.next();
			System.out.println("Enter your Pin Number : ");
			String upin=scan.next();
			
			String combo=uname+" "+upin+" ";
			String data;
			int cnt=0;
			String ac=null;
			String userac=null;
			BufferedReader ins=null;
			BufferedWriter outs=null;
			
			try
			{
				ins=new BufferedReader(new FileReader(OldFilename));
				outs=new BufferedWriter(new FileWriter(tmpFilename));
				
				while((data=ins.readLine())!=null)
				{
					if(data.contains(combo))
					{
						data.getChars(11,17,account,0);
						ac=String.valueOf(account).trim();
						
						cnt++;
						continue;
						
					}
					outs.write(data);
					outs.newLine();
					
				}
				userac=uname+" "+ac;
				
				if(cnt==0)
				{
					System.out.println("Oops! You have entered wrong user/password (Pin)....");
					System.out.println("********************************************************************");
				}
				else
				{
					System.out.println("Account Deleted Successfully...");
					System.out.println("**************************************************************************");
					System.out.println("Thank You");
					System.out.println("            For Banking.....");
					System.out.println("***************************************************************************");
				}
				
				}
			catch(Exception e)
			{}
			finally
			{
				try
				{
					if(ins!=null)
				       ins.close();
				}
				catch(IOException e)
				{
					
				}
			    try
			    {
			    	if(outs!=null)
			    		outs.close();
			    	
			    }
			    catch(IOException e)
			    {
			    	
			    }
			}
			File oldFile=new File(OldFilename);
			oldFile.delete();
			
			File newFile=new File(tmpFilename);
			newFile.renameTo(oldFile);
			
			String old="statement.txt";
			String temp="delete.txt";
			try
			{
				ins=new BufferedReader(new FileReader(old));
				outs=new BufferedWriter(new FileWriter(temp));
				
				while((data=ins.readLine())!=null)
				{
					if(data.contains(userac))
					{
						continue;
						
					}
					outs.write(data);
					outs.newLine();
					
				}
			}
			catch(Exception e)
			{}
			finally
			{
				try
				{
					if(ins!=null)
						ins.close();
					
				}
				catch(IOException e)
				{
		
				}
				try 
				{
					if(outs!=null)
						outs.close();
					
				}
				catch(IOException e)
				{}
				
			}
			File oldF=new File(old);
			oldF.delete();
			
			File newF=new File(temp);
			newF.renameTo(oldF);
			
			String oldFile2="name.txt";
			String tempFile2= "delete.txt";
			try
			{
				ins =new BufferedReader(new FileReader(oldFile2));
				outs=new BufferedWriter (new FileWriter(tempFile2));
				
				while((data=ins.readLine())!=null)
				{
					if(data.contains(combo))
					{
						continue;
						
					}
					outs.write(data);
					outs.newLine();
				}
			}
			catch(Exception e)
			{}
			finally
			{
				try
				{
					if(ins!=null)
						ins.close();
					
				}
				catch(IOException e)
				{
		
				}
				try 
				{
					if(outs!=null)
						outs.close();
					
				}
				catch(IOException e)
				{}
			}
			File oldName=new File(oldFile2);
			oldName.delete();
			
			File newName = new File(tempFile2);
			newName.renameTo(oldName);
		}
		
}


