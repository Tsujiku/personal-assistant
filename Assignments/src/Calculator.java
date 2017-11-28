import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		int menuSelection;
		boolean exitCalculator = false;

		System.out.println("<Start Calculator>");
		
		do {
			System.out.println("----Calculator menu----");
			System.out.println("1. Arithmetic operation");
			System.out.println("2. Unit conversion");
			System.out.println("3. Exit calculator");
			System.out.println("-----------------------");
			System.out.print("Press 1/2/3: ");

			Scanner scan = new Scanner(System.in);
			menuSelection = scan.nextInt();

			switch (menuSelection) {
			case 1:
				ArithmeticOperation();
				break;

			case 2:
				UnitConversion();
				break;

			case 3:
				exitCalculator = true;
				break;

			default:
				break;
			}	
		}while(!exitCalculator);

		System.out.println("<End Calculator>");
		
	}

	public static void ArithmeticOperation() {
		double firstOperand, secondOperand;
		String arithmeticOperator;
		double arithmeticResult;
		boolean isContinue = true;

		do {
			firstOperand = 0;
			secondOperand = 0;
			arithmeticOperator = null;
			arithmeticResult = 0;
			
			System.out.print("Enter formula to calculate: ");

			Scanner formulaScan = new Scanner(System.in);
			String inputStr = formulaScan.nextLine();

			//TODO 사용자 입력식 대응하기

			String[] inputFormula = inputStr.split(" ");

			//Checking Input formula
			//for(int i=0; i< inputFormula.length ;i++) {
				//System.out.format("array[%d] = %s%n", i, inputFormula[i]);
			//}

			firstOperand = Double.parseDouble(inputFormula[0]);
			secondOperand = Double.parseDouble(inputFormula[2]);
			arithmeticOperator = inputFormula[1];

			switch (arithmeticOperator) {
			case "+":
				arithmeticResult = add(firstOperand, secondOperand);
				break;

			case "-":
				arithmeticResult = subtract(firstOperand, secondOperand);	
				break;

			case "*":
				arithmeticResult = multiply(firstOperand, secondOperand);
				break;


			case "/":
				arithmeticResult = divide(firstOperand, secondOperand);
				break;
			
			default:
				System.out.println("Please Check your formula again.");
				break;
			}
			System.out.format("The answer is: %f \n", arithmeticResult);
			
			System.out.println("Continue to Arithmetic?(y/n)");
			Scanner continueScan = new Scanner(System.in);
			String userSelection = continueScan.next();
			
			if(userSelection.equals("y")) {
				isContinue = true;
			}
			else {
				isContinue = false;
			}
			
		}while(isContinue);

	}

	public static double add(double firstTerm, double secondTerm) {
		double additionResult;
		additionResult = firstTerm + secondTerm;
		return additionResult;
	}

	public static double subtract(double firstTerm, double secondTerm) {
		double subtractionResult;
		subtractionResult = firstTerm - secondTerm;
		return subtractionResult;
	}

	public static double multiply(double firstTerm, double secondTerm) {
		double multiplicationResult;
		multiplicationResult = firstTerm * secondTerm;
		return multiplicationResult;
	}

	public static double divide(double firstTerm, double secondTerm) {
		double divisionResult;
		divisionResult = firstTerm / secondTerm;
		return divisionResult;
	}

	public static void UnitConversion() {
		
		int conversionSelection;
		boolean exitConversion = false;
		double inputNumber;
		double resultNumber=0;
		
		do {
			System.out.println("----Conversion menu----");
			System.out.println("1. pound to kg");
			System.out.println("2. kg to pound");
			System.out.println("3. inch to cm");
			System.out.println("4. cm to inch");
			System.out.println("5. Fahrenheit to Celsius");
			System.out.println("6. Celsius to Fahrenheit");
			System.out.println("7. Exit conversion");
			System.out.println("-----------------------");
			System.out.print("Enter index to convert: ");

			Scanner scan = new Scanner(System.in);
			conversionSelection = scan.nextInt();

			System.out.println("Enter the number you want to convert(Number Only): ");
			inputNumber = scan.nextDouble();
			
			switch (conversionSelection) {
			case 1:
				resultNumber = poundTokg(inputNumber);
				break;
			case 2:
				resultNumber = kgTopound(inputNumber);
				break;
			case 3:
				resultNumber = inchTocm(inputNumber);
				break;
			case 4:
				resultNumber = cmToinch(inputNumber);
				break;
			case 5:
				resultNumber = FToC(inputNumber);
				break;
			case 6:
				resultNumber = CToF(inputNumber);
				break;
			case 7:
				exitConversion = true;
				break;
			default:
				break;
			}	
			System.out.println("Result: "+ resultNumber);
			System.out.println("Continue to conversion?(y/n): ");
			String userSelection = scan.next();
			
			if(userSelection.equals("y")) {
				exitConversion = false;
			}
			else {
				exitConversion = true;
			}
			
		}while(!exitConversion);
	}

	public static double poundTokg (double inputNumber) {
		double conversionNumber = inputNumber*0.45359;
		return conversionNumber;
	}

	public static double kgTopound (double inputNumber) {
		double conversionNumber = inputNumber*2.20459;
		return conversionNumber;
	}

	public static double inchTocm (double inputNumber) {
		double conversionNumber = inputNumber*2.54;
		return conversionNumber;
	}

	public static double cmToinch (double inputNumber) {
		double conversionNumber = inputNumber*0.3937;
		return conversionNumber;
	}

	public static double FToC (double inputNumber) {
		double conversionNumber = (inputNumber-32)/1.8;
		return conversionNumber;
	}

	public static double CToF (double inputNumber) {
		double conversionNumber = (inputNumber*1.8)+32;
		return conversionNumber;
	}

}