package ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.sql.Statement;

/* DB ���� �׽�Ʈ(MySQL)
 * 
 */

public class DBcon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// DB���� �� ����ó����
		try {
			Class.forName("com.mysql.jdbc.Driver");  // Java���� �����ͺ��̽� ����̹� ����
			System.out.println("���� �Ϸ�");
			
		} catch(ClassNotFoundException e1) {
			System.out.println("����̹� ���� ����");
		    System.exit(0);  // �ý��� ����
		}
		
		String url = "jdbc:mysql://localhost:3306/db22";  // db���
		String username = "mouse";  // �����
		String password = "1234";  // ��й�ȣ
		Connection connection = null; 
		
		System.out.println("Mysql DB db22 ����õ��� ....");
		try {  // DB ����
			connection = DriverManager.getConnection(url, username, password);  
			System.out.println("DB Connection Complete");
		} catch(SQLException e) {  // DB���� ���н�
			System.out.println("DB Connection Fail");
		}
		
		String sql = "select * from ms";
		
		Statement pa1;
		try {
			pa1 = connection.createStatement();  // ������ ����
			ResultSet pa2 = pa1.executeQuery(sql);  // ������ ������ ��� �� ����
			while(pa2.next()) {  // ������ �����Ͱ� ���� �� �� ���� �ݺ�
				System.out.println(pa2.getInt(1) + ". �̸� = " + pa2.getString(2) + ", �а� = " + pa2.getString(3));
			}
			pa2.close();  // ���� �� ����
			pa1.close();  // ���� �� ����
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("connection Closing");
			if(connection != null) { // ���� ���� ����Ǿ� �ִٸ�
				try {  // ������ ���� �����ϱ�
					connection.close();  
				} catch(SQLException e){  // ������ ���� ���ᰡ �Ǿ����� �ʴ´ٸ�
					e.printStackTrace();
				}
			}
		}

	}

}
