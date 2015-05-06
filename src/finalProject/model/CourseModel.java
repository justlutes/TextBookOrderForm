package finalProject.model;

public class CourseModel {
	private String title;
	private String course_ID;

	public CourseModel(){};
	
	public CourseModel( String course_ID, String title ) {
		setCourse_ID( course_ID );
		setTitle( title );
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the course_ID
	 */
	public String getCourse_ID() {
		return course_ID;
	}
	
	/**
	 * @param course_ID the course_ID to set
	 */
	public void setCourse_ID(String course_ID) {
		this.course_ID = course_ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseModel [title=" + title + ", course_ID=" + course_ID + "]";
	}

}
