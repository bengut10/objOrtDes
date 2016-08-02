package assign5;

import java.text.DecimalFormat;

public class Driver {
    
	public static void main(String[] args) {

        Student student = new Student("Harry Potter");
        student.addAssignmentScore(98.5);
        student.addAssignmentScore(90.1);
        student.addAssignmentScore(78.3);
        student.addExamScore(95);
        student.addExamScore(87);

        DecimalFormat df = new DecimalFormat("0.0");
        // should use algorithm A by default:

        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));

        // switch to algorithm B:
        GradingStrategy b = new AverageB();
        student.setGradingStrategy(b);
        
   
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));
        // switch back to algorithm A here:
        // <<code to switch to A goes here>>
        GradingStrategy a = new AverageA();
        student.setGradingStrategy(a);
        
        
        
        }
}