import java.util.Scanner;
import java.util.Random;

class Employee {
	//Local variables for First Name and Last Name
	String FName, LName;
	
	//Constructor with parameters
	Employee (String FirstName, String LastName) 
	{
		FName=FirstName;
		LName=LastName;
	}
}

class CredentialService{
	
	//Local Variables to store FirstName and Last Name provided in the constructor
	String FName, LName;
	
	//Private variables to store Confidential information of email address and password 
	private String emailAddress="";
	private String pwd="";
	
	//Constructor with parameters for passing First Name and Last Name
	CredentialService(String FirstName, String LastName)
	{
		//Assigning the parameters to local variable of the instance
		this.FName=FirstName;
		this.LName = LastName;
	}
	
	//Method for Generating Email Address basis the name of department passed in the parameter and assigning it to local private variable of this instance
	void generateEmailAddress(String Department) 
	{
		this.emailAddress= FName.toLowerCase()+"."+LName.toLowerCase() + "@" + Department +".abc.com";
	}
	
	//Method to generate password
	void generatePassword() {
		//Initializing password length
		int passwordlength = 8;
		
		//Creating Strings of UpperCase Letters, Lower Case Letters, Numbers and Special Characters
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYS";
		String lowerCaseLetters="abcdefghijklmopqrstuvwxys";
		String numbers="0123456789";
		String specialCharecters = "!@#$%&";
		
		//Concatenating all the Characters strings in one for a single pool of characters for Random functuion to pick from
		String combinedString= capitalCaseLetters + lowerCaseLetters + specialCharecters + numbers;
		
		//Initializing Random object
		Random rnd = new Random();
		
		//Initializing Password array of Characters for the defined password length
		char[] password = new char[passwordlength];
		
		//Assigning first 4 characters of the password to all the mandatory Characters from the individual strings
		password[0]= lowerCaseLetters.charAt(rnd.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(rnd.nextInt(capitalCaseLetters.length()));
		password[2] = numbers.charAt(rnd.nextInt(numbers.length()));
		password[3] = specialCharecters.charAt(rnd.nextInt(specialCharecters.length()));
		
		//randomly picking remaining 4 characters from the combined String 
		for (int j = 4; j < passwordlength; j++)
		{
			password[j] = combinedString.charAt(rnd.nextInt(combinedString.length()));
		}
		
		//Converting Character array to string and assigning it to local private variable of this instance 
		for (int k = 0; k< passwordlength; k++) 
		{
			this.pwd = this.pwd + password[k];
		}
		
	}
	
	//Method to show the credentials which are in local private variables
	void showCredentials()
	{
		System.out.println("Dear " + this.FName + " your generated credentials are as follows");
		System.out.println("Email    --->" + this.emailAddress);
		System.out.println("Password --->"+ this.pwd);
	}
}
public class NewHireCredentials {

	public static void main(String[] args) {
		// Creating Scanner object to take user input
		Scanner sc = new Scanner(System.in);
		
		//Creating Employee Object
		Employee E = new Employee("Veejay", "Kummar");

		//Printing Department options
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");

		//initiating Credential Service Object by passing Name of employee
		CredentialService cs = new CredentialService(E.FName,E.LName);
				
		//Taking Department input
		int i = sc.nextInt();
		sc.close();

		// Basis input Switching to right department code to generate email address and Random Password via the Credential Service Object also calling the method to display the credentials
		switch (i)
		{		
		case 1:
			cs.generateEmailAddress("tech");
			cs.generatePassword();
			cs.showCredentials();
			break;
		case 2: 
			cs.generateEmailAddress("admin");
			cs.generatePassword();			
			cs.showCredentials();
			break;
		case 3: 
			cs.generateEmailAddress("hr");
			cs.generatePassword();			
			cs.showCredentials();
			break;
		case 4:
			cs.generateEmailAddress("legal");
			cs.generatePassword();			
			cs.showCredentials();
			break;
		}
	}

}
