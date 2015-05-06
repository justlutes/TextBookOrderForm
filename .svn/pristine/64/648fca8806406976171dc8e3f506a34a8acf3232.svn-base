package finalProject.model;

import java.sql.Connection;
import java.util.ArrayList;

public class RequisitionModel {
	
	private String instructor_ID;
	private String course_ID;
	private String section_ID;
	
	private ArrayList<BookModel> books;
	
	private int expectedEnrollment;
	
	private String orderDate;
	private String approvedDate;
	
	public RequisitionModel() {
		books = new ArrayList<BookModel>();
	}
	
	public RequisitionModel( String inst, String course, String section,
							 ArrayList<BookModel> books, int enroll ) {
		this.setInstructor_ID( inst );
		this.setCourse_ID( course );
		this.setSection_ID( section );
		this.setBooks( books );
		
		this.setExpectedEnrollment( enroll );
	}
	
	
	/**
	 * @return the instructor_ID
	 */
	public String getInstructor_ID() {
		return instructor_ID;
	}

	/**
	 * @param instructor_ID the instructor_ID to set
	 */
	public void setInstructor_ID(String instructor_ID) {
		this.instructor_ID = instructor_ID;
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


	/**
	 * @return the texts
	 */
	public ArrayList<BookModel> getBooks() {
		return books;
	}

	/**
	 * @param texts the texts to set
	 */
	public void setBooks(ArrayList<BookModel> books) {
		this.books = books;
	}

	/**
	 * @return the expectedEnrollment
	 */
	public int getExpectedEnrollment() {
		return expectedEnrollment;
	}

	/**
	 * @param expectedEnrollment the expectedEnrollment to set
	 */
	public void setExpectedEnrollment(int expectedEnrollment) {
		this.expectedEnrollment = expectedEnrollment;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the approvedDate
	 */
	public String getApprovedDate() {
		return approvedDate;
	}

	/**
	 * @param approvedDate the approvedDate to set
	 */
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

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
	
	public String orderDetails() {
		String ret = "";
		ret = "Instructor " + instructor_ID
				+ ", Course(s) " + course_ID + ", Section(s) " + section_ID
				+ ", ";
		
				for(BookModel book : books){
					ret = ret + book.formatToString() + " ";
				}
				
				ret = ret + ", Quantity "
				+ expectedEnrollment + ", Ordered " + orderDate
				+ ", Approved " + approvedDate + "";
		
		return ret;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequisitionModel [instructor_ID=" + instructor_ID
				+ ", course_ID=" + course_ID + ", section_ID=" + section_ID
				+ ", books=" + books + ", expectedEnrollment="
				+ expectedEnrollment + ", orderDate=" + orderDate
				+ ", approvedDate=" + approvedDate + "]";
	}

}
