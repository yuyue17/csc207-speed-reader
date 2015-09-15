import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;


public class WordGeneratorTest extends TestCase {
	String filename = "/home/yuyue17/csc207/csc207-speed-reader/test.txt";
	

	
	@Test
	public void testHasNext() throws IOException {		
		
		WordGenerator g1 = new WordGenerator(filename);
		boolean result = g1.hasNext();	
		assertEquals("result=True", true, result);
	}

	@Test
	public void testNextTest() throws IOException{
		
		WordGenerator g1 = new WordGenerator(filename);
		
		assertEquals("g1.next = Des", "Des", g1.next());	
		assertEquals("g1.next = Moines", "Moines", g1.next());
		assertEquals("g1.next = is", "is", g1.next());	
	}

	 @Test 
	  public void testGetWordCountTest() throws IOException{
		 WordGenerator g1 = new WordGenerator(filename);
	while (g1.hasNext()){
		g1.next();
	}
		 int wordCount=g1.wordCount;
			assertEquals("wordCount = 54", 54, wordCount);
			
	 }
	@Test
	 public void testGetSentenceCountTest() throws IOException{
		 WordGenerator g1 = new WordGenerator(filename);
		while (g1.hasNext()){
			g1.next();
		}
		 int sentenceCount=g1.sentenceCount;
			assertEquals("sentenceCount = ", 4, sentenceCount);
			
	}
	 
}
