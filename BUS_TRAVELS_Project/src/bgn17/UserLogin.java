package bgn17;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Scanner;

public class UserLogin {
	static Scanner sc=new Scanner(System.in);
	
	public boolean login() {
		UserSignUp signUpObj =UserSignUp.getSignUpObject();
		System.out.println("\nEnter your Registered E-Mail");
		String email=sc.nextLine();
		
		while(validateEmail(email)) {
			System.out.println("\nNo user Exists with Entered Email-ID");
			System.out.println("\nPlease Choose below options");
			System.out.println("\n1 for Re-Enter EmailID\n2 for Create new Account");
			String choice =sc.nextLine();
			switch(choice) {
			case "1":
				System.out.println("\nPlease Re-Enter your Registered Email-ID");
				email=sc.nextLine();
				break;
			case "2":
				signUpObj.storeData();
				return false;
			default:
				System.out.println("\nOh Oh !! You have opted a Wrong Option (-_-)");
				break;
			}
		}
		
		int failedCount=findUser(email).get(email).getFailedCount();
		
		System.out.println("\nPlease Enter your Password");
		String password=sc.nextLine();
		
		if(failedCount >=5)
		{
			System.out.println("\nYour Account is Already Locked !!");
			return false;
		}
		
		while(!validatePassword(email,password)) {
			failedCount++;
			if(failedCount>=5) {
				System.out.println("\nOh Oh!! you have Exceeded your no.of Login Attempts");
				System.out.println("\nYour Account is currrently Locked");
				findUser(email).get(email).setFailedCount(failedCount);
				return false;
			}
			else {
				System.out.println("\nEntered Incorrect Password !!! ");
				findUser(email).get(email).setFailedCount(failedCount);
				System.out.println("\nRe-Enter your Password");
				password=sc.nextLine();
			}	
		}
		
		System.out.println("\n Login Successdull\n");
		System.out.println("\t\tWELCOME  "+findUser(email).get(email).getFirstName());
		findUser(email).get(email).setFailedCount(0);
		return true;
	}
	public static boolean validateEmail(String email) {
		return findUser(email).isEmpty();
	}
	public static boolean validatePassword(String email,String password) {
		return findUser(email).get(email).getPassword().equals(password);
	}
	private static Map<String,UserAccount> findUser(String email){
		// Assume a bookshelf with a bunch of books: 
		//Get the bookshelf (usersMap)
		Map<String,UserAccount> userMap=UserSignUp.getSignUpObject().getUserMap();
		// Start searching through the books (entries) on the bookshelf
		return userMap.entrySet().stream().
				// Check each book's title (email) to find the one you're looking for
				filter( user -> user.getKey().equals(email))
				// Once you find the book, take it from the bookshelf
				.collect(Collectors.toMap(user -> user.getKey(), user -> user.getValue()));
	}
}
