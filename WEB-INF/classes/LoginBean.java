import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;   
import java.io.*;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;
import java.util.UUID;



public class LoginBean implements Serializable {
	
	private boolean logedIn = false;
	private String uniqueID;
	PersonBean person = new PersonBean();
		
	public LoginBean(){}
	
	public LoginBean(PersonBean x){
		
		this.person = x;
	}
	
	public boolean getLogedIn(){
		
		
		// testing the database
		checkUser();
		return logedIn;
	}
	
	
	private void checkUser()
	{
		try{
			  String query = "SELECT * FROM person Where [email]=? AND [userPassword]=? ";
			  Connection connection = ConfigBean.getConnection();
			  PreparedStatement statement = connection.prepareStatement(query);
			  statement.setString(1, person.getEmail());
			  statement.setString(2, person.getUserPassword());
			  ResultSet result = statement.executeQuery();
			  
			  if(result.next())
				{
					logedIn = true;
				}
			  else
				{
				  logedIn = false;
				}
			  result.close();
			  statement.close();
			  connection.close();
			}
			
		catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());	
			};
	}
	
	
	public void addUser(PersonBean newPerson)
	{
		//it should be working but i havent test it yet 
		uniqueID = UUID.randomUUID().toString();
		try{ 
			  String query = "INSERT INTO person VALUES (?, ?, ?, ?, ?, ?, ?)";
			  Connection connection = ConfigBean.getConnection();
			  PreparedStatement statement = connection.prepareStatement(query);
			  
			  statement.setString(1, uniqueID);
			  statement.setString(2, newPerson.getFname());
			  statement.setString(3, newPerson.getLname());
			  statement.setString(4, newPerson.getEmail());
			  statement.setString(5, newPerson.getUserPassword());
			  statement.setInt(6, newPerson.getPhoneNo());
			  statement.setString(7, newPerson.getRoleInSystem());
			  
			  statement.executeUpdate();
			  statement.close();
			  connection.close();
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());	
			};
	}
	
}