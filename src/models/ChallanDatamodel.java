package models;

import java.util.Date;

public class ChallanDatamodel {
	private String name;
	private String vehiclename;
	private Date date;
	private String phonenumber;
	private String offense;
	private double fine;
	
	public Date getDate() {
		return date;
	}
	public double getFine() {
		return fine;
	}
	public String getName() {
		return name;
	}
	public String getOffense() {
		return offense;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public String getVehiclename() {
		return vehiclename;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOffense(String offense) {
		this.offense = offense;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	
	

}
