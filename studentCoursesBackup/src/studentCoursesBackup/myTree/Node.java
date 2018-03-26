package studentCoursesBackup.myTree;
import java.util.ArrayList;

public class Node implements Cloneable, SubjectI, ObserverI{
    
    public int bNumber;
    public  ArrayList<String> courseNames;
    
    public Node left;
    public Node right;
    public ArrayList<Node> observers=null;
        
    
    /**
     * This Node method is constructor of Node class which initialize the data members
     * @param bnum
     * @param course
     */
    public Node(int bnum, String course){
        
        bNumber=bnum;
        courseNames = new ArrayList<String>();
        courseNames.add(course);
        observers=new ArrayList<Node>();
        left = null;
        right = null;
    }
    /**
     * This method clones the current node
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
    
    /**
     * This method register observer
     * @param o
     */
    
    public void registerObserver(ObserverI o){
		observers.add((Node) o);
	}
    
    
    /**
     * This method remove observer
     * @param o
     */
    public void removeObserver(ObserverI o){
		observers.remove(o);

	}
    /**
     * This method update observer when any courses is remove
     * @param o
     * @param course
     */
    
    public void update(Node o, String course){
		o.courseNames.remove(course);
    }
    
    /**
     * This method notify all clone to update
     * @param o
     * @param course
     */
    
    public void notifyAll(Node o, String course ){
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(o, course);
        }
    }
    /**
     * This method provides courses name
     * @return
     */
    public String getCourse(){
        String course="";
        for(int i=0;i<courseNames.size();i++){
        
            course+=courseNames.get(i);
                 
        }
      return course;  
    }

}
