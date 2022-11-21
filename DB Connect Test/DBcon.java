package ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.sql.Statement;

/* DB 연동 테스트(MySQL)
 * 
 * DB 이름: db22
 * user: mouse,  password: 1234
 * Table 이름: ms
 * Table 칼럼: id(not null, auto_increment), name(varchar 30), dept(varchar 30)
 */

public class DBcon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// DB연동 시 예외처리문
		try {
			Class.forName("com.mysql.jdbc.Driver");  // Java에서 데이터베이스 드라이버 설정
			System.out.println("연결 완료");
			
		} catch(ClassNotFoundException e1) {
			System.out.println("드라이버 연결 실패");
		    System.exit(0);  // 시스템 종료
		}
		
		String url = "jdbc:mysql://localhost:3306/db22";  // db경로
		String username = "mouse";  // 사용자
		String password = "1234";  // 비밀번호
		Connection connection = null; 
		
		System.out.println("Mysql DB db22 연결시도중 ....");
		try {  // DB 연결
			connection = DriverManager.getConnection(url, username, password);  
			System.out.println("DB Connection Complete");
		} catch(SQLException e) {  // DB연동 실패시
			System.out.println("DB Connection Fail");
		}
		
		String sql = "select * from ms";
		
		Statement pa1;
		try {
			pa1 = connection.createStatement();  // 쿼리문 생성
			ResultSet pa2 = pa1.executeQuery(sql);  // 쿼리문 실행한 결과 값 저장
			while(pa2.next()) {  // 가져온 데이터가 끝이 날 때 까지 반복
				System.out.println(pa2.getInt(1) + ". 이름 = " + pa2.getString(2) + ", 학과 = " + pa2.getString(3));
			}
			pa2.close();  // 실행 후 종료
			pa1.close();  // 실행 후 종료
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("connection Closing");
			if(connection != null) { // 만약 아직 연결되어 있다면
				try {  // 강제로 연결 종료하기
					connection.close();  
				} catch(SQLException e){  // 강제로 연결 종료가 되어지지 않는다면
					e.printStackTrace();
				}
			}
		}

	}

}
