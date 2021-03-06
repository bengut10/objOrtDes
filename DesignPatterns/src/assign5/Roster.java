package assign5;

import java.util.*;

/**
 * Represents a class of students.
 * @author Jill Seaman
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 *
 */
public class Roster {
    
    private String courseName;             // Class name
    @SuppressWarnings("unused")
	private String courseNumber;           // Course number, like cs2308
    private ArrayList<Student> students;   // list of students in the course
   
    /**
     * Returns the list of students in the course.
     * @return the list of students in the course.
     */
    public ArrayList<Student> getRoster()
    {
    	return this.students;
    }
    
    /**
     * Constructs the roster from its name and number
     * @param name   the course name.
     * @param number the course number.
     */
    public Roster(String name, String number) {
        this.courseName = name;
        this.courseNumber = number;
        students = new ArrayList<Student>();
    }
    
    /**
     * @return the course name.
     */
    public String getCourseName() {
        return courseName;
    }
    
    /**
     * Adds a Student to the list.
     * @param student the Student to add
     */
    public void addStudent (Student student) {
        students.add(student);
    }
    
   public Iterator <Double> averageIterator()
   {
	   return new
			   Iterator<Double>(){
		   private int rosterIndex = 0;
		   
		   @Override
		   public boolean hasNext()
		   {
			   return rosterIndex < students.size();
		   }
		   @Override
		   public Double next()
		   {
			   Double result;
			   if(hasNext())
			   {
				   result = students.get(rosterIndex).getAverage();
				   rosterIndex++;
				   return result;
			   }
			   else
			   {
				   throw new NoSuchElementException();
			   }
		   }
		   
		   
	   };
   }
    
}
