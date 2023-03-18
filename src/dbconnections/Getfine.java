package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Getfine {
	
		static String url = "jdbc:mysql://localhost:3306/TrafficManagementSystem";
		static String username = "root";
		static String password = "Poorna@01";
		Connection connection;
	public Getfine(){
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getrules()
    {
        ArrayList<String> strlist = new ArrayList<String>();
        String query = "Select * from Breakingrules";
        java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				strlist.add(rs.getString("rule"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        return strlist;

    }
	public double fine(String offense) {
		double fine = 0;
		String query = "SELECT * FROM Breakingrules WHERE rule = '"+offense+"'";
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				fine = rs.getDouble("Fines");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return fine;
	}

}
