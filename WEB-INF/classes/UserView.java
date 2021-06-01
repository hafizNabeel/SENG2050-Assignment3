import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//to do
//if the the user is not signed in then redirect to the main MainPage
//if the user is signed in then show then show then menu jsp based on their type

@WebServlet(urlPatterns = { "/UserMenu" })
public class UserView extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();
		session.removeAttribute("ERROR");
		PersonBean user = (PersonBean) session.getAttribute("person");
		if (user != null || session == null) {
			if (user.getStatus()) {
				// session.setAttribute("person", user);
				requestDispatcher = request.getRequestDispatcher("/WEB-INF/userView.jsp");
				requestDispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("/SENG2050-Assignment3/MainPage");
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
