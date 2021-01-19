package assignment;

import java.util.Scanner;

public class Calculator {
	
	public void addition(double num1 , double num2)
	{
		double result = num1 + num2;
		System.out.println("Addition is: " + result);
	}
	public void subtraction(double num1 , double num2)
	{
		double result = num1 - num2;
		System.out.println("Substraction is: " + result);
	}
	public void multiplication(double num1 , double num2)
	{
		double result = num1 * num2;
		System.out.println("Multiplication is: " + result);
	}
	public void division(double num1 , double num2)
	{
		double result = num1 / num2;
		System.out.println("Division is: " + result);
	}

	public static void main(String[] args) {
		double number1 , number2;
		char operator;
		Calculator calculator = new Calculator();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1st number: ");
		number1 = sc.nextDouble();
		System.out.print("Enter 2nd number: ");
		number2 = sc.nextDouble();
		System.out.print("Select any operation(+,-,*,/): ");
		
	    operator = sc.next().charAt(0);

	    switch (operator) {
	      case '+':
	        calculator.addition(number1, number2);
	        break;

	      case '-':
	        calculator.subtraction(number1, number2);
	        break;

	      case '*':
	        calculator.multiplication(number1, number2);
	        break;

	      case '/':
	        calculator.division(number1, number2);
	        break;

	      default:
	        System.out.printf("Error! Please select correct operation");
	        return;
	    }
	    
	  }
	}

