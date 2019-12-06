import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintListOfFilesOfGivenFolderFindPattern implements Closeable {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		String s;
		Process p = Runtime.getRuntime().exec("grep -rnw ./ -e sum");
		int count=0;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			while((s = br.readLine()) != null) {
				System.out.println("count" + count++ + "\tline\t" + s);
			}
			p.waitFor();
			System.out.println("exit:" + p.exitValue());
			p.destroy();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
