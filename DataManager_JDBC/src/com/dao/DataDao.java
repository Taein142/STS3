package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dto.DataDto;

public class DataDao {
	//DB 접속 및 SQL 쿼리 실행 클래스
	//사전 준비
	private String drv = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "dev002";
	private String pwd = "1234";
	
	private Connection conn;//필드(멤버) 변수는 자동으로 초기화
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//생성자를 사용하여 드라이버 로드.
	public DataDao() {
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}
	
	//해제 작업용 메소드(모든 DB 작업의 마지막에 들어가야 함.)
	private void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) { }
	}
	
	//데이터 삽입 메소드
	public int insertData(DataDto data) {
		int result = 0;//insert 쿼리 실행 결과
		//삽입 쿼리
//		String query = "INSERT INTO dt VALUES (seq_dt.NEXTVAL,?,?,?)";
		String query = "INSERT INTO dt VALUES (null,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, data.getM_str());
			pstmt.setInt(2, data.getM_int());
			pstmt.setDate(3, Date.valueOf(data.getM_date()));
			
			result = pstmt.executeUpdate();
			conn.commit();//트랜잭션 커밋.
		} catch (SQLException e) {
			//e.printStackTrace();
			try {
				conn.rollback();//트랜잭션 롤백.
			} catch(SQLException e1) {	}
		} finally {
			close();
		}
		
		return result;
	}

	public List<DataDto> selectList() {
		//DB에서 테이블의 내용을 모두 가져와서 List(목록)에 저장
		//검색 결과값들을 저장하는 List 생성
		List<DataDto> dList = new ArrayList<DataDto>();
		
		//오라클 접속하여 테이블의 전체 내용 가져오기
		String query = "SELECT * FROM dt";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//행단위 처리. 한 행의 데이터를 저장할 DTO 인스턴스 하나 생성
				DataDto dd = new DataDto();
				//각 행을 저장할 DTO는 매번 새로 생성되도록 작성할 것!
				
				dd.setM_code(rs.getInt(1));
				dd.setM_str(rs.getString(2));
				dd.setM_int(rs.getInt(3));
				dd.setM_date(rs.getString(4).substring(0, 10));
				
				dList.add(dd);//목록에 한 행 데이터 추가
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			close();
		}
		
		return dList;
	}

	public DataDto selectData(int code) {
		DataDto data = null;
		
		String query = "SELECT * FROM dt WHERE m_code=?";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data = new DataDto();
				data.setM_code(rs.getInt(1));
				data.setM_str(rs.getString(2));
				data.setM_int(rs.getInt(3));
				data.setM_date(rs.getString(4).substring(0, 10));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			close();
		}
		
		return data;
	}
	
	public int updateData(DataDto data) {
		int result = 0;
		
		String query = "UPDATE dt "
				+ "SET m_str=?, m_int=?, m_date=? "
				+ "WHERE m_code=?";
		//SQL 키워드 중간에 공백이 없으면 다음처럼 문장이 완성됨.
		//UPDATE dtSET m_str=?WHERE..(오류 쿼리)
		//이 경우 SQL 예외사항이 발생되서 실행이 되지 않음.
		//UPDATE dt SET m_str=? WHERE..(정상 쿼리)
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, data.getM_str());
			pstmt.setInt(2, data.getM_int());
			pstmt.setDate(3, Date.valueOf(data.getM_date()));
			pstmt.setInt(4, data.getM_code());
			
			result = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			//e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				//e1.printStackTrace();
			}
		} finally {
			close();
		}
		
		return result;
	}
	
	public int deleteData(int code) {
		int result = 0;
		
		String query = "DELETE FROM dt WHERE m_code=?";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			
			result = pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		} finally {
			close();
		}
		
		return result;
	}
	
}//class end








