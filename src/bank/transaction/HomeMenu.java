package bank.transaction;
import java.util.*;
public class HomeMenu {
	
		public static void main(String[] args)
		{
			char w;
			
			try {
				User U=new User();
				Update Up=new Update();
				
				
				int choice;
				char a='n';
				Scanner scan=new Scanner(System.in);
				System.out.println("************************************************");
				System.out.println("                Welcome                 ");
				System.out.println("                   To                   ");
				System.out.println("                The Bank                ");
				System.out.println("************************************************");
		do {
			do
		
				{
					a='n';
					
					System.out.println("1. Create new account");
					System.out.println("2. Existing account");
					System.out.println("3. Delete account");
					System.out.println("4. Update account");
					System.out.println("5. Exit");
					System.out.println();
					System.out.println("\nEnter your choice : ");
					choice=scan.nextInt();
					System.out.println("*********************************************");
					
					
					if(choice>5||choice<1)
					{
						System.out.println("\nOops! You have entered wrong choice");
						System.out.println("*************************************************");
						System.out.println("Do you want to continue (Y/N) : ");
						a=scan.next().charAt(0);
						System.out.println("****************************************************");
					}
				}while(a=='Y'||a=='y');
				
				switch(choice)
				{
				case 1: 
					U.NewUser();
					break;
				case 2: 
					U.ExistingUser();
					break;
				case 3: 
					U.DeleteAccount();
					break;
				case 4: 
					Up.UpdateUser();
					break;
				case 5: 
					break;
					
							
					}
				
				System.out.println("Do you want to continue ? (Y/N) : ");
				w=scan.next().charAt(0);
		}while(w=='y'||w=='Y');
		System.out.println("Thank You");
		System.out.println("       For visiting....");
		System.out.println("*****************************************************");
				
				scan.close();
				
			}
			catch(InputMismatchException a)
			{
				System.out.println("************************************");
				System.out.println("\nOops! You have entered wrong input.....");
				System.out.println("************************************");
				
			}
			catch(Exception e)
			{}
			
		}
		}


