package bank.transaction;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Operations {
	float damt=0.0f,wamt=0.0f;
	static float bal=0.0f;
	String data;
	char fbal[]=new char[20];
	char user[] =new char[20];
	char account[]=new char[20];
	int l=0;
	Scanner scan=new Scanner(System.in);
	
	public void deposit(String nmpass)
	{
		String oldFilename ="userdetails.txt";
		String tmpFilename ="out.txt";
		BufferedReader ins=null;
		BufferedWriter outs=null;
		
		try
		{
			ins = new BufferedReader(new FileReader(oldFilename));
			outs = new BufferedWriter(new FileWriter(tmpFilename));
			
			BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
			while((data=ins.readLine())!=null)
			{
					
				
				if(data.contains(nmpass))
				{
					l=data.length();
					data.getChars(40, l-1, fbal, 0);
					String b=String.valueOf(fbal).trim();
					
					bal=Float.parseFloat(b);
					
					data.getChars(0,6,user,0);
					String u=String.valueOf(user).trim();
					data.getChars(12,18,account,0);
					String ac=String.valueOf(account).trim();
					
					try
					{
					System.out.println("Please enter your amount : ");
					String dm=scan.next();
					damt=Float.parseFloat(dm);
					
					if(damt<100.0f)
					{
						System.out.println("Amount should be greater than or equal to Rs 100");
						System.out.println("*********************************************************");
					}
					else
					{
						bal=bal+damt;
						System.out.println("Transaction Completed Successfully");
						System.out.println("Total Balance : "+bal);
						System.out.println("*************************************************************");
						
						String c=String.valueOf(bal);
						data=data.replace(b, c);
						
						SimpleDateFormat sdf= new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
						String date= sdf.format(new Date());
						
						bw.write(u+" "+ac+"  "+damt+"  deposit"+"    "+bal+"    "+date  );
						bw.newLine();
						bw.close();
						
					}
				}
					catch(NumberFormatException ioe)
					{
						System.out.println("Oops! You have Entered wrong input...");
						System.out.println("**************************************");
						
					}
					
				}
				outs.write(data);
				outs.newLine();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Oops! You have entered wrong input...");
			System.out.println("********************************************************");
			
		}
		catch(Exception e)
		{
			return;
			
		}
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
			
		}
		File oldFile =new File(oldFilename);
		oldFile.delete();
		
		File newFile=new File(tmpFilename);
		newFile.renameTo(oldFile);
		
	}
	


public void withdraw(String nmpass)
{
  String oldFilename="userdetails.txt";
  String tmpFilename="out.txt";
  BufferedReader ins=null;
  BufferedWriter outs=null;
  try
  {
	  ins=new BufferedReader(new FileReader(oldFilename));
	  outs=new BufferedWriter(new FileWriter(tmpFilename));
	  
	  BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
	  while((data=ins.readLine())!=null)
	  {
		  if(data.contains(nmpass))
		  {
			  l=data.length();
			  data.getChars(40, l-1, fbal, 0);
			  String b=String.valueOf(fbal).trim();
			  
			  bal=Float.parseFloat(b);
			  
			  data.getChars(0,6,user,0);
			  String u=String.valueOf(user).trim();
			  data.getChars(12,18,account,0);
			  String ac=String.valueOf(account).trim();
			  
			  try
			  {
				System.out.println("Enter your withdrawal amount : ");
				String wt=scan.next();
				wamt=Float.parseFloat(wt);
				float less=bal-wamt;
				
				if(wamt<100.0f)
				{
					System.out.println("Withdrawal should be greater than Rs 100");
					System.out.println("****************************************************");
					
				}
				else if(less<1000.0f)
				{
					System.out.println("Insufficient balance...");
					System.out.println("************************************************");
					
				}
				else
				{
					bal=bal-wamt;
					System.out.println("Transaction completed successfully....");
					System.out.println("Toatal Balance : "+bal);
					System.out.println("********************************************************");
					String c =String.valueOf(bal);
					
					data=data.replace(b, c);
					
					SimpleDateFormat sdf= new SimpleDateFormat("dd/M/yyyy");
					String date=sdf.format(new Date());
					
					bw.write(u+" "+ac+"   "+wamt+"  withdraw"+"   "+bal+"   "+date);
					
					bw.newLine();
					bw.close();
					
					
				}
			  }
			  catch(NumberFormatException eoi)
			  {
				  System.out.println("Oops! You have entered wrong input....");
				  System.out.println("*******************************************");
				  
			  }
		  }
		  outs.write(data);
		  outs.newLine();
	  }
  }
  catch(InputMismatchException e)
  {
	  System.out.println("Oops! You have entered wrong input...");
	  System.out.println("***********************************************");
	  
  }
  catch(Exception e) {}
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
  File oldFile =new File(oldFilename);
  oldFile.delete();
}


public void inquiry(String nmpass)
{
try
{
	BufferedReader ins=new BufferedReader(new FileReader("userdetails.txt"));
	while((data=ins.readLine())!=null)
	{
		if(data.contains(nmpass))
		{
			l=data.length();
			data.getChars(40,l-1,fbal,0);
			String b=String.valueOf(fbal).trim();
			bal=Float.parseFloat(b);
			System.out.println("Total Balance : "+bal);
			System.out.println("**********************************************************************");
			break;
		}
	}
	ins.close();
}
catch(Exception e) {}

}
public void statement(String nmacnt)
{
	try {
		BufferedReader ins=new BufferedReader(new FileReader("statement.txt"));
		System.out.println("User |"+" A/c No. |"+" Transactions |"+" Total Bal. "+"| Date & Time |");
		System.out.println("*************************************************************");
		System.out.println();
		while((data=ins.readLine())!=null)
		{
			if(data.contains(nmacnt))
			{
				System.out.println(data);
			}
		}
		System.out.println("*********************************************************************");
		ins.close();
		
	}
	catch(Exception e) {}
	
}

}