
package studentCoursesBackup.myTree;

import java.util.ArrayList;

public interface SubjectI {
    
    void registerObserver(ObserverI o);
	void removeObserver(ObserverI o);
	void notifyAll(Node o, String course );
    
}
