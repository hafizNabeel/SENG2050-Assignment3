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
		HttpSession session = request.getSession();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/MainPage.jsp");
		requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String choise = request.getParameter("button");
			HttpSession session = request.getSession();
			RequestDispatcher requestDispatcher;
			if( choise.equals("login")){
				requestDispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
				requestDispatcher.forward(request, response);
			}
			if( choise.equals("newaccount")){
				requestDispatcher = request.getRequestDispatcher("/WEB-INF/NewUser.jsp");
				requestDispatcher.forward(request, response);
			}
    }

}
