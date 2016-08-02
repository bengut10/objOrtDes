package assign5;

import java.util.ArrayList;

//Design Pattern: Strategy
public interface GradingStrategy {
	
	public double computeAverage(ArrayList<Double>exams, ArrayList<Double>assigns);
}
