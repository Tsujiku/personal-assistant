// �ڵ��ٸ��� Ctrl+Shift+F

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AccountBook {

	public static int flag=0;
	public static int index=0;
	public static BufferedWriter write;
	public static BufferedReader read;
	
	public static ArrayList<String> AccountList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int menuSelection;
		boolean exitAccountbook = false;

		System.out.println("<Start Accountbook>");

		do {
			//����� ������ ����� ������ ���� �� ȣ��
			//���� ���� ������ �迭 ����Ʈ�� ����
			
			
			File file = new File("C:\\Users\\sookmyung\\accountbook.txt");
			
			boolean isExists = file.exists(); 
			if(isExists) { //���� ������ �� ���� �о����
				
				read = new BufferedReader(new FileReader("C:\\Users\\sookmyung\\accountbook.txt"));
				String s = read.readLine();
			    System.out.println(s);
			   
			    String[] results = s.split("\\s");

			    for (int i = 0; i < results.length; i++) {
			    	System.out.println(results[i]);
			    	}    
		     
			} 
			
			else { //���� ���� �����ϱ� 
				
				write = new BufferedWriter(new FileWriter("C:\\Users\\sookmyung\\accountbook.txt"));
			     
			}  
		
			     /*String s = "��� ���Ͽ� ����� �̷� ���� ���ڿ��Դϴ�.";

			      write.write(s); 
			      write.newLine();
			      write.write(s); 
			      write.newLine();

			      write.close();*/
			      
			
			AccountList = new ArrayList<>();
			//AccountList.add(arg0);
			
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
			write = new BufferedWriter(new FileWriter("C:\\Users\\sookmyung\\accountbook.txt"));
			
			// TODO ����� �Է½� �����ϱ�
			System.out.print("date: ");

			Scanner userdate = new Scanner(System.in);
			String dateStr = userdate.nextLine();
			
		    write.write(dateStr); 
		    write.write(" ");
		  //  write.newLine();


			System.out.print("item: ");

			Scanner useritem = new Scanner(System.in);
			String itemStr = useritem.nextLine();
			
			write.write(itemStr); 
			write.write(" ");

			System.out.print("price: ");

			Scanner userprice = new Scanner(System.in);
			String priceStr = userprice.nextLine();
			
			write.write(priceStr); 
			write.newLine();
			
			write.close();
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

	public static void Delete(int index) {
		System.out.println(index);
	}
	
	public static int confirm() {
		// �׷� ���� �Լ������� ȣ����? ������ index ��ȭ�� ������ ������
		// update �����Ƿ� confirm �Լ��� �̿��� ����� ������ ���Ͽ� �����ؾ���.
		if (flag == 0)
		{
			//�Է��Լ������� ȣ��
			index++;
		}
		else if (flag == 1)
		{
			//�����Լ������� ȣ��
			index--;
		}
		
		return 0;
	}
	
	public static int cancel() {
		// �������� ���ư��� 
		return 0;
	}
	
	
}
