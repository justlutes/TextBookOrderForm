package finalProject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequisitionModelMapper {
	private RequisitionModel order;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	private int returnedRows;
	private String query;
	boolean recommended;
	
	private String course_ID;
	private String section_ID;
	private String instructor_ID;
	private int enrollment;
	private String orderDate;
	private String approvedDate;
	private int req;
	private int rec;
	private String isbn;
	private String author;
	private String publisher;
	private String title;
	private int edition;
	
	public RequisitionModelMapper( Connection con ){
		this.setCon( con );
	}
	
	public ArrayList<String> getAllOrders(){
		ArrayList<String> orders = new ArrayList<String>();
		this.setQuery( "SELECT `order_ID` FROM `order`" );
		
		try {
			this.setPs( this.getCon().prepareStatement( this.getQuery() ) );
			this.setRs( this.getPs().executeQuery() );
			while( rs.next() ){
				orders.add( rs.getString( 1 ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public void insertOrder( RequisitionModel newOrder ){
		ArrayList<BookModel> books = newOrder.getBooks();
		
		this.setEnrollment( newOrder.getExpectedEnrollment() );
		this.setApprovedDate( newOrder.getApprovedDate() );
		this.setOrderDate( newOrder.getOrderDate() );
		
		for( BookModel book : books ){
			if( book.getRequired().equals( "Required" ) )
				this.setReq( 1 );
			else
				this.setReq( 0 );
			
			this.setRecommended( book.isRecommended() );
			
			this.setIsbn( book.getIsbn() );
			this.setCourse_ID( book.getCourse_ID() );
			this.setSection_ID( book.getSection_ID() );
			this.setAuthor( book.getAuthor_ID() );
			this.setPublisher( book.getPublisher_ID() );
			this.setTitle( book.getTitle() );
			this.setEdition( edition);
			
			this.setQuery(   "INSERT INTO `book` "
					+        "(`book_ISBN`, `course_ID`, `section_ID`, `author_ID`, `publisher_ID`, `book_title`, `book_edition`) "
					+ "VALUES ( ?, ?, ?, ?, ?, ?, ? )" );
			
			try {
				this.getPs().setString(1, this.getIsbn() );
				this.getPs().setString(2, this.getCourse_ID() );
				this.getPs().setString(3, this.getSection_ID() );
				this.getPs().setString(4, this.getAuthor() );
				this.getPs().setString(5, this.getPublisher() );
				this.getPs().setString(6, this.getTitle() );
				this.getPs().setInt(7, this.getEdition() );
				
				this.getPs().executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			this.setQuery( "INSERT INTO `order` ( `section_ID`," + 
                     							 "`course_ID`," +
                     							 "`order_enroll`," +
                     							 "`order_approve_date`," + 
                     							 "`order_submit_date`," + 
                     							 "`order_required`," + 
                     							 "`order_reccomended` )" +
		                   "VALUES ( ?, ?, ?, ?, ?, ?, ? )" );
			try {
				this.getPs().setString( 1, this.getCourse_ID() );
				this.getPs().setString( 2, this.getSection_ID() );
				this.getPs().setInt( 3, this.getEnrollment() );
				this.getPs().setString( 4, this.getApprovedDate() );
				this.getPs().setString( 5, this.getOrderDate() );
				this.getPs().setInt( 6, this.getReq() );
				this.getPs().setInt( 7, this.getReq() );
				
				this.getPs().executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void mapOrderByID( String order_ID ){
		this.setOrder( new RequisitionModel() );
		
		this.setQuery( "SELECT * FROM `order` NATURAL JOIN section NATURAL JOIN book where order_ID = ?" );
		
		try {
			this.setPs( this.getCon().prepareStatement( this.getQuery() ) );
			this.getPs().setString( 1, order_ID );
			this.setRs( this.getPs().executeQuery() );

			while( rs.next() ){				
				this.setCourse_ID( rs.getString( 1 ) );
				this.setSection_ID( rs.getString( 2 ) );
				this.setEnrollment( ( rs.getInt( 4 ) ) );
				this.setOrderDate( rs.getString( 5 ) );
				this.setApprovedDate( rs.getString( 6 ) );
				this.setReq( rs.getInt(7) );
				this.setRec( rs.getInt(8) );
				this.setInstructor_ID( rs.getString( 9 ) );
				this.setIsbn( rs.getString( 10 ) );
				this.setAuthor( rs.getString( 11 ) );
				this.setPublisher( rs.getString( 12 ) );
				this.setTitle( rs.getString( 13 ) );
				this.setEdition( rs.getInt(14) );
				
				if( rec == 1 )
					this.setRecommended( true );
				else
					this.setRecommended( false );
				
				
				this.getOrder().getBooks().add( new BookModel( this.getIsbn(), this.getCourse_ID(),
															   this.getSection_ID(), this.getAuthor(), 
															   this.getPublisher(), this.getTitle(),
															   this.getEdition(), this.getReq(),
															   this.isRecommended() ) );				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		order.setCourse_ID( this.getCourse_ID() );
		order.setSection_ID( this.getSection_ID() );
		order.setInstructor_ID( this.getInstructor_ID() );
		order.setExpectedEnrollment( this.getEnrollment() );
		order.setOrderDate( this.getOrderDate() );
		order.setApprovedDate( this.getApprovedDate() );
	}
	
	/**
	 * @return the order
	 */
	public RequisitionModel getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(RequisitionModel order) {
		this.order = order;
	}


	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}


	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}


	/**
	 * @return the ps
	 */
	public PreparedStatement getPs() {
		return ps;
	}


	/**
	 * @param ps the ps to set
	 */
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}


	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}


	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}


	/**
	 * @return the returnedRows
	 */
	public int getReturnedRows() {
		return returnedRows;
	}


	/**
	 * @param returnedRows the returnedRows to set
	 */
	public void setReturnedRows(int returnedRows) {
		this.returnedRows = returnedRows;
	}


	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}


	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
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
	 * @return the enrollment
	 */
	public int getEnrollment() {
		return enrollment;
	}


	/**
	 * @param enrollment the enrollment to set
	 */
	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
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
	 * @return the req
	 */
	public int getReq() {
		return req;
	}


	/**
	 * @param req the req to set
	 */
	public void setReq(int req) {
		this.req = req;
	}


	/**
	 * @return the rec
	 */
	public int getRec() {
		return rec;
	}


	/**
	 * @param rec the rec to set
	 */
	public void setRec(int rec) {
		this.rec = rec;
	}


	/**
	 * @return the recommended
	 */
	public boolean isRecommended() {
		return recommended;
	}


	/**
	 * @param recommended the recommended to set
	 */
	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}


	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}


	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
	 * @return the edition
	 */
	public int getEdition() {
		return edition;
	}


	/**
	 * @param string the edition to set
	 */
	public void setEdition(int string) {
		this.edition = string;
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
	
}

