package assign5;

import java.util.ArrayList;

public class AverageA implements GradingStrategy {

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
