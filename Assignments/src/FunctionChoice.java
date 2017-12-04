import java.io.IOException;
import java.util.Scanner;

public class FunctionChoice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("Software Starts");
		do{
		System.out.println("-----Software menu-----");
		System.out.println("1. Memo Manager");
		System.out.println("2. Calculator");
		System.out.println("3. Account Book");
		System.out.println("4. EXIT");
		System.out.print("Enter your option: ");
		choice = scan.nextInt();
		if(choice == 1){
			Memo m = new Memo();
			m.main(args);
			//MEMO
		}
		else if(choice == 2){
			Calculator c = new Calculator();
			c.main(args);
		}
		else if(choice == 3){
			AccountBook a = new AccountBook();
			a.main(args);
			//Account book
		}
		else if(choice == 4){
			//EXIT
		}
		}while(choice!= 4);
	}

}
