
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;


/* Citation
 * http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
 */

public class TreeBuilder {
    
    Results r=new Results("");
    public Node root,c1,c2,c3,c4,c5,c6;
    /**
     * constructor for TreeBuilder class
     */
    public TreeBuilder(){
    
        this.root = null;
        
    }
    
    /**
     * inserting bnumber and course both if bnumber is not present.
     * insert only course if bnumber is present
     * @param bNum
     * @param course
     * @throws CloneNotSupportedException
     */
    public void insert(int bNum, String course) throws CloneNotSupportedException{
        Node newNode = new Node(bNum,course);
        if(root==null){
            root = newNode;
        
            c1=(Node) root.clone();
            c2=(Node) root.clone();
     
            newNode.registerObserver(c1);
            newNode.registerObserver(c2);
            
            return;
        }
        Node current = root;
        Node parent = null;
        Node c1parent=null;
        Node c2parent=null;
        Node c1current=c1;
        Node c2current=c2;
        
        
        Node temp=find(bNum);
        
        if(find(bNum)!=null){
            
            temp.courseNames.add(course);
        
            
        }else{
     
        while(true){
            
            parent = current;
            c1parent = c1current;
            c2parent=c2current;
            
            if(bNum<current.bNumber){
                current = current.left;
                c1current=c1current.left;
                c2current=c2current.left;
                Node c3=(Node) newNode.clone();
                Node c4=(Node) newNode.clone();
                newNode.registerObserver(c3);
                newNode.registerObserver(c4);
                if(current==null){
                    parent.left = newNode;
                    c1parent.left=c3;
                    c2parent.left=c4;
                    
                    return;
                }
                }else{
                    current = current.right;
                    c1current=c1current.right;
                    c2current=c2current.right;
                    Node c5=(Node) newNode.clone();
                    Node c6=(Node) newNode.clone();
                    newNode.registerObserver(c5);
                    newNode.registerObserver(c6);
                    if(current==null){
                        parent.right = newNode;
                        c1parent.right=c5;
                        c2parent.right=c6;
                        return;
                    }
                }
            }
        }
        }
    /**
     * checks if the bnumber is present or not
     * @param value
     * @return
     */
    
    public Node find(int value){
        Node current = root;
        while(current != null){
            if(current.bNumber == value){
                return current;
            }else if(current.bNumber > value){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        current = null;
        return current;
	}
    
    /**
     * remove course after finding bnumber using find method
     * @param bNum
     * @param course
     */
   public void remove(int bNum, String course){
   
       Node temp=find(bNum);
       temp.courseNames.remove(course);
       temp.notifyAll(temp, course);
   }
   
    /**
     * display tree
     * @param root
     * @param r
     */
    public void display(Node root,Results r){
        if(root!=null){
            display(root.left,r);
            String course=root.getCourse();
            String courses="";
            for(int i=0;i<root.courseNames.size();i++){
                courses+=root.courseNames.get(i);
            }
            String s=root.bNumber+" "+courses;
            r.storeNewResult(s);
		display(root.right,r);
        }
    }

}
