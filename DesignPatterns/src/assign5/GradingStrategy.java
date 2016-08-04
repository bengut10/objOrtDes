package assign5;

import java.util.ArrayList;

/**
 * Class Grading Strategy determines the strategy 
 * that will be implemented for grading.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public interface GradingStrategy 
{
	/**
	 * Calculates the average score of a student.
	 * @param exams List of exams scores of a student.
	 * @param assigns list of assignment scores of a student.
	 * @return the average grade of a student.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	public double computeAverage(ArrayList<Double>exams, 
			ArrayList<Double>assigns);
}
