import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Memo {
	static String FILENAME; // static으로 고정
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
			file = new File("C:\\Users\\user\\memo.txt");// 파일 여부
			MemoList = new ArrayList<String>();
			boolean isExists = file.exists();
			if (isExists) { // 파일 존재할 때 내용 읽어오기

				read = new BufferedReader(new FileReader(file));
				String s;
				int count = 1;
				while ((s = read.readLine()) != null) {
					//System.out.println(s);
					MemoList.add(s);//배열리스트에 저장
					System.out.println("index : " + count + "||" + MemoList.get(count-1).toString());
					count++;
				}
				read.close();
			}

			else { // 파일 새로 생성하기
				System.out.println("not imformation");
				
			}
			//메모리스트 화면에 뿌려주기
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

		// TODO 클래스 종료시키기

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
		
		//방법1, 이 경우 FileWriter(file, true)로 해야한다.
		/*int count = MemoList.size()-1;
		write.write(MemoList.get(count).toString());
		write.newLine();*/
		//방법2
		String allcontents="";
		for(int count=0;count<MemoList.size();count++) {
			
			allcontents += MemoList.get(count).toString() +"\r\n";

		}
		write.write(allcontents);
		write.close();
	}
}