
package studentCoursesBackup.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String finalResultPath;
    private  ArrayList<String> test = new ArrayList<String>();
    
    
    /**
     * constructor for Results class
     * @param fileName
     */
    
    public Results(String fileName){
		finalResultPath = fileName;
	}
    /**
     * write to output file
     * @param s
     */
    @Override
    public void writeToFile(String s){
        try{
            PrintWriter writer = new PrintWriter(finalResultPath);
            for(String res:test){
            
                writer.write(res+"\n");
            }
            writer.flush();
            
            
        }catch(IOException e){
        
        }
    
        
    }
    /**
     * Stores results to results array list
     * @param testResults
     */
    public void storeNewResult(String testResults){
        test.add(testResults);
    }
    /**
     * implementating interface
     */
    //@Override
    public void writeToStdout() {
        for (String s : test){
            System.out.println(s);
        }
    }

    
}
