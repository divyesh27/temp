import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class PrintLastTwoLinesFromTextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLastLines("//Users/divyesh.shah/Documents/workspace/JavaPractice/input.txt", 3);
	}
	
	public static void printLastLines(String filename, int line) {
		
		StringBuilder sb = new StringBuilder();
		RandomAccessFile randomAccessFile = null;
		int count = 0;
		try {
			randomAccessFile = new RandomAccessFile(filename,"r");
			long lines = randomAccessFile.length()-1;
			randomAccessFile.seek(lines);
			for(long pointer = lines; pointer >=0 && count < line; pointer--) {
				randomAccessFile.seek(pointer);
				char c;
				c = (char)randomAccessFile.read();
				if(c == '\n') {
					count++;
				}
				sb.append(c);
			}
			System.out.println(sb.reverse());
			randomAccessFile.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
