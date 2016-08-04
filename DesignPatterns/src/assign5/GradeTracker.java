package assign5;

import java.util.Observable;
import java.util.Observer;

/**
 * Class GradeTracker updates the letter grade of a
 * student when notified.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class GradeTracker implements Observer {

	String letterGrade = null;
	
	/**
	 * Class GradeTracker constructs a gradeTracker object
	 * for a given student.
	 * @param Student object.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	public GradeTracker(Student student) 
	{
		student.addObserver(this);
		setLetterGrade(student.getAverage());
	}

	/**
	 * Returns the lettergrade of a student.
	 * @return lettergrade of a student.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	public String getLetterGrade() 
	{
		return letterGrade;
	}
	
	@Override
	public void update(Observable o, Object arg) 
	{
		Student student = (Student) o;
		setLetterGrade(student.getAverage());
	}
	
	/**
	 * Determines the lettergrade of a student based on 
	 * the average.
	 * @param grade average of a student.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
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
