package assign5;

import java.util.ArrayList;

/**
 * Class AverageB uses AverageA algorithm to compute average,
 * but drops the lowest Assignment score if there are at least
 * 2 assignments.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class AverageB implements GradingStrategy {
	
	/**
	 * Computes average of exams and assignments.
	 * @param exams an ArrayList of exams.
	 * @param assigns an ArrayList of assignments.
	 * @returns the average of exams and assignments as a double.
	 */
	@Override
	public double computeAverage(ArrayList<Double> exams, ArrayList<Double> assigns) {
		
		double examTotal = 0;
		double assignments = 0;
		double asLowest = 0;
		for(Double ex : exams)
		{
			examTotal += ex;
		}
		for(Double as : assigns)
		{
			asLowest = as;
			if(asLowest < as)
			{
				asLowest = as;
			}
			assignments += as;
		}
		if(assigns.size()>= 2)
		{
			assignments -= asLowest;
			assignments = assignments / (assigns.size()-1);
		}
		else
		{
			assignments = (assignments / assigns.size());
		}
		examTotal = (examTotal / exams.size());
		examTotal = (examTotal * .60);
		assignments = (assignments * .40);
		return (examTotal + assignments);
	}
}
