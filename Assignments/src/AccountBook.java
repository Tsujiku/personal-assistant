import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountBook {

	public static void main(String[] args) throws IOException {

		File file;
		int menuSelection;
		boolean exitAccountbook = false;
		String contents;
		int index;

		System.out.println("<Start Accountbook>");
		do {
			file = new File("accountbook.txt");
			List<String> AccountList = new ArrayList<String>();
			boolean isExists = file.exists();

			if (isExists) { // 파일 존재할 때 내용 읽어오기
				BufferedReader readfile = new BufferedReader(new FileReader(file));
				String readLine;
				int count = 1;

				System.out.println("___________________________________________________");
				System.out.println("index\t | date \t | itme  \t | price");

				while ((readLine = readfile.readLine()) != null) {
					AccountList.add(readLine);
					String[] divideContents = readLine.split(" ");
					System.out.println(count + "\t | " + divideContents[0] + " \t | " + divideContents[1] + "  \t | "
							+ divideContents[2]);
					count++;
				}
				readfile.close();
			} else {
				System.out.println("not imformation");
			}
			System.out.println("___________________________________________________");
			System.out.println("\n--- AccountBook menu---");
			System.out.println("1. Insert");
			System.out.println("2. Modify");
			System.out.println("3. Delete");
			System.out.println("4. Exit Accountbook");
			System.out.println("-----------------------");
			System.out.print("Press 1/2/3/4: ");

			Scanner scanNumber = new Scanner(System.in);
			menuSelection = scanNumber.nextInt();

			switch (menuSelection) {
			case 1:
				contents = writeContents();
				AccountList = Insert(AccountList, contents);
				isSave(AccountList, file);
				break;

			case 2:
				System.out.print("Enter index to Modify : ");

				index = scanNumber.nextInt();
				if (index > 0 && index <= AccountList.size()) {
					contents = writeContents();
					AccountList = Modify(AccountList, index, contents);
					isSave(AccountList, file);
				} else {
					System.out.println("This index does not Exist");
				}
				break;

			case 3:

				System.out.print("Enter index to Delete : ");

				index = scanNumber.nextInt();
				if (index > 0 && index <= AccountList.size()) {
					AccountList = Delete(AccountList, index);
					isSave(AccountList, file);
				} else {
					System.out.println("This index does not Exist");
				}
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

	public static String writeContents() {
		System.out.println("Don't use 'space bar'");
		Scanner scanContents = new Scanner(System.in);
		
		System.out.print("date: ");
		String dateString = scanContents.nextLine();
		System.out.print("item: ");
		String itemString = scanContents.nextLine();
		System.out.print("price: ");
		String priceString = scanContents.nextLine();
		String contents = dateString + " " + itemString + " " + priceString;
	
		return contents;

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
		Scanner isSave = new Scanner(System.in);
		String saveString = isSave.nextLine();

		if (saveString.equals("y")) {
			confirm(AccountList, file);
		} else {
			cancel();
		}
	}

	public static long confirm(List<String> AccountList, File file) throws IOException {
		BufferedWriter writefile = new BufferedWriter(new FileWriter(file));
		long fileSize;
		String allContents = "";

		for (int count = 0; count < AccountList.size(); count++) {

			allContents += AccountList.get(count).toString() + "\r\n";

		}
		writefile.write(allContents);
		writefile.close();
		fileSize = file.length();

		return fileSize;
	}

	public static int cancel() {
		return 0;
	}
}