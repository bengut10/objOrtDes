package assign5;

import java.text.DecimalFormat;

public class Driver 
{    
	public static void main(String[] args)
	{
        Student student = new Student("Harry Potter");
        student.addAssignmentScore(98.5);
        student.addAssignmentScore(90.1);
        student.addAssignmentScore(78.3);
        student.addExamScore(95);
        student.addExamScore(87);

        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));
        
        GradingStrategy b = new AverageB();
        student.setGradingStrategy(b);
   
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));
     
        GradingStrategy a = new AverageA();
        student.setGradingStrategy(a);
        
        GradeTracker gt = new GradeTracker(student);
        
        System.out.println("letter grade: " + gt.getLetterGrade());
        
        student.addExamScore(33);
        System.out.println("Added an exam score.");
        System.out.println("letter grade: " + gt.getLetterGrade());

        Student hg = new Student("Hermione Granger");
        hg.addAssignmentScore(96.2);
        hg.addAssignmentScore(98.1);
        hg.addAssignmentScore(99.3);
        hg.addExamScore(95);
        hg.addExamScore(97);
        
        Roster potions = new Roster("Potions","MAG2308");
        potions.addStudent(student);
        potions.addStudent(hg);
       
    
        System.out.println("Potions grades:");
     
        StudentRepository studentRepo = new StudentRepository(potions);
        Iterator iter = studentRepo.getIterator();

        while (iter.hasNext()) 
        {
            Double nextAvg = (Double) iter.next();
            System.out.println("next average "  +
                               df.format(nextAvg.doubleValue()));
        }

	}
}