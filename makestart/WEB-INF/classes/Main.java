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

@WebServlet(urlPatterns = {"/MainPage"})
public class Main extends HttpServlet {
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 	throws ServletException, IOException {
      		
		String choise = request.getParameter("button");
		HttpSession session = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("MainPage.jsp");	
		
		if(choise.equals("login")){
			requestDispatcher = request.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(request, response);
		}
		if(choise.equals("newaccount")){
			requestDispatcher = request.getRequestDispatcher("NewUser.jsp");
			requestDispatcher.forward(request, response);
		}
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String fiestName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int phoneNumber = Integer. parseInt(request.getParameter("phoneNumber"));
		String roleInSystem = request.getParameter("roleInSystem");
		PersonBean person = new PersonBean(fiestName, lastName, user, pass, phoneNumber, roleInSystem);
		
		
		//testing
		LoginBean login = new LoginBean(person);
		login.addUser(person);
		
    }

}