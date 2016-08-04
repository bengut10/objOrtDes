package assign5;

import java.util.Observable;
import java.util.Observer;

/**
 * GradeTracker is an observer which updates the student's grade
 * and converts a double value to a letter grade.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
//design pattern: Observer
public class GradeTracker implements Observer {

	String letterGrade = null;	// String variable to hold student's letter grade.
	
	
	/**
	 * constructs a GradeTracker object
	 * @param student a Student Object
	 */
	public GradeTracker(Student student) 
	{
		student.addObserver(this);
		setLetterGrade(student.getAverage());
	}

	/**
	 * Accessor method to get the letter grade.
	 * @return letterGrade as a String.
	 */ 
	public String getLetterGrade() 
	{
		return letterGrade;
	}
	
	/**
	 * Replaces the old student grade with an updated grade.
	 * @param o an Observable object.
	 * @param arg an Object 
	 */ 
	@Override
	public void update(Observable o, Object arg) 
	{
		Student student = (Student) o;
		setLetterGrade(student.getAverage());
	}
	
	/**
	 *Changes double value grade to corresponding letter grade.
	 * @param grade a double value representing the student's average.
	 */ 
	public void setLetterGrade(double grade)
	{
		if(grade>= 90)
		{
			this.letterGrade = "A";
			return;
		}
		else if(grade >= 80)
		{
			this.letterGrade = "B";
			return;
		}
		else if(grade >= 70)
		{
			this.letterGrade = "C";
			return;
		}
		else if(grade >= 60)
		{
			this.letterGrade = "D";
			return;
		}
		letterGrade = "F";
	}
}
