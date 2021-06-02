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
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

@WebServlet(urlPatterns = { "/ReportingPage" })
public class IssueController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String choise = request.getParameter("button");
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("MainPage.jsp");

        if (choise.equals("login")) {
            requestDispatcher = request.getRequestDispatcher("Login.jsp");
            requestDispatcher.forward(request, response);
        }
        if (choise.equals("newaccount")) {
            requestDispatcher = request.getRequestDispatcher("NewUser.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errors = "";
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String issue = request.getParameter("issue");
        String subIssue = request.getParameter("subissue");
        String comments = request.getParameter("comments");

        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        if (comments == null) {
            errors += "Kindly add any description";
        }
        IssuesBean obj = new IssuesBean("", issue, subIssue, "title", comments, date, time, "", userName);
        IssuesBean func = new IssuesBean();
        func.AddIssue(obj);

        // Handle errors
        if (errors.length() > 0) {
            response.sendRedirect("/Reporting?errors=" + "Something went wrong...");
            return;
        }
        response.sendRedirect("/Reporting.jsp?Message=" + "Issue Reported Successfully...");

    }

}