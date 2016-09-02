//Keller Han
//Write a demo class that will create an object of the class Authenticate and determine if the user-entered passcode correctly 
//corresponds with the associated random digits

public class AuthenticateDemo {

	/*-------------------------------------------------------------
	|  Method: [Main]
	|
	|  Purpose:  [To create a demo where we test the Authenticate class and see if the user can correctly input
				their respective random passcode based on their pin number]
	|
	|  Pre-condition:  [The Authenticate class must contain all the methods necessary to initialize the arrays and ask for user-input passcodes]
	|
	|  Post-condition: [After inputting the passcode and having the program check it with the random digits, the program will determine if the user has 
					been granted access or not based on the correct passcode.]
	|
	|  Parameters: [N/A]
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		Authenticate demo  = new Authenticate();
		demo.fillArrays();
		demo.storePassword();
		demo.checkValidity();
	}
}
