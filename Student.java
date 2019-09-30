import java.text.DecimalFormat;
import java.util.Arrays;
/**
 * The class contained three variables, the registration number, the marks array and 
 * a defined constant marks weight array, the program is used to calculate out the total mark of 
 * a student in terms of their 14 various assignments marks, the final value will be kept
 * in one decimal bit. If the final mark over 50, it will be shown as true, otherwise
 * it will be shown as false. If the total weight is less than 50, the output is -1.
 * 
 * @version 2018-11-08
 * @author Zibo Wang
 *
 */
public class Student {
	private String registrationNumber;
	private int [] marks;
	private static final int [] WEIGHT = {2,2,2,2,1,1,1,1,2,2,1,3,10,70};
	
	 /**
     *  @param registrationNumber a specific number for each student
     *  @param marks the array recorded for student with total 14 marks
     */
	public Student(String registrationNumber, int [] marks) {
		this.registrationNumber = registrationNumber;
		this.marks = marks;
	}
	/**
     *  Getter for the registrartionNumber.
     *  @return The number of the assignment is returned as a string.
     */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	/**
     *  Setter for the registrationNumber. The number of the assignments is updated.
     *  @param registrationNumber The new number of the updated student.
     */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	/**
     *  Getter for the marks array.
     *  @return The marks of the student is return as int.
     */
	public int[] getMarks() {
		return marks;
	}
	/**
     *  Setter for the mark array. The marks of students are updated.
     *  @param makrs The new marks of the student.
     */
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	/**
	 * @return A human readable description of the student information in form
     *     of the three field variables.
	 */
	@Override
	public String toString() {
		return "totalMark [registrationNumber=" + registrationNumber + ", marks=" + Arrays.toString(marks) + "]";
	}
	/**
	 * this method is used to change the marks for any assignment, using the "if"
	 * to limit the conditions
	 * 
	 * @param assignmentMark
	 * @param mark
	 */
	public void setAssignmentMark (int assignmentMark, int mark) {
		if (1 <= assignmentMark && assignmentMark <= 14  && 0 <= mark && mark <= 100 ) {
			marks[assignmentMark - 1] = mark;
		}
	}
	/**
	 * this method is used to compute the total mark of students, and round the mark in one 
	 * decimal places. To make the formula be easier to understand, pre-defined a weight array
	 * using for loop and if condition again to sort out the total weight
	 * 
	 * @return the rounded total mark by one decimal place
	 */
	public double totalMark() {
		double totalMark = 0;
		int totalWeight = 0;
		for (int i = 0;i < marks.length; i++) {
			if (marks[i] != -1) {
				totalMark = totalMark + marks[i]*WEIGHT[i];
				totalWeight = totalWeight + WEIGHT[i];
			}
		}
		totalMark = totalMark/totalWeight;
		//round the mark to one decimal point with the Math.round
		double roundedTotalmark = Math.round(totalMark*10) * 0.1;
		//if the final exam is not attended which occupies 70 percent by any reason
		//the total weight will less than 50, then the output will be -1
		if (totalWeight < 50) {
			return -1;
		} 
		else {
			return roundedTotalmark;
		}
	}
	/**
	 * when the student final mark is over 50, it will be shown as true, otherwise
	 * it will be shown as false. If the total weight is less than 50, which call the 
	 * previous method to show the output is -1, and handle exception
	 * 
	 * @return three outputs in terms of the various conditions 
	 */
	public boolean passed() {
		if (50 <= totalMark()) {
			return true;
		} 
		else if ( 0 <= totalMark() && totalMark() < 50) {
			return false;
		}
		else if (totalMark() == -1) {
			throw new IllegalArgumentException();
		}
		return passed();
	}
	/*
	 * defining two student's marks array to output the results
	 */
	public static void main(String[] args) {
		int samsmarks [] = new int [] {50,53,67,54,80,50,50,50,67,50,50,50,-1,67};
		int billysmarks [] = new int [] {50,60,-1,60,65,70,55,66,60,73,65,45,68,54};
		Student sam = new Student ("1111111",samsmarks);
		Student billy = new Student ("1111112",billysmarks);
		DecimalFormat df = new DecimalFormat("0.0");
		System.out.println(sam);
		System.out.println("Sam's total mark = " + df.format(sam.totalMark()) + " " + sam.passed() );
		System.out.println(billy);
		System.out.println("Billy's total mark = " + df.format(billy.totalMark()) + " " + billy.passed() );
	}
}
