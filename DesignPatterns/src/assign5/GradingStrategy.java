package assign5;

import java.util.ArrayList;

/**
 * GradingStrategy Interface holds the computeAverage method.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
//Design Pattern: Strategy
public interface GradingStrategy 
{
	/**
	 * @param exams an ArrayList of exam objects.
	 * @param assigns an ArrayList of assignment objects.
	 * @return the average of the student's exams and assigns as a double.
	 */ 
	public double computeAverage(ArrayList<Double>exams, ArrayList<Double>assigns);
}
