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
	
	public static int flag=0;
	public static int index=0;
	
	public static String priceStr;
	public static String itemStr;
	public static String dateStr;
	
	
	
	public static void main(String[] args) throws IOException {
	
		int menuSelection;
		boolean exitAccountbook = false;

		System.out.println("<Start Accountbook>");

		do {
			//����� ������ ����� ������ ���� �� ȣ��
			//���� ���� ������ �迭 ����Ʈ�� ����
			
			
			file = new File("C:\\Users\\sookmyung\\accountbook.txt");
			
			AccountList = new ArrayList<String>();
			
			boolean isExists = file.exists(); 
			if(isExists) { //���� ������ �� ���� �о����
				
				read = new BufferedReader(new FileReader(file));
				String s;
				int count = 1;
				
			    while ((s = read.readLine()) != null) {
			    	AccountList.add(s);
			    	System.out.println("index : " + count + "||" + AccountList.get(count-1).toString());
			    	count++;
			    }
			    read.close();
			    //String[] results = s.split("\\s");

			    //for (int i = 0; i < results.length; i++) {
			    	//System.out.println(results[i]);
			    	//}    
		     
			} 
			
			else { //���� ���� �����ϱ� 
				
				System.out.println("not imformation");
				
				//write = new BufferedWriter(new FileWriter("C:\\Users\\sookmyung\\accountbook.txt"));
			     
			}  
		
			
			//����� ����Ʈ ȭ�鿡 �ѷ��ֱ�
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

		// TODO Ŭ���� �����Ű��

	}

	public static void Insert() throws IOException {

		boolean isContinue = false;
		flag = 0;

		do {
			
			// user�� �Է��� �� ���Ⱑ �ִ� ��ǰ���̿��� ���� ����!!!!!!! 
			// ��¥, ��ǰ��, ���� ���� ���� (�ڵ� ��ü������ ���Ͽ� " "�� �־��ָ�, �� �������� split �̿��Ͽ� �����ϱ� ����)
			System.out.print("date: ");

			Scanner userdate = new Scanner(System.in);
			String dateStr = userdate.nextLine();
			
			AccountList.add(dateStr);


			System.out.print("item: ");

			Scanner useritem = new Scanner(System.in);
			String itemStr = useritem.nextLine();
		
			AccountList.add(itemStr);

			System.out.print("price: ");

			Scanner userprice = new Scanner(System.in);
			String priceStr = userprice.nextLine();
			
			AccountList.add(priceStr);
			
			confirm();
			
			//Ȯ���Ұ��� ����Ұ��� ����� confirm, cancel �Լ� ȣ��
			
			
			//Ȯ���̴��� ��Ҵ��� �����ϰ� return 0;�� �� �� ȣ���� �� ���ķ� ���ƿ��� ������
			//�� �� ���� ��ɾ� ����� ���̶� ������. 

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

	public static void Modify(int index) {
		System.out.println(index);
	}

	public static void Delete(int index) throws IOException {
		System.out.println(index-1);
		confirm();
	}
	
	public static int confirm() throws IOException {
		// �׷� ���� �Լ������� ȣ����? ������ index ��ȭ�� ������ ������
		// update �����Ƿ� confirm �Լ��� �̿��� ����� ������ ���Ͽ� �����ؾ���.
		write = new BufferedWriter(new FileWriter(file));
		
		String allcontents = dateStr + " " + itemStr + " " + priceStr;
		
		for(int count=0; count<AccountList.size(); count++) {
				allcontents += AccountList.get(count).toString()+"\r\n";
		}
		
		write.write(allcontents);
		write.close();
		
		return 0;
	}
	
	public static int cancel() {
		// �������� ���ư��� 
		return 0;
	}
	
	
}
