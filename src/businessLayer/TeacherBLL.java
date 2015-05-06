package businessLayer;

/**
 * The Class TeacherBLL.
 */
public class TeacherBLL {
	
	
	private String instructor_ID;
	private String instructorEmail;
	private String instructorPassword;
	private int expectedEnrollment;
	
	/**
	 * Gets the instructor_ id.
	 *
	 * @return the instructor_ id
	 */
	public String getInstructor_ID() {
		return instructor_ID;
	}
	
	/**
	 * Sets the instructor_ id.
	 *
	 * @param instructor_ID the new instructor_ id
	 */
	public void setInstructor_ID(String instructor_ID) {
		this.instructor_ID = instructor_ID;
	}
	
	/**
	 * Gets the instructor email.
	 *
	 * @return the instructor email
	 */
	public String getInstructorEmail() {
		return instructorEmail;
	}
	
	/**
	 * Sets the instructor email.
	 *
	 * @param instructorEmail the new instructor email
	 */
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	
	/**
	 * Gets the instructor password.
	 *
	 * @return the instructor password
	 */
	public String getInstructorPassword(){
		return instructorPassword;
	}
	
	/**
	 * Sets the instructor password.
	 *
	 * @param password the new instructor email
	 */
	public void setInstructorPassword(String password){
		this.instructorPassword = password;
	}
	
	/**
	 * Gets the expected enrollment.
	 *
	 * @return the expected enrollment
	 */
	public int getExpectedEnrollment() {
		return expectedEnrollment;
	}
	
	/**
	 * Sets the expected enrollment.
	 *
	 * @param expectedEnrollment the new expected enrollment
	 */
	public void setExpectedEnrollment(int expectedEnrollment) {
		this.expectedEnrollment = expectedEnrollment;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String thisObject = "********************\n" +
						    "Instructor_ID: " + instructor_ID + "\n" +
						    "Email: " + instructorEmail + "\n" +
						    "Password: " + instructorPassword + "\n";
		return thisObject;
	}
}