package finalProject;

import java.sql.Connection;
import finalProject.model.ConnectionInfoModel;
import finalProject.model.RequisitionModelMapper;

public class InstructorList {
	public static void main(String[] args) {
		ConnectionInfoModel connector = new ConnectionInfoModel();
		Connection con = connector.getCon();
		RequisitionModelMapper mapper = new RequisitionModelMapper( con );
		mapper.mapOrderByID( "8" );
		System.out.println( mapper.getOrder().toString() );
		for( String order_ID : mapper.getAllOrders() ){
			System.out.println( order_ID );
		}
		


//		query = "SELECT book_ISBN FROM book";
//		try {
//			ps = con.prepareStatement( query );
//			rs = ps.executeQuery();
//			while( rs.next() ){
//				isbns.add( rs.getString( 1 ) );
//			}
//		} catch (SQLException e1) {
//
//			e1.printStackTrace();
//		}
//		
//		for( String isbn : isbns ){
//			System.out.println( isbn );
//		}
//
//		query = "INSERT INTO `order` (`course_ID`, `section_ID`, `order_enroll`, "
//				+                    "`order_approve_date`, `order_submit_date`, `order_required`, "
//				+                    "`order_reccomended`)"
//				+ 					 "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
//		try {
//			ps = con.prepareStatement( query );
//			ps.setString( 1, "10" );				//course_ID
//			ps.setString( 2, "1" );				//section_ID
//			ps.setInt( 3, 32 );					//expected enrollment
//			ps.setString( 4 , "12/05/2015" );	//approval date
//			ps.setString( 5, "11/21/2015" );	//order date
//			ps.setInt( 6, 0 );					//required
//			ps.setInt( 7, 1 );					//reccomended
//			System.out.println( ps.executeUpdate() );
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		connector.disconnect();
	}
}
