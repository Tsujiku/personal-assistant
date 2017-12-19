import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MemoTest {
	@Test
	public void testInsert(){
		Memo memo = new Memo();
		List<String> MemoList = new ArrayList<String>();
		String testStr = "testContents";
		assertTrue(MemoList.size() - memo.Insert(MemoList,testStr).size() == -1);
	}
	@Test
	public void testDelete(){
		Memo memo = new Memo();
		List<String> MemoList = new ArrayList<String>();
		MemoList.add("testContets");
		assertTrue(MemoList.size() - memo.Delete(MemoList,1).size() == 1);
	}
	@Test
	public void testModify() {
		Memo memo = new Memo();
		List<String> MemoList = new ArrayList<String>();
		String beforeContents = "beforeContents";
		String afterContents = "afterContents";
		int index = 1;
		
		MemoList.add(beforeContents);
		assertNotEquals(beforeContents,memo.Modify(MemoList, index, afterContents).get(index-1));
	}

	@Test
	public void testConfirm() throws IOException{
		Memo memo = new Memo();
		File file = new File("test.txt");
		List<String> MemoList = new ArrayList<String>();
		long beforefileSize = file.length();
		long afterfileSize;
		
		MemoList.add("testContets");
		afterfileSize = memo.confirm(MemoList,file);
		file.delete();
		
		assertNotEquals(beforefileSize,afterfileSize);
	}

}
