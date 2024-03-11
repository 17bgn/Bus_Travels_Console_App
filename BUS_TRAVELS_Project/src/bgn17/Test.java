package bgn17;

import  java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
	
	Map<String,UserAccount> userMap=new HashMap<>();
	static Scanner sc=new Scanner(System.in);
	
	private static void printMenu() {
		System.out.println("\nPlease Choose From below Options:");
		System.out.println("\n1 Create Account\n2 Login\n3 Book Tickets\n4 Log Out\n5 Un Lock Account\n6 Exit Application\n");
	}
	public static void main(String args[]) {
		boolean isLoggedin=false;
		//sc.nextLine();
		System.out.println();
		LogoDisplay.logoDisplay("C:\\Users\\bgnag\\eclipse-workspace\\BUS_TRAVELS_Project\\src\\bgn17\\Plogo.txt");
		System.out.println();
		Adminstrator.getAdminObj().addBus();
		boolean flag=true;
		while(flag) {
			printMenu();
			String choice =sc.nextLine();
			switch(choice) {
			
			case "1":
				if(isLoggedin)
					System.out.println("\nLog Out Before Trying to Sign Up");
				else {
					UserSignUp.getSignUpObject().storeData();
					System.out.println("\nPlease Login Now!!");
				}
				break;
				
			case "2":
				if(isLoggedin) {
					System.out.println("\nYou are Already Logged IN!!");
					break;
				}
				UserLogin loginObj = new UserLogin();
				if(loginObj.login())
					isLoggedin=true;
				else
					System.out.println("\nLogin Un Succesfull !!");
				break;
				
			case "3":
				if(isLoggedin) {
					PlanJourney journeyObj =new PlanJourney();
					journeyObj.bookTicket();
				}else
					System.out.println("\nPlease Login to Book Tickets !!");
				break;
				
			case "4":
				if(isLoggedin) {
					isLoggedin =false;
					System.out.println("\nSuccesfully Logged Out!!");
				}else
					System.out.println("\nNo User Logged In");
				break;
				
			case "5":
				if(isLoggedin)
					System.out.println("\nLog Out Before Trying to Unlock Your Account");
				else
					Adminstrator.getAdminObj().unLockAccount();
				break;
				
			case "6":
				flag =false;
				System.out.println("Thank you for using our application. Your progress has been saved");
				break;
				
			default:
				System.out.println("\nPlease Choose A Valid Option !!");
				break;
			}
		}
	}
	
}
