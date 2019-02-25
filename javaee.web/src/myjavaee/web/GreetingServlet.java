package myjavaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"en\">" + "<head><title>Servlet Hello</title></head>");
			// then write the data of the response
			out.println("<body bgcolor=\"#ffffff\">" 
					+ "<img src=\"resources/images/Duke.wave.shadow.gif\" "
					+ "alt=\"Duke waving his hand\">" 
					+ "<form method=\"get\">"
					+ "<h2>Hello, my name is Duke. What's yours?</h2>" 
					+ "<input title=\"My name is: \"type=\"text\" "
					+ "name=\"username\" size=\"25\">" 
					+ "<p></p>" 
					+ "<input type=\"submit\" value=\"Submit\">"
					+ "<input type=\"reset\" value=\"Reset\">" 
					+ "</form>" + "</body>");
			String username = request.getParameter("username");
			if (username != null && username.length() > 0) {
				response.sendRedirect("response?username=" + username);
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
//				if (dispatcher != null) {
//					dispatcher.forward(request, response);
//				}
			}
			out.println("</html>" );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"en\">" + "<head><title>Servlet Hello</title></head>");
			String username = request.getParameter("username");
			if (username != null && username.length() > 0) {
//				response.sendRedirect("response?username=" + username);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
				if (dispatcher != null) {
					dispatcher.forward(request, response);
				}
			}
			out.println("</html>");
		}
	}
}
