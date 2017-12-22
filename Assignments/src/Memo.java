import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Memo {
	public static void main(String[] args) throws IOException {
		File file;
		List<String> MemoList;
		int menuSelection;
		boolean exitMemo = false;
		int index;
		String contents;
		
		System.out.println("\n<Start Memo>");
		do {
			file = new File("memo.txt");
			MemoList = new ArrayList<String>();
			boolean isExists = file.exists();

			if (isExists) { 
				BufferedReader fileread = new BufferedReader(new FileReader(file));
				String readLine;
				int count = 1;

				System.out.println("_________________________");
				System.out.println("index\t | contents");

				while ((readLine = fileread.readLine()) != null) {
					MemoList.add(readLine);
					System.out.println(count + "\t | " + MemoList.get(count - 1).toString());
					count++;
				}
				fileread.close();
			}
			else {
				System.out.println("not imformation");
			}

			System.out.println("_________________________");
			System.out.println("\n-------Memo menu-------");
			System.out.println("1. Insert");
			System.out.println("2. Modify");
			System.out.println("3. Delete");
			System.out.println("4. Exit Memo");
			System.out.println("-----------------------");
			System.out.print("Press 1/2/3/4: ");

			Scanner scanNumber = new Scanner(System.in);
			menuSelection = scanNumber.nextInt();

			switch (menuSelection) {
			case 1:
				contents = WriteContents();
				MemoList = Insert(MemoList,contents);
				isSave(MemoList,file);
				break;

			case 2:
				System.out.print("Enter index to Modify : ");
				index = scanNumber.nextInt();
				if(index>0 && index<=MemoList.size()){
					contents = WriteContents();
					MemoList = Modify(MemoList,index,contents);
					isSave(MemoList,file);
				}
				else{
					System.out.println("This index does not Exist");
				}
				break;

			case 3:
				System.out.print("Enter index to Delete : ");
				index = scanNumber.nextInt();
				if(index>0 && index<=MemoList.size()){
					MemoList = Delete(MemoList,index);
					isSave(MemoList,file);
				}		
				else{
					System.out.println("This index does not Exist");
				}
				break;

			case 4:
				exitMemo = true;
				break;

			default:
				break;
			}
		} while (!exitMemo);

		System.out.println("<End Memo>");
	}

	public static String WriteContents(){
		System.out.print("write the contents : ");
		Scanner scanContents = new Scanner(System.in);
		String contents = scanContents.next();

		return contents;
	}

	public static List<String> Insert(List<String> MemoList,String contents){
		MemoList.add(contents);

		return MemoList;
	}

	public static List<String> Modify(List<String> MemoList,int index,String contents){
		MemoList.remove(index-1);
		MemoList.add(index-1,contents);

		return MemoList;
	}

	public static List<String> Delete(List<String> MemoList,int index){
		MemoList.remove(index - 1);

		return MemoList;
	}

	public static void isSave(List<String> MemoList, File file) throws IOException {
		System.out.print("Do you want to save?(y/n)");
		Scanner isSave = new Scanner(System.in);
		String saveString = isSave.nextLine();

		if (saveString.equals("y")) {
			confirm(MemoList, file);
		} else {
			cancel();
		}
	}

	public static long confirm(List<String> MemoList,File file) throws IOException {
		BufferedWriter writefile = new BufferedWriter(new FileWriter(file));
		long fileSize;	
		String allContents = "";
 
		for (int count = 0; count < MemoList.size(); count++) {
			allContents += MemoList.get(count).toString() + "\r\n";
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