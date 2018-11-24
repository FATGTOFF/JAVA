/**
Written by Carlos Vazquez
Chapter 9
Programming Challenge 5
Date: 29 September 2018

The CourseGrades class has an array of
GradedActivity objects as a field named grades.
The array has four elements, GradedActivity,
PassFailExam, Essay, and Final Exam.
The class have the following methods:
	- Default constructor with no-args.
	- setLab
	- setPassFailExam
	- setFinalExam
	- toString
 */
package chapter9;

public class CourseGrades
{
	// Constant variable for the number of grades.
    private final int NUM_OF_GRADES = 4;
    private GradedActivity [] grades;
    
    
    // No-arg Constructor to define.
    // the array named grades.
    public CourseGrades()
    {
          grades = new GradedActivity[NUM_OF_GRADES];
    }
    
    // Mutators
    // This method accepts a GradedActivity object
    // as its argument. The object holds the student's
    // score for the lab activity. Element 0 of
    // the grades reference the object.
    public void setLab(GradedActivity scr)
    {        
        grades[0] = scr;
    }
    
    // This method accepts a PassFailExam object as its
    // argument. The object hold the student score for
    // the pass/fail exam. Element 1 of the grades
    // reference the object.
    public void setPassFailExam(PassFailExam scr)
    {        
        grades[1]= scr;
    }
    
    // This method accepts an Essay object as its
    // argument. This object hold the student's
    // score for the essay. Element 2 of the grades
    // reference this object.
    public void setEssay(Essay scr)
    {        
        grades[2] = scr ;
    }
    
    // This method accepts a FinalExam object as its
    // argument. The object holds the student's score
    // for the final exam. Element 3 of the grades
    // are reference for this object.
    public void setFinalExam(FinalExam scr)
    {        
        grades[3] = scr;
    }
    
    // This method returns a string, which contains
    // the numeric scores and the grades for each
    // element in the grades array.
    public String toString()
    {
    	String str = "Lab Score: " + grades[0].getScore()
    	+ "\t\t\tGrade: " + grades[0].getGrade()
    	+ "\nPass/Fail Exam Score: " + grades[1].getScore()
    	+ "\tGrade: " + grades[1].getGrade()
    	+ "\nEssay Score: " + grades[2].getScore()
    	+ "\t\tGrade: " + grades[2].getGrade()
    	+ "\nFinal Exam Score: " + grades[3].getScore()
    	+ "\t\tGrade: " + grades[3].getGrade();
    	
    	return str;
    }
}
