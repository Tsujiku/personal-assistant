// 자동줄맞춤 Ctrl+Shift+F

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
			//가계부 내용을 편빕할 파일을 생성 및 호출
			//파일 내의 정보를 배열 리스트에 저장
			
			
			File file = new File("C:\\Users\\sookmyung\\accountbook.txt");
			
			boolean isExists = file.exists(); 
			if(isExists) { //파일 존재할 때 내용 읽어오기
				
				read = new BufferedReader(new FileReader("C:\\Users\\sookmyung\\accountbook.txt"));
				String s = read.readLine();
			    System.out.println(s);
			   
			    String[] results = s.split("\\s");

			    for (int i = 0; i < results.length; i++) {
			    	System.out.println(results[i]);
			    	}    
		     
			} 
			
			else { //파일 새로 생성하기 
				
				write = new BufferedWriter(new FileWriter("C:\\Users\\sookmyung\\accountbook.txt"));
			     
			}  
		
			     /*String s = "출력 파일에 저장될 이런 저런 문자열입니다.";

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

		// TODO 클래스 종료시키기

	}

	public static void Insert() throws IOException {

		boolean isContinue = false;
		flag = 0;

		do {
			write = new BufferedWriter(new FileWriter("C:\\Users\\sookmyung\\accountbook.txt"));
			
			// TODO 사용자 입력식 대응하기
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

	public static void Delete(int index) {
		System.out.println(index);
	}
	
	public static int confirm() {
		// 그럼 수정 함수에서의 호출은? 수정은 index 변화는 없지만 내용이
		// update 됐으므로 confirm 함수를 이용해 변경된 내용을 파일에 저장해야함.
		if (flag == 0)
		{
			//입력함수에서의 호출
			index++;
		}
		else if (flag == 1)
		{
			//삭제함수에서의 호출
			index--;
		}
		
		return 0;
	}
	
	public static int cancel() {
		// 메인으로 돌아가기 
		return 0;
	}
	
	
}
