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

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 	throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
		requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			RequestDispatcher requestDispatcher;
			
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			
			
			PersonBean person = new PersonBean();
			person.login(user, pass);
			
			if(person.getStatus() == true)
			{
				session.setAttribute("person", person);
				response.sendRedirect("/SENG2050-assignment3/UserMenu");
			}
			// else show error message but we need to change it latter
			else{
				response.getWriter().println("Dump cunt invalid username or password");
			}
			


    }

}