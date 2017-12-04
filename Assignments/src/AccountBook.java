// �ڵ��ٸ��� Ctrl+Shift+F

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
			// ����� ������ ����� ������ ���� �� ȣ��
			// ���� ���� ������ �迭 ����Ʈ�� ����

			file = new File("C:\\sweng\\personal-assistant\\accountbook.txt");

			AccountList = new ArrayList<String>();

			boolean isExists = file.exists();
			if (isExists) { // ���� ������ �� ���� �о����

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

			// ����� ����Ʈ ȭ�鿡 �ѷ��ֱ�
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
		flag = 0; //confirm�Լ��� ����

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

			// Ȯ���Ұ��� ����Ұ��� ����� confirm, cancel �Լ� ȣ��
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

		AccountList.remove(index - 1); //������ ���ڵ� ����  (array�� -1 ����)

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

			AccountList.add(index - 1, dateStr + " " + itemStr + " " + priceStr); //�ٽ� �� index�� ����ڰ� �Է��Ѱ� �־���

			// Ȯ���Ұ��� ����Ұ��� ����� confirm, cancel �Լ� ȣ��
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
		flag = 1; //confirm�Լ��� ����

		do {
			// Ȯ���Ұ��� ����Ұ��� ����� confirm, cancel �Լ� ȣ��
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

	public static int confirm() throws IOException {//���Ͽ� �����ϴ� �ܰ�

		write = new BufferedWriter(new FileWriter(file));

		if (flag == 0) {// �Է�, �����Լ����� ȣ������ �ǹ�

			String allcontents = "";

			for (int count = 0; count < AccountList.size(); count++) {
				allcontents += AccountList.get(count).toString() + "\r\n";
			}

			write.write(allcontents);
			write.close();
		} 
		else if (flag == 1) { //�����Լ����� ȣ������ �ǹ�
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
		// ȣ���� ������ ���ư���
		return 0;
	}

}