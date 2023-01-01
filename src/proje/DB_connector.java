package proje;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;




public class DB_connector { 
	Connection conn = null;
	public static Connection dbConnector()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/otomasyon", "root","root");
			//JOptionPane.showMessageDialog(null, "veritabanı bağlantısı kuruldu");
			return conn;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}  
		 
		   
	} 
}
	
	


