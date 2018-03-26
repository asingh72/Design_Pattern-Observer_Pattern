package studentCoursesBackup.driver;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;
import java.io.BufferedReader;
import java.io.FileReader;


public class Driver {
    public static void main(String args[]) throws CloneNotSupportedException, Exception{
        String input="";
        String delete="";
        String output1="";
        String output2="";
        String output3="";
        if(args.length != 5){
            throw new RuntimeException("Expected 5 args");
        }
        else{
            input=args[0];
            delete=args[1];
            output1=args[2];
            output2=args[3];
            output3=args[4];
        }
        TreeBuilder b=new TreeBuilder();
        Results r1=new Results(output1);
        Results r2=new Results(output2);
        Results r3=new Results(output3);
        
        try
        {
            BufferedReader ri=new BufferedReader(new FileReader(input));
            BufferedReader rd=new BufferedReader(new FileReader(delete));
            FileProcessor fp=new FileProcessor(ri,input);
            FileProcessor fp1=new FileProcessor(rd,delete);
        
            for(int i=0;i<fp.countLines;i++){
            
                String in=fp.readLine();
                String[] parts=in.split(":");
                int part1=Integer.parseInt(parts[0]);
                String part2=parts[1];
                b.insert(part1, part2);
            }
            for(int i=0;i<fp1.countLines;i++)
            {
                String in=fp1.readLine();
                String[] parts=in.split(":");
                int part1=Integer.parseInt(parts[0]);
                String part2=parts[1];
                b.remove(part1, part2);
            }
        
            b.display(b.root,r1);
            b.display(b.c1,r2);
            b.display(b.c2,r3);
            r1.writeToFile("");
            r2.writeToFile("");
            r3.writeToFile("");
          
           
        }
        catch(Exception ex)
        {
    
        }
    
    }
            
    
}
