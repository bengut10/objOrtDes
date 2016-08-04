package assign5;

import java.util.ArrayList;

/**
 * Class AverageA contains the algorithm for computing the average where the 
 * Assignment average contributes 40%, and the Exam average contributes 60% 
 * to the final class average.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class AverageA implements GradingStrategy {

        /**
         * Computes average of exams and assignments.
         * @param exams an ArrayList of exams.
         * @param assigns an Array list of assignments.
         * @returns the average of the exams and assignments as a double.
         */
	@Override
	public double computeAverage(ArrayList<Double> exams, ArrayList<Double> assigns) {
		double examTotal = 0;
		double assignments = 0;
		
		for(Double ex : exams)
		{
			examTotal += ex;
		}
		for(Double as : assigns)
		{
			assignments += as;
		}
	
		
		examTotal = (examTotal / exams.size());
		assignments = (assignments / assigns.size());

		
		
		examTotal = (examTotal * .60);
		assignments = (assignments * .40);
		return (examTotal + assignments);
	}

}
