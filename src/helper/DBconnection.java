package helper;
import java.sql. *;

public class DBconnection {
	Connection conn = null;
	public DBconnection() {}
	
	public Connection connDb()  {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
