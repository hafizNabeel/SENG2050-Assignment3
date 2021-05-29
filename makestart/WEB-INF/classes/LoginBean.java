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
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;



public class LoginBean implements Serializable {
	
	private boolean logedIn = false;
	PersonBean person = new PersonBean();

	private PreparedStatement statement;
		
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
			  this.statement = connection.prepareStatement(query);
			  statement.setString(1, person.getEmail());
			  statement.setString(2, person.getUserPassword());
			  ResultSet result = statement.executeQuery();
			  
			  
			  //testing jdbc
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
	
	
	public void addUser()
	{
		int uniqueID;
		uniqueID = ThreadLocalRandom.current().nextInt();
		if((uniqueID == 0) || (uniqueID < 0))
			{
				if (uniqueID < 0)
				{
					uniqueID *= (-1);
				}
				uniqueID += 1;
			}


		
		try{ 
			  String query = "INSERT INTO person (personID, Fname, Lname, email, userPassword, phoneNo) VALUES (?, ?, ?, ?, ?, ?)";
			  Connection connection = ConfigBean.getConnection();



			  this.statement = connection.prepareStatement(query);
			  
			  this.statement.setString(1, String.valueOf(uniqueID));
			this.statement.setString(2, person.getFname());
			this.statement.setString(3, person.getLname());
			this.statement.setString(4, person.getEmail());
			this.statement.setString(5, person.getUserPassword());
			this.statement.setString(6, person.getPhoneNo());
			  
			  System.out.println(person.getFname());
			  System.out.println(person.getLname());
			  System.out.println(person.getEmail());
			  System.out.println(person.getUserPassword());
			  System.out.println(person.getPhoneNo());
			  System.out.println(uniqueID);

			  System.out.println("aaa fdfddgrsehhers");

			  this.statement.executeUpdate();

			  connection.commit();

			  this.statement.close();
			    connection.close();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());	
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
	}
	
}