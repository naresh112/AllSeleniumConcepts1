package days21bund;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SamplePropgramForDataBase {
	public static void main(String[] args) throws SQLException {
		/*
		 * below link contain full information about connecting a database
		 * https://www.codejava.net/java-se/jdbc/connect-to-oracle-database-via-jdbc
		 */
	//	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		
		//DB connecting way #1
		String dbURL = "jdbc:oracle:thin:SCOTT/admin123@localhost:1521:orcl";
		Connection conn = DriverManager.getConnection(dbURL);
		if (conn != null) {
			System.out.println("database Connected");
		}
		////DB connecting way #2
		String dbURL2 = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "SCOTT";
		String password = "admin123";
		Connection conn2 = DriverManager.getConnection(dbURL2, username, password);
		if (conn != null) {
			System.out.println("database Connected 2nd way");
		}

	}

}
