import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a a log file which consists of logging information like (ERROR, INFO, EXCEPTION, etc). Function
 * needs to return list of words with the frequency of occurrence. 
 * For e.g 
 * "03/22 08:51:01 INFO   :...locate_configFile: Specified configuration file: /u/user10/rsvpd1.conf
	03/22 08:51:01 INFO   :.main: Using log level 511
	03/22 08:51:01 EXCEPTION   :..settcpimage: Get TCP images rc - EDC8112I Operation not supported on socket.
	 03 
	03/22 08:51:01 ERROR   :..settcpimage: Associate with TCP/IP image name = TCPCS
	03/22 08:51:02 INFO   :..reg_process: registering process with the system
	03/22 08:51:02 ERROR   :..reg_process: attempt OS/390 registration
	03/22 08:51:02 INFO   :..reg_process: return from registration rc=0 
 * @author divyesh.shah
 *
 */
public class FindMostRepeatedWordFromTextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addDupWords();
	}
	
	public static void addDupWords() {
		
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		BufferedReader reader;
		try {
			
			File f = new File("//Users/divyesh.shah/Documents/workspace/JavaPractice/input.txt");
			reader = new BufferedReader(new FileReader(f));
			String currentline = reader.readLine();
			while(currentline != null) {
				String[] words = currentline.toLowerCase().split(" ");
				for(String word : words) {
					
					if(hm.containsKey(word)) {
						hm.put(word, hm.get(word)+1);
					}
					else {
						hm.put(word, 1);
					}
				}
				currentline = reader.readLine();
			}
			
			for(String key : hm.keySet()) {
				if(hm.get(key) > 1 ) {
					System.out.println("Key " + key + " - " + hm.get(key));
				}
			}
			
			int count = 0;
			String maxOccurence = null;
			
			for(Entry<String, Integer> e : hm.entrySet()) {
				if(e.getValue() > count) {
					maxOccurence = e.getKey();
					count = e.getValue();
				}
			}
			
			System.out.println(maxOccurence);
			
			reader.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
