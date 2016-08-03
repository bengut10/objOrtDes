package assign5;

import java.util.Observable;
import java.util.Observer;

//design pattern: Observer
public class GradeTracker implements Observer {

	String letterGrade = null;
	
	public GradeTracker(Student student) 
	{
		student.addObserver(this);
		setLetterGrade(student.getAverage());
	}

	public String getLetterGrade() 
	{
		return letterGrade;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Student student = (Student) o;
		setLetterGrade(student.getAverage());
	}
	
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
