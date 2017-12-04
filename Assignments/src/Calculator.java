import java.util.*;

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
         System.out.print("Enter menu index to use: ");

         try {
         Scanner scan = new Scanner(System.in);
         menuSelection = scan.nextInt();

         }catch(InputMismatchException inputError) {
            System.out.println("Only the menu index number can be entered.");
            System.out.println("Please Enter the menu index again.");
            System.out.println("");
            menuSelection = 0;
         }
         
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
      return;
   }

   public static void ArithmeticOperation() {
      double firstOperand, secondOperand;
      String firstOpr, secondOpr;
      String arithmeticOperator;
      double arithmeticResult;
      String userSelection;
      boolean isContinue = true;
      
      do {
         firstOperand = 0;
         secondOperand = 0;
         arithmeticOperator = "";
         arithmeticResult = 0;
         firstOpr="";
         secondOpr="";
         userSelection="";
         
         System.out.print("Enter formula to calculate: ");

         Scanner formulaScan = new Scanner(System.in);
         String inputStr = formulaScan.nextLine();
         inputStr = inputStr.replace(" ", "");         

         String subStr = inputStr.substring(0, 1);
         
         if(isStringDouble(subStr)){
            inputStr = "+"+inputStr;   
         }

         String[] inputFormula = inputStr.split("");
         
         try {
            firstOpr = inputFormula[0] + inputFormula[1];
            int i;
            for (i = 2; i<inputFormula.length; i++) {
               if(inputFormula[i].equals("+")||inputFormula[i].equals("-")
                     ||inputFormula[i].equals("*")||inputFormula[i].equals("/")) {
                  break;
               }
               else {
                  firstOpr += inputFormula[i];
               }               
            }
            arithmeticOperator = inputFormula[i];
            i++;
            for ( ; i<inputFormula.length; i++) {
               secondOpr += inputFormula[i];
            }
            firstOperand = Double.parseDouble(firstOpr);
            secondOperand = Double.parseDouble(secondOpr);
            
            //Checking Input formula
            //for(int j=0; j< inputFormula.length ;j++) {
               //System.out.format("array[%d] = %s%n", j, inputFormula[j]);
            //}
            
         }catch(NumberFormatException numberError) {
            System.out.println("----------------------------------------------------");
            System.out.println("Only number and arithmetic operation can be entered.");            
         }catch(NullPointerException pointerError) {            
            System.out.println("----------------------------------------------------");
            System.out.println("Sorry. this program cannot handle the arithmetic problem.");
         }catch(ArrayIndexOutOfBoundsException boundError) {
            System.out.println("----------------------------------------------------");
            System.out.println("Sorry..");
         }

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

         try {
            Scanner continueScan = new Scanner(System.in);
            userSelection = continueScan.next();
         }catch(InputMismatchException continueError) {
            System.out.println("You responded incorrectly.(y/n)");
            userSelection = "n";
         }
         
         if(userSelection.equals("y")) {
            isContinue = true;
         }
         else {
            isContinue = false;
         }
         
      }while(isContinue);

   }

   private static boolean isStringDouble(String string) {
      try {
         Double.parseDouble(string);
         return true;
      } catch(NumberFormatException e) {
         return false;
      }
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
      String userSelection;
      boolean exitConversion = false;
      double inputNumber;
      double resultNumber=0;
      
      do {
         userSelection = "";
         
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
         try {
            conversionSelection = scan.nextInt();
            System.out.println("Enter the index number you want to convert: ");
            inputNumber = scan.nextDouble();
         }catch(InputMismatchException inputError) {
            System.out.println("Please enter right menu number.");
            inputNumber = 0;
            conversionSelection = 0;
         }
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
            resultNumber = FahrenheitToCelsius(inputNumber);
            break;
         case 6:
            resultNumber = CelsiusToFahrenheit(inputNumber);
            break;
         case 7:
            exitConversion = true;
            break;
         default:
            break;
         }   
         System.out.println("Result: "+ resultNumber);
         System.out.println("Continue to conversion?(y/n): ");
         try {
            userSelection = scan.next();
         }catch(InputMismatchException selectionError) {
            System.out.println("You responded incorrectly.(y/n)");
            userSelection = "n";
         }
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

   public static double FahrenheitToCelsius (double inputNumber) {
      double conversionNumber = (inputNumber-32)/1.8;
      return conversionNumber;
   }

   public static double CelsiusToFahrenheit (double inputNumber) {
      double conversionNumber = (inputNumber*1.8)+32;
      return conversionNumber;
   }

}