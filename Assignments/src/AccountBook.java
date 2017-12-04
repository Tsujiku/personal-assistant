// 자동줄맞춤 Ctrl+Shift+F

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountBook {

	static String FILENAME;

	public static BufferedWriter write;
	public static BufferedReader read;
	public static File file;

	public static List<String> AccountList;

	public static int flag = 0;
	public static int index = 0;

	public static String priceStr;
	public static String itemStr;
	public static String dateStr;

	public static void main(String[] args) throws IOException {

		int menuSelection;
		boolean exitAccountbook = false;

		System.out.println("<Start Accountbook>");

		do {
			// 가계부 내용을 편빕할 파일을 생성 및 호출
			// 파일 내의 정보를 배열 리스트에 저장

			file = new File("C:\\sweng\\personal-assistant\\accountbook.txt");

			AccountList = new ArrayList<String>();

			boolean isExists = file.exists();
			if (isExists) { // 파일 존재할 때 내용 읽어오기

				read = new BufferedReader(new FileReader(file));
				String s;
				int count = 1;

				while ((s = read.readLine()) != null) {
					AccountList.add(s);
					System.out.println("index : " + count + "||" + AccountList.get(count - 1).toString());
					count++;
				}
				read.close();
			}

			else {
				System.out.println("not imformation");
			}

			// 가계부 리스트 화면에 뿌려주기
			System.out.println("----Accountbook menu----");
			System.out.println("1. Insert");
			System.out.println("2. Modify");
			System.out.println("3. Delete");
			System.out.println("4. Exit Accountbook");
			System.out.println("-----------------------");
			System.out.print("Press 1/2/3/4: ");

			Scanner scan = new Scanner(System.in);
			menuSelection = scan.nextInt();

			switch (menuSelection) {
			case 1:
				Insert();
				break;

			case 2:
				System.out.print("Enter index to Modify : ");
				index = scan.nextInt();
				Modify(index);
				break;

			case 3:
				System.out.print("Enter index to Delete : ");
				index = scan.nextInt();
				Delete(index);
				break;

			case 4:
				exitAccountbook = true;
				break;

			default:
				break;
			}
		} while (!exitAccountbook);

		System.out.println("<End Accountbook>");

	}

	public static void Insert() throws IOException {

		boolean isContinue = false;
		flag = 0; //confirm함수에 전달

		do {

			System.out.print("date: ");

			Scanner userdate = new Scanner(System.in);
			String dateStr = userdate.nextLine();

			System.out.print("item: ");
			Scanner useritem = new Scanner(System.in);
			String itemStr = useritem.nextLine();

			System.out.print("price: ");
			Scanner userprice = new Scanner(System.in);
			String priceStr = userprice.nextLine();

			AccountList.add(dateStr + " " + itemStr + " " + priceStr);

			// 확인할건지 취소할건지 물어보고 confirm, cancel 함수 호출
			System.out.println("Do you want to save?(y/n)");
			Scanner issave = new Scanner(System.in);
			String saveStr = issave.nextLine();

			if (saveStr.equals("y")) {
				confirm();
			} else {
				cancel();
			}

			System.out.println("Continue to Accountbook?(y/n)");
			Scanner continuescan = new Scanner(System.in);
			String continueStr = continuescan.nextLine();

			if (continueStr.equals("y")) {
				isContinue = false;
			} else {
				isContinue = true;
			}

		} while (!isContinue);

	}

	public static void Modify(int index) throws IOException {
		
		boolean isContinue = false;
		flag = 0;

		AccountList.remove(index - 1); //수정할 레코드 삭제  (array라서 -1 해줌)

		do {

			System.out.print("date: ");

			Scanner userdate = new Scanner(System.in);
			String dateStr = userdate.nextLine();

			System.out.print("item: ");
			Scanner useritem = new Scanner(System.in);
			String itemStr = useritem.nextLine();

			System.out.print("price: ");
			Scanner userprice = new Scanner(System.in);
			String priceStr = userprice.nextLine();

			AccountList.add(index - 1, dateStr + " " + itemStr + " " + priceStr); //다시 그 index에 사용자가 입력한거 넣어줌

			// 확인할건지 취소할건지 물어보고 confirm, cancel 함수 호출
			System.out.println("Do you want to save?(y/n)");
			Scanner issave = new Scanner(System.in);
			String saveStr = issave.nextLine();

			if (saveStr.equals("y")) {
				confirm();
			} else {
				cancel();
			}

			System.out.println("Continue to Accountbook?(y/n)");
			Scanner continuescan = new Scanner(System.in);
			String continueStr = continuescan.nextLine();

			if (continueStr.equals("y")) {
				isContinue = false;
			} else {
				isContinue = true;
			}

		} while (!isContinue);

	}

	public static void Delete(int index) throws IOException {
		boolean isContinue = false;
		flag = 1; //confirm함수에 전달

		do {
			// 확인할건지 취소할건지 물어보고 confirm, cancel 함수 호출
			System.out.println("Do you want to save?(y/n)");
			Scanner issave = new Scanner(System.in);
			String saveStr = issave.nextLine();

			if (saveStr.equals("y")) {
				confirm();
			} else {
				cancel();
			}

			System.out.println("Continue to Accountbook?(y/n)");
			Scanner continuescan = new Scanner(System.in);
			String continueStr = continuescan.nextLine();

			if (continueStr.equals("y")) {
				isContinue = false;
			} else {
				isContinue = true;
			}

		} while (!isContinue);
	}

	public static int confirm() throws IOException {//파일에 저장하는 단계

		write = new BufferedWriter(new FileWriter(file));

		if (flag == 0) {// 입력, 수정함수에서 호출함을 의미

			String allcontents = "";

			for (int count = 0; count < AccountList.size(); count++) {
				allcontents += AccountList.get(count).toString() + "\r\n";
			}

			write.write(allcontents);
			write.close();
		} 
		else if (flag == 1) { //삭제함수에서 호출함을 의미
			AccountList.remove(index - 1);

			String allcontents = "";

			for (int count = 0; count < AccountList.size(); count++) {
				allcontents += AccountList.get(count).toString() + "\r\n";
			}

			write.write(allcontents);
			write.close();

		}

		return 0;
	}

	public static int cancel() {
		// 호출한 곳으로 돌아가기
		return 0;
	}

}