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
			//가계부 내용을 편빕할 파일을 생성 및 호출
			//파일 내의 정보를 배열 리스트에 저장
			
			
			file = new File("C:\\Users\\sookmyung\\accountbook.txt");
			
			AccountList = new ArrayList<String>();
			
			boolean isExists = file.exists(); 
			if(isExists) { //파일 존재할 때 내용 읽어오기
				
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
			
			else { //파일 새로 생성하기 
				
				System.out.println("not imformation");
				
				//write = new BufferedWriter(new FileWriter("C:\\Users\\sookmyung\\accountbook.txt"));
			     
			}  
		
			
			//가계부 리스트 화면에 뿌려주기
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

		// TODO 클래스 종료시키기

	}

	public static void Insert() throws IOException {

		boolean isContinue = false;
		flag = 0;

		do {
			
			// user가 입력할 때 띄어쓰기가 있는 상품명이여도 띄어쓰기 금지!!!!!!! 
			// 날짜, 상품명, 가격 띄어쓰기 금지 (코드 자체적으로 파일에 " "를 넣어주며, 이 공백으로 split 이용하여 구분하기 때문)
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
			
			//확인할건지 취소할건지 물어보고 confirm, cancel 함수 호출
			
			
			//확인이던지 취소던지 수행하고 return 0;을 할 시 호출한 곳 이후로 돌아오기 때문에
			//이 줄 부터 명령어 수행될 것이라 생각됨. 

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
		// 그럼 수정 함수에서의 호출은? 수정은 index 변화는 없지만 내용이
		// update 됐으므로 confirm 함수를 이용해 변경된 내용을 파일에 저장해야함.
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
		// 메인으로 돌아가기 
		return 0;
	}
	
	
}
