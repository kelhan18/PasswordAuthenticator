//Keller Han
//Authenticate class contains all the methods necessary to allow a user to enter a randomly
//generated passcode that corresponds to his PIN in order to log in. PINs and Passcodes are 5 digits long,
//and the passcode will be randomized every run. Entering the wrong passcode will result in an error

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Authenticate {

	// Initialize variables
	int[] arrayPinNumber = new int[10];
	int[] arrayRandomNumbers = new int[10];
	int[] passwordArray = new int[5];
	int[] enterPassword = new int[5];
	
	/*-------------------------------------------------------------
	|  Method: [fillArrays()]
	|
	|  Purpose:  [This method, if called, will create a template for the user to enter his password. arrayPinNumber holds the digits 0-9,
				and arrayRandomNumbers randomly generates digits 1-9 that will correspond with each PIN number.]
	|
	|  Pre-condition:  [Initialize array lengths for arrayPinNumber and arrayRandomNumbers]
	|
	|  Post-condition: [The user will have a template of the 0-9 digits and a corresponding random passcode digit underneath them]
	|
	|  Parameters:
	|      arrayPinNumber - an array of length 10 with digits 0-9
		   arrayRandomNumbers - an array of length 10 with random digits at each index
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void fillArrays()
	{
		Random randomNumber = new Random();
		for (int i = 0; i < arrayPinNumber.length; i++)
		{
			arrayPinNumber[i] = i;
			arrayRandomNumbers[i] = randomNumber.nextInt(10);
		}
		System.out.println("PIN digit: " + Arrays.toString(arrayPinNumber));
		System.out.println("Random #:  " + Arrays.toString(arrayRandomNumbers));
	}
	
	/*-------------------------------------------------------------
	|  Method: [storePassword()]
	|
	|  Purpose:  [This method asks the user for his 5 digit PIN and stores it.]
	|
	|  Pre-condition:  [Initialize passwordArray length to 5]
	|
	|  Post-condition: [The 5 digit PIN will be stored in the array passwordArray]
	|
	|  Parameters:
	|      passwordArray - an array of length 5 with user-input digits
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void storePassword()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What is your 5-digit PIN? Please enter it with a space between each number.");
		System.out.println("For example, if your PIN is 01234, please enter it as such: 0 1 2 3 4 ");
		for (int i = 0; i < passwordArray.length; i++)
		{
			while (!input.hasNextInt())
			{
				input.next();
				System.out.println("Error. Unrecognized integer. Please enter 5 digit PIN again: ");
			}
			passwordArray[i] = input.nextInt();	
		}
		System.out.println("Your PIN is: " + Arrays.toString(passwordArray));
	}
	
	/*-------------------------------------------------------------
	|  Method: [checkValidity()]
	|
	|  Purpose:  [This method will ask the user to enter the 5 digit passcode, one digit at a time associated with the user's PIN. 
				It will then check if the digits entered at each index correspond to each other. If all 5 digits of the PIN correspond with it's respective
				random digit, then the user will be granted access. Otherwise, access is denied.]
	|
	|  Pre-condition:  [The user must have initialized the template of PIN digits and random code digits, store the user's passcode, and initialized all the array lengths.]
	|
	|  Post-condition: [The program will check if the digits at each index correspond to each other or not and determine if access is granted.]
	|
	|  Parameters:
	|      passwordArray - an array of length 5 with user input digits
		   arrayRandomNumbers - an array of length 10 with random digits at each index
		   enterPassword - an array of length 5. It is the passcode that the user determines by looking at the PIN digits and passcode template.]
	|
	|  Returns:  [N/A]
	*------------------------------------------------------------------*/
	
	public void checkValidity()
	{
		System.out.println("To log in, enter the random digits from 1-9 that");  
		System.out.println("correspond to your PIN number.");
		System.out.println("Please enter it with a space between each number, such as: 5 6 7 8 9  ");
		Scanner keyboard = new Scanner(System.in);
		for (int i = 0; i < passwordArray.length; i++)
		{
			while (!keyboard.hasNextInt())
			{
				keyboard.next();
				System.out.println("Error. Unrecognized integer. Please enter 5 digit Passcode again: ");
			}
			enterPassword[i] = keyboard.nextInt();
		}
		System.out.println(Arrays.toString(enterPassword));
		if (arrayRandomNumbers[passwordArray[0]] == enterPassword[0] && arrayRandomNumbers[passwordArray[1]] == enterPassword[1] &&
				arrayRandomNumbers[passwordArray[2]] == enterPassword[2] && arrayRandomNumbers[passwordArray[3]] == enterPassword[3] &&
				arrayRandomNumbers[passwordArray[4]] == enterPassword[4])
		{
			System.out.println("Correct! You may now proceed.");
		}
		else
		{
			System.out.println("Error. Invalid password entered.");
		}
	}
	
	
}