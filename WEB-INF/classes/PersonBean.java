import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.io.*;


public class PersonBean implements Serializable {
 
	private String Fname;				 
	private String Lname;				 
	private String email;				
	private String userPassword;		
	private int phoneNo;    			
	private String roleInSystem;            

  public PersonBean(){}
  
  public PersonBean(String nFname, String nLname, String nemail, String nuserPassword, int nphoneNo, String nroleInSystem){
	  
	this.Fname = nFname;				 
	this.Lname = nLname;				 
	this.email = nemail;				
	this.userPassword = nuserPassword;		
	this.phoneNo = nphoneNo;    			
	this.roleInSystem = nroleInSystem;	 
  }
  
  public void setFname (String f){
	  
	  this.Fname = f;
  }
  
  public void setLname (String l){
	  
	  this.Lname = l;
  }
  
  public void setEmail (String e){
	  
	  this.email = e;
  }
  
  public void setUserPassword (String u){
	  
	  this.userPassword = u;
  }
  
  public void setPhoneNo (int p){
	  this.phoneNo = p;
  }
  
  public void setRoleInSystem (String r){
	  
	  this.roleInSystem = r;
  }
  
  public String getFname(){
	  
	  return Fname;
  }
  
    public String getLname(){
	  
	  return Lname;
  }
  
    public String getEmail(){
	  
	  return email;
  }
  
    public String getUserPassword(){
	  
	  return userPassword;
  }
  
    public int getPhoneNo(){
	  
	  return phoneNo;
  }
  
    public String getRoleInSystem(){
	  
	  return roleInSystem;
  }
  
  
  
  

  
  
  
}