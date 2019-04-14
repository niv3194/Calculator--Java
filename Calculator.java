//2955323-Nivedha Nagarajan-HDC-CP-Lab6 Large Assignment
import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
	public static void main(String[] args) {
		while (true) // to make the program run until user enters quit
		{
			System.out.print(">Enter your inputs: ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine(); // fetches input from the user
			input = input.toLowerCase();// converts to lower case irrespective
			// of the case
			if (input.length() >= 5 || input.equalsIgnoreCase("quit"))// checks
																		// the
																		// input
																		// length
																		// and
																		// checks
																		// if
																		// the
																		// input
																		// is
																		// quit
			{
				if (input.equalsIgnoreCase("quit")) // displays GoodBye if user
													// enters quit
				{
					System.out.println("Goodbye!");
					break;
				} else {
					String function = input.substring(0, 3); // stores the first
																// 3 characters
																// of the input
																// string
					if (function.equals("sin") || function.equals("cos")
							|| function.equals("tan")) // executes the function
														// TrignometryCheck if
														// the
														// input equals
														// sin,cos or
														// tan
					{
						System.out.println(TrignometryCheck(input));
					} else // if the string does not contain sin cos or tan
							// executes
							// the function OperatorCheck
					{
						System.out.println(OperatorCheck(input));
					}
				}
			} else {
				System.out.println("Invalid Input"); // displays invalid input
														// if the input string
														// length is lesser than
														// 5 or does not contain
														// quit
			}
		}
	}

	// Method for Arithmetic Operation
	// This method splits the input based on space, parses the input on either
	// sides of the operator into double,stores them and the operator into the
	// array and performs
	// the operation and converts the result to string and returns the result to
	// main method
	public static String OperatorCheck(String s) {
		String[] check;
		double x = 0, y = 0;
		String operator = "";
		String result = "";
		if ((s.indexOf(" ") >= 0)) // checks for the space
		{
			check = s.split(" "); // splits based on the space and stores them
									// in the array check
			try { // executes the following code and catches the exception

				x = Double.parseDouble(check[0]); // parses the string to double
													// in the position 0 of
													// check

				y = Double.parseDouble(check[2]);// parses the string to double
													// in the position 2 of
													// check
			} catch (Exception e) // catches the possible exceptions and returns
									// invalid input
			{
				return "Invalid Input";
			}
			operator = check[1]; // assigns the character at position 1 at check
									// to string operator
			if (check.length == 3) { // checks if the array length is 3
				switch (operator) { // string operator is used in switch case

				case "+":
					result = Double.toString(x + y); // performs addition if the
														// operator is +
					break;
				case "-":
					result = Double.toString(x - y); // performs subtraction if
														// operator is -
					break;
				case "*":
					result = Double.toString(x * y); // performs multiplication
														// if
														// operator is *
					break;

				case "/":
					result = Double.toString(x / y); // performs division if
														// operator is /
					break;
				case "^":
					result = Double.toString(Math.pow(x, y)); // performs
																// exponentiation
																// if
																// operator is ^
					break;
				default:
					return "Invalid Input"; // returns invalid input if the
											// string has any invalid symbol as
											// operator
				}
			} else {
				return " Invalid Input"; // returns invalid input if array
											// length exceeds 3
			}
		} else {
			return "Invalid Input"; // returns invalid input if the string
									// does not contain space
		}
		return "Result=" + result; // returns result to main method
	}

	// Method for Trigonometric Operation
	// This method splits the input based on space,
	// parses the input to double at the position 1 and stores in the array and
	// performs the operation,converts the result to string and returns the
	// result to main method
	public static String TrignometryCheck(String t) {
		String y, z;
		String result = "";
		String[] inputArray = null;
		String function = "";
		double b = 0;
		double x = 0;
		if (t.indexOf(" ") >= 0) // checks if the string has space
		{
			inputArray = t.split(Pattern.quote(" ")); // splits based on space
														// and stores in
														// inputArray

			try // tries the following code and catches exception
			{

				b = Double.parseDouble(inputArray[1]); // parses the string to
														// double at position 1
														// at inputArray

			} catch (Exception nfe) // catches all the possible exceptions and
									// returns invalid input
			{
				return "Invalid Input";
			}
			function = inputArray[0];// stores position 0 in string function
			x = Math.toRadians(b);// converts the double to radian
			if (inputArray.length == 2) {
				if (function.equals(("sin"))) {
					result = Double.toString(Math.sin(x)); // performs sin
															// function
															// if the string
															// contains sin
				} else if (function.equals(("cos"))) // performs cos function if
														// the
														// string contains cos
				{
					result = Double.toString(Math.cos(x));
					if (Math.abs(Double.parseDouble(result)) < 0.000001) // prints
																			// 0
																			// if
																			// the
																			// result
																			// is
																			// a
																			// value
																			// less
																			// than
																			// 0.000001
					{
						return "Result=0.0";
					}
				} else if (function.equals(("tan"))) // performs tan function if
														// the
														// string contains tan
				{
					result = Double.toString(Math.tan(x));
					if (b == 45) {
						return "Result=1.0";
					} else if (b == -45) {
						return "Result=-1.0";
					}
					if ((b % 180) == 0)// returns 0 if tan is 180,360 and so on
					{
						return "Result=0.0";
					} else if ((b % 90) == 0) // returns infinity if tan
												// 90,270 etc
					{
						return "Result=infinity";
					}

				} else {
					return "Invalid Input"; // returns invalid input if
											// string value is not sin, cos
											// or tan
				}

			} else {
				return "Invalid Input"; // returns invalid input if the array
										// length exceeds 2
			}
		} else {
			return "Invalid Input"; // returns invalid input if the string has
									// no space
		}
		return "Result=" + result; // returns result to main method
	}

}// end of class calculator
