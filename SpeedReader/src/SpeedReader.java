import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
public class SpeedReader {

	
	public static void SpeedReader (String filename, int width, int height, int fontSize, long wpm) throws IOException, InterruptedException{
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontSize);
		g.setFont(f);	
		WordGenerator wg = new WordGenerator(filename);
		
		double sleepTime = 60.0 / wpm;
		//System.out.println(sleepTime);
		
		double sleepCount = sleepTime*1000;
		
		//System.out.println(sleepCount);
	
		while(wg.hasNext()) {
			panel.clear();
			g.drawString(wg.next(), 100, 100);
			Thread.sleep((long)sleepCount);
			
		}
		System.out.println("You read " + wg.getWordCount() +" words");
		System.out.println("You read " + wg.getSentenceCount() +" sentences");
	}
		
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Enter a file location: ");
		//our suggestion for file path /home/yuyue17/csc207/csc207-speed-reader/test.txt
		Scanner sc1 = new Scanner(System.in);
		String filename = sc1.nextLine();
		
		System.out.println("Enter the width of the panel: ");
		Scanner sc2 = new Scanner(System.in);
		int width = sc2.nextInt();
		
		System.out.println("Enter the height of the panel: ");
		Scanner sc3 = new Scanner(System.in);
		int height = sc3.nextInt();
		
		System.out.println("Enter the fontSize: ");
		Scanner sc4 = new Scanner(System.in);
		int fontSize = sc4.nextInt();
		
		System.out.println("Enter the number of words per minute: ");
		Scanner sc5 = new Scanner(System.in);
		long wpm = sc5.nextInt();
		
		SpeedReader(filename, width, height, fontSize, wpm);
	}

}
