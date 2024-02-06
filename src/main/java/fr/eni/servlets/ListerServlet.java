package fr.eni.servlets;

import java.io.IOException;

import fr.eni.services.VoitureService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListerServlet
 */
@WebServlet("/ListerServlet")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VoitureService vs = new VoitureService();
		try {
			request.setAttribute("voitures", vs.getListeVoitures());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/listerVoiture.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/erreur.jsp");
			rd.forward(request, response);
		}
	}

}
