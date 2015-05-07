package com.sds.icto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.vo.EmailListVO;

public class EmailListDAO {

	private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String id = "webdb";
	private final String password = "webdb";
	private EmailListVO vo;

	public Connection getConnection()  {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

}

	public int insert(EmailListVO vo)  {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into EMAIL_LIST VALUES(EMAIL_LIST_NO_SEQ.nextval, ?, ?, ?)";

		try {
			System.out.println(url + " : " + id + " : " + password);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			int rowCount = pstmt.executeUpdate();

			System.out.println(rowCount + "건이 입력되었습니다.");
			
			return rowCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return 0;
	}
	
	public void delete(String email) throws SQLException{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM EMAIL_LIST where email LIKE ? ";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+email + "%");
		int rowCnt = pstmt.executeUpdate();
		
		System.out.println(rowCnt + "건 삭제완료");
		
		if(pstmt!=null){
			pstmt.close();
		}
		
		if(con!=null){
			con.close();
		}
		
		
	}
	
	public void delete() throws SQLException{
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM EMAIL_LIST";
		
		pstmt = con.prepareStatement(sql);
		int rowCnt = pstmt.executeUpdate();
		
		System.out.println(rowCnt + "건 삭제완료");
		
		if(pstmt!=null){
			pstmt.close();
		}
		
		if(con!=null){
			con.close();
		}
	}
	
	public List<EmailListVO> fetchList() throws SQLException{
		
		List<EmailListVO> list = new ArrayList<EmailListVO>();
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMAIL_LIST";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			list.add(new EmailListVO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}

		if(rs!=null){
			rs.close();
		}
		
		if(pstmt!=null){
			pstmt.close();
		}
		
		if(con!=null){
			con.close();
		}
		return list;
				
	}
}