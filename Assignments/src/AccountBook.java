
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

			file = new File("accountbook.txt");

			AccountList = new ArrayList<String>();

			boolean isExists = file.exists();
			if (isExists) { // 파일 존재할 때 내용 읽어오기

				read = new BufferedReader(new FileReader(file));
				String s;
				int count = 1;

				System.out.println("_________________________");
				System.out.println("index\t | contents");

				while ((s = read.readLine()) != null) {
					AccountList.add(s);
					System.out.println(count + "\t | " + AccountList.get(count - 1).toString());
					count++;
				}
				read.close();
			}

			else {
				System.out.println("not imformation");
			}

			// 가계부 리스트 화면에 뿌려주기
			System.out.println("_________________________");
			System.out.println("\n--- AccountBook menu---");
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
				System.out.print("date: ");

				Scanner userdate = new Scanner(System.in);
				String dateStr = userdate.nextLine();

				System.out.print("item: ");
				Scanner useritem = new Scanner(System.in);
				String itemStr = useritem.nextLine();

				System.out.print("price: ");
				Scanner userprice = new Scanner(System.in);
				String priceStr = userprice.nextLine();

				String contents = dateStr + " " + itemStr + " " + priceStr;

				AccountList = Insert(AccountList, contents);
				isSave(AccountList, file);
				break;

			case 2:
				System.out.print("Enter index to Modify : ");
				index = scan.nextInt();

				System.out.print("date: ");

				Scanner userdate1 = new Scanner(System.in);
				String dateStr1 = userdate1.nextLine();

				System.out.print("item: ");
				Scanner useritem1 = new Scanner(System.in);
				String itemStr1 = useritem1.nextLine();

				System.out.print("price: ");
				Scanner userprice1 = new Scanner(System.in);
				String priceStr1 = userprice1.nextLine();

				String contents1 = dateStr1 + " " + itemStr1 + " " + priceStr1;

				AccountList = Modify(AccountList, index, contents1);
				isSave(AccountList, file);
				break;

			case 3:
				System.out.print("Enter index to Delete : ");
				index = scan.nextInt();
				AccountList = Delete(AccountList, index);
				isSave(AccountList, file);
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

	public static List<String> Insert(List<String> AccountList, String contents) {

		AccountList.add(contents);
		return AccountList;

	}

	public static List<String> Modify(List<String> AccountList, int index, String contents) {

		AccountList.remove(index - 1); // 수정할 레코드 삭제 (array라서 -1 해줌)
		AccountList.add(index - 1, contents);
		return AccountList;

	}

	public static List<String> Delete(List<String> AccountList, int index) {

		AccountList.remove(index - 1);
		return AccountList;
	}

	public static void isSave(List<String> AccountList, File file) throws IOException {
		System.out.println("Do you want to save?(y/n)");
		Scanner issave = new Scanner(System.in);
		String saveStr = issave.nextLine();

		if (saveStr.equals("y")) {
			confirm(AccountList, file);
		} else {
			cancel();
		}

	}

	public static long confirm(List<String> AccountList, File file) throws IOException {

		write = new BufferedWriter(new FileWriter(file));
		long fileSize;

		String allcontents = "";

		for (int count = 0; count < AccountList.size(); count++) {
			allcontents += AccountList.get(count).toString() + "\r\n";
		}

		write.write(allcontents);
		write.close();

		fileSize = file.length();
		return fileSize;

	}

	public static int cancel() {
		// 호출한 곳으로 돌아가기
		return 0;
	}

}