package sample.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class User implements Serializable{

	private static final long serialVersionUID = 3959992070344800324L;
	private String username;
	private String dept;
	private String sID;
	private String ltime;
	
	public User(String username, String dept, String sID, String ltime) {
		this.username = username;
		this.dept = dept;
		this.sID = sID;
		this.ltime = ltime;
		
	}
	
	public User(String username, String dept, String sID) {
		this.username = username;
		this.dept = dept;
		this.sID = sID;
		long times = new Date().getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.ltime = formatter.format(times);
		
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDept() {
		return dept;
	}

	public String getsID() {
		return sID;
	}


	public void setsID(String sID) {
		this.sID = sID;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getLtime() {
		return ltime;
	}


	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	
	
	
}
