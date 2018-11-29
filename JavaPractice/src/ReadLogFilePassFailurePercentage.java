import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * This is a snippet of a static log file:

YYYYMMDD_hh:mm:ss::jobname::status::<message>

20170304_16:24:32::foo::PASS::success
20170304_16:48:32::bar::PASS::Yay!
20170304_16:50:42::baz::FAIL::OOM
20170304_16:51:06::job::FAIL::syntax error
20170304_17:03:21::job1::PASS::
20170304_17:27:19::job2::FAIL::halt
20170304_17:30:05::job3::FAIL::pki cert error
20170304_18:01:55::job2::FAIL::
20170304_18:45:22::job3::FAIL::pki cert error

write a function that takes the log file name as an argument, extract all the PASSes and print them out to screen in the following format, make sure it's sorted by date/time:

PASS 95%
    date_time, jobname, message (if any)
    date_time, jobname
    date_time, jobname, message
FAIL 5%
    date_time, jobname, message (if any)
    date_time, jobname
    date_time, jobname, message
 * 
 */

public class ReadLogFilePassFailurePercentage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPassLoggingInformation("//Users/divyesh.shah/Documents/workspace/JavaPractice/inputFileName.txt");
	}

	static void printPassLoggingInformation(String inputFileNameWithPath) {
        
        if(inputFileNameWithPath == null || inputFileNameWithPath.length() == 0)
            throw new IllegalArgumentException("Pass valid input");
            
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(inputFileNameWithPath));
            String currentline = reader.readLine();
            float totalcounter = 0;
            float totalpass = 0;
            List<String> passResult = new ArrayList<>();
            List<String> failResult = new ArrayList<>();
            while(currentline != null) {
                
                String[] wordsplit = currentline.split("::");
                if(wordsplit[2].equals("PASS")) {
                   if(wordsplit.length > 3) {
                        passResult.add(String.format("%s,%s,%s", wordsplit[0],wordsplit[1],wordsplit[3]));
                   }
                    else{
                        passResult.add(String.format("%s,%s", wordsplit[0],wordsplit[1]));
                    }
                    totalpass++;
                }
                else {
                    if(wordsplit.length > 3) {
                        failResult.add(String.format("%s,%s,%s", wordsplit[0],wordsplit[1],wordsplit[3]));
                    }
                    else {
                        failResult.add(String.format("%s,%s", wordsplit[0],wordsplit[1]));
                    }
                }
                totalcounter++;
                /*
                if(wordsplit[3] != " ")
                    System.out.println(String.format("%s,%s,%s", wordsplit[0],wordsplit[1],wordsplit[3]));
                else
                    System.out.println(String.format("%s,%s", wordsplit[0],wordsplit[1]));      
                */
                currentline = reader.readLine();
            }
            
            reader.close();
            
            System.out.println(String.format("%.2f",(totalpass/totalcounter)*100));
            for(String s : passResult)
                System.out.println(s);
            
            System.out.println(String.format("%.2f",(totalcounter - totalpass)/totalcounter * 100));
            for(String s : failResult)
                System.out.println(s);
                
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
