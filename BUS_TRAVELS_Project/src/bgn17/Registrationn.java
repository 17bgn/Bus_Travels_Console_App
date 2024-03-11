package bgn17;
import java.util.Scanner;

class NewUserRegistration{
	Scanner sc=new Scanner(System.in);
	private String FirstName;
	private String LastName;
	private String MobileNumber;
	private String Gender;
	private String Email_Id;
	private String password;
	//Getter methods
	public String getFirstName()
	{
		return FirstName;
	}
	public String getLastName()
	{
		return LastName;
	}
	public String getGender()
	{
		return Gender;
	}	
	public String getEmail_Id()
	{
		return Email_Id;
	}
	public String getPassword()
	{
		return password;
	}
	public String getMobileNumber() 
	{
		return MobileNumber;
	}
	//Setter Methods
	public void setFirstName(String FirstName)
	{
		this.FirstName=FirstName;
	}
	public void setLastName(String LastName)
	{
		this.LastName=LastName;
	}
	public void setGender(String Gender)
	{
		this.Gender=Gender;
	}
	public void setMobileNumber(String MobileNumber)
	{
		int mnLength;
		do 
		{
			mnLength=MobileNumber.length();
			if(mnLength ==10)
			{
				this.MobileNumber=MobileNumber;
				return;
			}
			else
			{
				System.out.println("Password lessthan 10 digits\nPlease enter Mobile_Number again..");
			}
			System.out.println();
			System.out.println("Please Enter the mobile number again..");
			MobileNumber=sc.next();
		}while(mnLength !=10);
		this.MobileNumber=MobileNumber;
	}
	public void setEmail_Id(String Email_Id)
	{
		do {
			if(Email_Id.contains("@gmail.com"))
			{
				this.Email_Id=Email_Id;
				return;
			}
			else
			{
				System.out.println("Email don't have @gmail.com");	
			}
			System.out.println();
			System.out.println("Please Enter the Email_Id again..");
			Email_Id=sc.next();
		}while(!Email_Id.contains("@gmail.com"));
		this.Email_Id=Email_Id;
	}
	public void setPassword(String password)
	{
		String regex;
		do 
		{
			regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%&_;><])(?!.\\s).{8,}$";
			//System.out.println("Enter the Password");
			if(password.matches(regex))
			{
				this.password=password;
				return;
			}
			else
			{
				System.out.println("Please Enter the Password again..");
			}
			System.out.println();
			password=sc.next();
		}while(!password.matches(regex));
		this.password=password;
	}
}
public class Registrationn {
	public static void main(String[] args) {
		NewUserRegistration nur=new NewUserRegistration();
		Scanner s=new Scanner(System.in);
		//taking user input for Set methods
		System.out.println("Enter the First Name");
		String FName=s.nextLine();
		nur.setFirstName(FName);
		System.out.println("Enter the Last Name");
		String LName=s.nextLine();
		nur.setLastName(LName);
		System.out.println("Enter the Gender");
		String Sex=s.nextLine();
		nur.setGender(Sex);
		System.out.println("Enter the MobileNumber");
		String MobNum=s.next();
		nur.setMobileNumber(MobNum);
		System.out.println("Enter the Email_ID");
		String Mailid=s.next();
		nur.setEmail_Id(Mailid);
		System.out.println("Enter the Password It need to include\n1.Uppercase\n2.Lowercase\n3.Numeric\n4.SpecialCharacter\n5.NoSpaces\n6.Must be >= 8 Characters");
		String pword=s.next();
		nur.setPassword(pword);
		System.out.println();
		System.out.println("FirstName: "+nur.getFirstName());
		System.out.println("LastName: "+nur.getLastName());
		System.out.println("Gender: "+nur.getGender());
		System.out.println("Mobile Number: "+nur.getMobileNumber());
		System.out.println("Email_Id: "+nur.getEmail_Id());
		System.out.println("Password: "+nur.getPassword());	
	}
}

