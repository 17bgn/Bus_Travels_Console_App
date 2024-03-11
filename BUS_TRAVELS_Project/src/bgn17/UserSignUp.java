package bgn17;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class UserSignUp {
	
	Map<String,UserAccount> userMap=new HashMap<>();
	
	private UserSignUp() {
	}
	
	static UserSignUp signUpObj=new UserSignUp();
	
	public static UserSignUp getSignUpObject() {
		return signUpObj;
	}
	public Map<String,UserAccount> getUserMap(){
		return userMap;
	}
	
	//Checking Methods validation
	static Scanner sc=new Scanner(System.in);
	public void storeData() {
		System.out.println("\nPlease Enter your Email ID");
		String email=sc.nextLine();
		while(isExistingUser(email)) {
			System.out.println("\nUser with this Email ID already Exist's");
			System.out.println("\nPlease Enter again a Different Email ID");
			email=sc.nextLine();
		}
		while(!isValidEmail(email)) {
			System.out.println("\nInvalid Email-ID !!! ");
			System.out.println("\nPlease Enter again a Different Email ID");
			email=sc.nextLine();
		}
		
		System.out.println("\nPlease Enter your Password");
		String password=sc.nextLine();
		while(!signUpObj.isValidPassword(password)) {
			System.out.println("\nInvalid password !!\nPlease Enter a Valid Password");
			System.out.println("\nPassword must have 1-Uppercase,1-Lowercase,1-Digit,1-SpecialCharacter,Length>= 6\n");
			password=sc.nextLine();
		}
		
		System.out.println("\nPlease Enter your First Name");
		String firstName=sc.nextLine();
		while(!signUpObj.isValidName(firstName)) {
			System.out.println("\nInvalid First Name !!!");
			System.out.println("\nPlease Enter again Valid First Name");
			firstName=sc.nextLine();
		}
		
		System.out.println("\nPlease Enter your Last Name");
		String lastName=sc.nextLine();
		while(!signUpObj.isValidName(lastName)) {
			System.out.println("\nInvalid last Name !!!");
			System.out.println("\nPlease Enter again Valid Last Name");
			lastName=sc.nextLine();
		}
		
		System.out.println("\nPlease Enter your Mobile Number");
		String mobileNumber=sc.nextLine();
		while(!signUpObj.isValidMobileNumber(mobileNumber)) {
			System.out.println("\nInvalid Mobile Number !!!");
			System.out.println("\nPlease Enter again your Mobile Number");
			mobileNumber=sc.nextLine();
		}
		
		System.out.println("\nPlease Enter your Gender(M/F)");
		String gender=sc.nextLine();
		
		userMap.put(email, new UserAccount(firstName,lastName,gender,mobileNumber,email,password));
		System.out.println("\nUser SIGN UP Successfull :)\n");
	}
	
	//Method Definitions
	private boolean isValidName(String name) {
		return name.trim().matches("[a-zA-Z]+");
	}
	private boolean isValidMobileNumber(String mobileNumber) {
		return (mobileNumber.matches("[0-9]*$")) && (mobileNumber.length()==10);
	}
	private boolean isExistingUser(String email) {
		return userMap.get(email) !=null;
	}
	private boolean isValidEmail(String email) {
		return email.contains("@") && email.contains(".") && !email.contains("@.");
	}
	private boolean isValidPassword(String password) {
		boolean hasUpperCase =false;
		boolean hasLowerCase =false;
		boolean hasDigit =false;
		for(char c: password.toCharArray()) {
			if(Character.isUpperCase(c))
				hasUpperCase=true;
			else if(Character.isLowerCase(c))
				hasLowerCase=true;
			else if(Character.isDigit(c))
				hasDigit=true;
		}
		return hasUpperCase && hasLowerCase && hasDigit && password.length()>=6 ;
	}
}
