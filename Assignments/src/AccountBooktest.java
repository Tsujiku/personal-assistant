import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AccountBooktest {

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws IOException {
		
		File file = new File("accountbook.txt");

		List<String> AccountList = new ArrayList<String>();

		boolean isExists = file.exists();
		if (isExists) { // 파일 존재할 때 내용 읽어오기

			BufferedReader read = new BufferedReader(new FileReader(file));
			String s;
			int count = 1;

			while ((s = read.readLine()) != null) {
				AccountList.add(s);
				System.out.println("index : " + count + "||" + AccountList.get(count - 1).toString());
				count++;
			}
			read.close();
		}

		else {
			System.out.println("not imformation");
		}

		
		AccountBook acc = new AccountBook();
		
		int length = AccountList.size();
		System.out.println(length);
		
		int random = (int) (Math.random()*length)+1;
		System.out.println(random);
		
		assertTrue(acc.Delete(random-1) < length);
		
		
		//fail("Not yet implemented");
	}

}
