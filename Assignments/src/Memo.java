import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Memo {
	static String FILENAME; // static���� ����
	public static BufferedWriter write;
	public static BufferedReader read;
	public static File file;
	public static List<String> MemoList;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// memo class

		int menuSelection;
		boolean exitMemo = false;
		int index;
		
		
		System.out.println("<Start Memo>");
		// file open

		do {
			file = new File("C:\\Users\\user\\memo.txt");// ���� ����
			MemoList = new ArrayList<String>();
			boolean isExists = file.exists();
			if (isExists) { // ���� ������ �� ���� �о����

				read = new BufferedReader(new FileReader(file));
				String s;
				int count = 1;
				while ((s = read.readLine()) != null) {
					//System.out.println(s);
					MemoList.add(s);//�迭����Ʈ�� ����
					System.out.println("index : " + count + "||" + MemoList.get(count-1).toString());
					count++;
				}
				read.close();
			}

			else { // ���� ���� �����ϱ�
				System.out.println("not imformation");
				
			}
			//�޸𸮽�Ʈ ȭ�鿡 �ѷ��ֱ�
			System.out.println("-------Memo menu-------");
			System.out.println("1. Insert");
			System.out.println("2. Modify");
			System.out.println("3. Delete");
			System.out.println("4. Exit Memo");
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
				exitMemo = true;
				break;

			default:
				break;
			}
		} while (!exitMemo);

		System.out.println("<End Memo>");

		// TODO Ŭ���� �����Ű��

	}

	public static void Insert() throws IOException{
		System.out.print("write the contents : ");
		Scanner scan = new Scanner(System.in);
		String contents = scan.next();
		MemoList.add(contents);
		confirm();

	}

	public static void Modify(int index) {
		System.out.println(index);
	}

	public static void Delete(int index) throws IOException{
		MemoList.remove(index-1);
		confirm();
	}
	public static void confirm() throws IOException{
		
		write = new BufferedWriter(new FileWriter(file));
		
		//���1, �� ��� FileWriter(file, true)�� �ؾ��Ѵ�.
		/*int count = MemoList.size()-1;
		write.write(MemoList.get(count).toString());
		write.newLine();*/
		//���2
		String allcontents="";
		for(int count=0;count<MemoList.size();count++) {
			
			allcontents += MemoList.get(count).toString() +"\r\n";

		}
		write.write(allcontents);
		write.close();
	}
}