package assign5;

import java.util.ArrayList;
public class AverageB implements GradingStrategy {
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
