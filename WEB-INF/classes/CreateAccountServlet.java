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

@WebServlet(urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 	throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/NewUser.jsp");
		requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			RequestDispatcher requestDispatcher;

			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			String fiestName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phoneNumber = request.getParameter("phoneNumber");

			PersonBean person = new PersonBean();

			if(person.exist(user))
			{
				person.addUser(fiestName, lastName, user, pass, phoneNumber);
				session.setAttribute("person", person);
				response.sendRedirect("/SENG2050-assignment3/LoginServlet");
			}

			else
			{
				response.getWriter().println("Dump cunt this account already exsi");
			}

			// redircting to the log in page


    }

}
