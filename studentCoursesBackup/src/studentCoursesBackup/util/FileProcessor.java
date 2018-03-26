
package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class FileProcessor {
    private BufferedReader reader;
    private int linenumber;
    private String filename;
    public int countLines;
    private String line;
    
    /**
     * Constructor for FileProcessor class
     * @param r
     * @param Filename
     */
    public FileProcessor(BufferedReader r,String Filename){
        reader=r;
        filename=Filename;
        linenumber=0;
        
        try
        {
            while((line=reader.readLine())!=null){
                countLines++;
            }
        }
        catch(Exception ex)
        {
            
        }
        
    }
    /**
     * Reads line
     * @return
     */
    public String readLine()
    {
        
        String line="";
        try{
            Stream<String>lines=Files.lines(Paths.get(filename));
            line =lines.skip(linenumber).findFirst().get();
            linenumber++;
            return line;
        
        }
        catch(Exception ex)
        {
            
        }
        return "";
        
    }
}
