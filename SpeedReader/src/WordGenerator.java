import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;




public class WordGenerator {

	int wordCount, sentenceCount;
	public File file;
	public Scanner input;
  
	/**
	 * WordGenerator is a constructor that holds the fields for file location, 
	 * the scanner that reads through the text file, and (after scanner is called), 
	 * the word and sentence count.
	 * 
	 * 
	 */
	public WordGenerator(String filename)throws IOException {

		this.file = new File(filename);
		Scanner sc = new Scanner(this.file);
		this.input=sc;
		this.wordCount=0;
		this.sentenceCount=0;

	}

	/**
	 * 
	 * @return true if there is another word to be processed by scanner, 
		false if at the end of the document
	 * @throws IOException
	 */
	public boolean hasNext() throws IOException {	
		//this.wordCount ++;
		return(this.input.hasNext());

	}
	/**
	 * 
	 * @returns the next word in the scanner
	 */

	public String next(){
		this.wordCount ++;
		String word = this.input.next();
		int length = word.length();
		String last = word.substring(length-1);
		if(last.equals(".") || last.equals("!")|| last.equals("?")){
			this.sentenceCount++;					
		}

		return (word);		
	}

	/**
	 * 
	 * @returns the number of words that have been processed by wordGenerator so far
	 */
	public int getWordCount() {
		return (this.wordCount);
	}
	/**
	 * 
	 * @returns the number of sentences that have been processed by wordGenerator so far
	 */
	public int getSentenceCount() {
		return (this.sentenceCount);
	}

	public static void main(String[] args) throws IOException{
		String name = "/home/yuyue17/csc207/csc207-speed-reader/test.txt";
		WordGenerator g1 = new WordGenerator(name);

		System.out.println(g1.hasNext());
		System.out.println(g1.next());
		System.out.println(g1.next());
		System.out.println(g1.next());
		System.out.println(g1.getWordCount());
		System.out.println(g1.getSentenceCount());
	}
}

