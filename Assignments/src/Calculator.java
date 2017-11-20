import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		int menuSelection;
		boolean exitCalculator = false;

		System.out.println("<Start Calculator>");
		//
		
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
		
		//TODO 클래스 종료시키기
		
	}

	public static void ArithmeticOperation() {
		double firstOperand, secondOperand;
		String arithmeticOperator;
		double arithmeticResult;
		boolean isContinue = false;

		do {
			firstOperand = 0;
			secondOperand = 0;
			arithmeticOperator = null;
			arithmeticResult = 0;
			
			System.out.print("Type your formula: ");

			Scanner formulaScan = new Scanner(System.in);
			String inputStr = formulaScan.nextLine();

			//TODO 사용자 입력식 대응하기

			String[] inputFormula = inputStr.split(" ");

			//Checking Input formula
			for(int i=0; i< inputFormula.length ;i++) {
				System.out.format("array[%d] = %s%n", i, inputFormula[i]);
			}

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
				break;
			}

			System.out.format("The answer is: %f \n", arithmeticResult);
			
			System.out.println("Continue to Arithmetic?(y/n)");
			String userSelection = formulaScan.next();
			
			if(userSelection == "y") {
				isContinue = true;
			}
			else {
				isContinue = false;
			}
			
		}while(!isContinue);

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
	}

	public static double poundTokg (double number) {
		return 0;
	}

	public static double kgTopound (double number) {
		return 0;
	}

	public static double inchTocm (double number) {
		return 0;
	}

	public static double cmToinch (double number) {
		return 0;
	}

	public static double FToC (double number) {
		return 0;
	}

	public static double CToF (double number) {
		return 0;
	}

}