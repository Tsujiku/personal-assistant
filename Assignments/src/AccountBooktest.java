import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AccountBooktest {

	@Test
	public void testInsert() throws IOException {
		
		List<String> AccountList = new ArrayList<String>();
		String insertString = "1218" + " " + "감기약" + " " + "8300";
		
		int initalSize = AccountList.size();
		int finalSize = AccountBook.Insert(AccountList, insertString).size();
		assertTrue(initalSize < finalSize);
		
	}
	
	@Test
	public void testModify() throws IOException {
	
		List<String> AccountList = new ArrayList<String>();
		
		AccountList.add("1117" + " " + "블루투스이어폰" + " " + "39900");
		AccountList.add("1209" + " " + "화장품" + " " + "100000");
		AccountList.add("1210" + " " + "코트" + " " + "249000");
		AccountList.add("1217" + " " + "빵" + " " + "13000");
		AccountList.add("1220" + " " + "침대" + " " + "650000");
		
		int random = (int) (Math.random() * AccountList.size()) + 1;
	    String initalString = AccountList.get(random-1);
        
    
        String updateString = "1219" + " " + "침대" + " " + "649000";
        AccountBook.Modify(AccountList, random, updateString);
        
        String finalString = AccountList.get(random-1);
        
        assertNotEquals(initalString, finalString);
	
	}

	@Test
	public void testDelete() throws IOException {
		
		List<String> AccountList = new ArrayList<String>();
		AccountList.add("1219" + " " + "침대" + " " + "649000");
		
		int initalSize = AccountList.size();
		int finalSize = AccountBook.Delete(AccountList,1).size();
		assertTrue(initalSize > finalSize);
		
	}

}
