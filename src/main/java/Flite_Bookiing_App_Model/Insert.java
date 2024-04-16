package Flite_Bookiing_App_Model;

import java.util.Date;

public class Insert {

	private Date date;
    private String time;
    private double fare;
	private String Destination;
	private String Source;
	
	public Date getDate() {
		return date;
	}
	public String getSource() {
		return Source;
	}
	
	public String getDestination() {
		return Destination;
	}
	public double getFare() {
		return fare;
	}
	
	public String getTime() {
		return time;
	}
	public void setDate(Date date2) {
		this.date=date2;
		
	}
	public void setSource(String source) {
		this.Source=source;
	}
	public void setDestination(String destination) {
		this.Destination=destination;
	}
	
	public void setFare(double parseDouble) {
		this.fare=parseDouble;
		
	}
	public void setTime(String time) {
		this.time=time;
		
	}
		
}
