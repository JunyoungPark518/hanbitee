package util;
import java.sql.*;
import constants.Database;
public class JdbcTest {
	public String jdbc() {
		String result = "";
		try {
			Class.forName(Database.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(Database.ORACLE_URL, Database.USERNAME, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Member WHERE id='babungv'";
			ResultSet set = stmt.executeQuery(sql);
			while(set.next()){
				result = set.getString("name");
			}
		} catch (Exception e) {
			
		}
		return result;
	}
}
