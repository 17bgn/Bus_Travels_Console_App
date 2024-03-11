package bgn17;

public class UserAccount {
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNumber;
	private String emailId;
	private String password;
	private int failedCount;
	private String accountStatus;
	
	public UserAccount(String firstName,String lastName,String gender,
						String mobileNumber,String emailId,String password) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
		this.mobileNumber=mobileNumber;
		this.emailId=emailId;
		this.password=password;
		this.failedCount=0;
		this.accountStatus="Active";
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public int getFailedCount() {
		return failedCount;
	}
	public void setFailedCount(int failedCount) {
		this.failedCount=failedCount;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus=accountStatus;
	}
	
	@Override
	public String toString() {
		return "UserAccount DETAILS \n\n[FirstName = "+firstName+" \nLastName = "+lastName+" \nGender = "+gender+
				" \nMobileNumber = "+mobileNumber+" \nEmailId = "+emailId+" \nPassword = "+password+
				" \nFailedCounts = "+failedCount+" \nAccountStatus = "+accountStatus+"]\n";
	}

	
}
