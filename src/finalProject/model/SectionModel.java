package finalProject.model;

public class SectionModel {
	private String section_ID;
	private CourseModel course_ID;
	private InstructorModel instructor_ID;
	
	/**
	 * @return the section_ID
	 */
	public String getSection_ID() {
		return section_ID;
	}
	/**
	 * @param section_ID the section_ID to set
	 */
	public void setSection_ID(String section_ID) {
		this.section_ID = section_ID;
	}
	/**
	 * @return the course
	 */
	public CourseModel getCourse_ID() {
		return course_ID;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse_ID( CourseModel course_ID ) {
		this.course_ID = course_ID;
	}
	/**
	 * @return the instructor_ID
	 */
	public InstructorModel getInstructor_ID() {
		return instructor_ID;
	}
	/**
	 * @param instructor_ID the instructor_ID to set
	 */
	public void setInstructor_ID(InstructorModel instructor_ID) {
		this.instructor_ID = instructor_ID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SectionModel [section_ID=" + section_ID + ", course=" + course_ID
				+ ", instructor_ID=" + instructor_ID + "]";
	}
}
