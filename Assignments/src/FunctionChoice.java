import java.io.IOException;
import java.util.Scanner;

public class FunctionChoice {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		Scanner scanNumber = new Scanner(System.in);
		int choice;
		System.out.println("Software Starts");
		do {
			System.out.println("-----Software menu-----");
			System.out.println("1. Memo Manager");
			System.out.println("2. Calculator");
			System.out.println("3. Account Book");
			System.out.println("4. EXIT");
			System.out.print("Enter your option: ");
			choice = scanNumber.nextInt();
			
			if (choice == 1) {
				Memo memo = new Memo();
				memo.main(args);
				
			} else if (choice == 2) {
				Calculator calculator = new Calculator();
				calculator.main(args);
			} else if (choice == 3) {
				AccountBook accountbook = new AccountBook();
				accountbook.main(args);
				
			} else if (choice == 4) {
				System.out.println("SofterWare End");
				// EXIT
			}
		} while (choice != 4);
		
	}

}
