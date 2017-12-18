import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Memo {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// memo class
		File file;
		List<String> MemoList;
		int menuSelection;
		boolean exitMemo = false;
		int index;
		System.out.println("\n<Start Memo>");
		// file open

		do {
			file = new File("memo.txt");// 파일 여부
			MemoList = new ArrayList<String>();
			boolean isExists = file.exists();
			if (isExists) { // 파일 존재할 때 내용 읽어오기

				BufferedReader read = new BufferedReader(new FileReader(file));
				String s;
				int count = 1;
				System.out.println("_________________________");
				System.out.println("index\t | contents");
				
				
				while ((s = read.readLine()) != null) {
					// System.out.println(s);
					MemoList.add(s);// 배열리스트에 저장
					System.out.println(count + "\t | " + MemoList.get(count - 1).toString());
					count++;
				}
				read.close();
			}

			else { // 파일 새로 생성하기
				System.out.println("not imformation");

			}
			// 메모리스트 화면에 뿌려주기
			System.out.println("_________________________");
			System.out.println("\n-------Memo menu-------");
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
				System.out.print("write the contents : ");
				Scanner scanContents = new Scanner(System.in);
				String contents = scanContents.next();
				MemoList = Insert(MemoList,contents);
				isSave(MemoList,file);
				break;

			case 2:
				System.out.print("Enter index to Modify : ");
				index = scan.nextInt();
				MemoList = Modify(MemoList,index);
				isSave(MemoList,file);
				break;
			case 3:
				System.out.print("Enter index to Delete : ");
				index = scan.nextInt();
				MemoList = Delete(MemoList,index);
				isSave(MemoList,file);
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

	public static List<String> Insert(List<String> MemoList,String contents){
		
		MemoList.add(contents);
		
		return MemoList;
	}

	public static List<String> Modify(List<String> MemoList,int index){
		System.out.print("write modified contents : ");
		Scanner scan = new Scanner(System.in);
		String contents = scan.next();
		MemoList.remove(index-1);
		MemoList.add(index-1,contents);
		
		return MemoList;
	}

	public static List<String> Delete(List<String> MemoList,int index){
		MemoList.remove(index - 1);
		return MemoList;
	}

	public static void isSave(List<String> MemoList, File file) throws IOException {
		System.out.println("Do you want to save?(y/n)");
		Scanner issave = new Scanner(System.in);
		String saveStr = issave.nextLine();
		
		if (saveStr.equals("y")) {
			confirm(MemoList, file);
		} else {
			cancel();
		}
	
	}
	
	public static long confirm(List<String> MemoList,File file) throws IOException {

		BufferedWriter write = new BufferedWriter(new FileWriter(file));
		long fileSize;
		
		String allcontents = "";

		for (int count = 0; count < MemoList.size(); count++) {
			allcontents += MemoList.get(count).toString() + "\r\n";
		}
		
		write.write(allcontents);
		write.close();
		
		fileSize = file.length();
		return fileSize;
	}

	public static int cancel() {

		return 0;
	}
	
	
}