package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import models.ChallanDatamodel;

public class Challandb {

	static String url = "jdbc:mysql://localhost:3306/TrafficManagementSystem";
	static String username = "root";
	static String password = "Poorna@01";
	Connection connection;
public Challandb(){
	try {
		connection = DriverManager.getConnection(url,username,password);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void setchallan(ChallanDatamodel cdm)
{
	String query = "INSERT INTO challanData(name,vehiclename,Phonenumber,offense,fine,date) VALUES(?,?,?,?,?,?)";
	Date date = new Date();
	java.sql.Date sqldate;
	sqldate = new java.sql.Date(date.getTime());
	try {
		PreparedStatement pa = connection.prepareStatement(query);
		pa.setString(1, cdm.getName());
		pa.setString(2, cdm.getVehiclename());
		pa.setString(3, cdm.getPhonenumber());
		pa.setString(4, cdm.getOffense());
		pa.setDouble(5, cdm.getFine());
		pa.setDate(6, sqldate);
		pa.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public ArrayList<ChallanDatamodel> getoffensers()
{
	ArrayList<ChallanDatamodel> cdmlist = new ArrayList<ChallanDatamodel>();
	String query = "SELECT * FROM challanData";
	java.sql.Statement st;
	try {
		st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			ChallanDatamodel cdm = new ChallanDatamodel();
			cdm.setName(rs.getString("name"));
			cdm.setVehiclename(rs.getString("vehiclename"));
			cdm.setFine(rs.getDouble("fine"));
			cdm.setOffense(rs.getString("offense"));
			cdm.setPhonenumber(rs.getString("Phonenumber"));
			cdm.setDate(rs.getDate("date"));
			cdmlist.add(cdm);
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return cdmlist;
}
public ArrayList<ChallanDatamodel> getoffensersHistory(String vehiclenumber)
{
	ArrayList<ChallanDatamodel> cdmlist = new ArrayList<ChallanDatamodel>();
	String query = "SELECT * FROM challanData WHERE vehiclename = '"+vehiclenumber+"'";
	java.sql.Statement st;
	try {
		st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			ChallanDatamodel cdm = new ChallanDatamodel();
			cdm.setName(rs.getString("name"));
			cdm.setVehiclename(rs.getString("vehiclename"));
			cdm.setFine(rs.getDouble("fine"));
			cdm.setOffense(rs.getString("offense"));
			cdm.setPhonenumber(rs.getString("Phonenumber"));
			cdm.setDate(rs.getDate("date"));
			cdmlist.add(cdm);
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return cdmlist;
}

}
