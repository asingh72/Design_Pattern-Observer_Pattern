## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt

-----------------------------------------------------------------------

Implemented methods 
1) registerObserver(...), 
2) removeObserver(...), 
3) notifyAll(...), 
4) update(...)
deleteCourse(...) in TreeBuilder.java class calls the notifyAll(...) method after each line of delete file is processed.
clone method is implemented in Node.java class which is called from Driver.java class.
 
-----------------------------------------------------------------------

Citations

(1) http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
(2) https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
 

