package assign5;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Class Grading Strategy determines the strategy 
 * that will be implemented for grading.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
=======
 * GradingStrategy Interface holds the computeAverage method.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
//Design Pattern: Strategy
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
public interface GradingStrategy 
{
	/**
<<<<<<< HEAD
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
=======
	 * @param exams an ArrayList of exam objects.
	 * @param assigns an ArrayList of assignment objects.
	 * @return the average of the student's exams and assigns as a double.
	 */ 
	public double computeAverage(ArrayList<Double>exams, ArrayList<Double>assigns);
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
}
