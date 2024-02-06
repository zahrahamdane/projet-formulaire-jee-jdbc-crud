package fr.eni.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.eni.beans.Voiture;
import fr.eni.services.VoitureService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajouterVoiture.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Voiture nouvelleVoiture = Validation.validerSaisie(request);

		if (nouvelleVoiture != null) {
			VoitureService vs = new VoitureService();
			try {
				vs.ajouterVoiture(nouvelleVoiture);
				response.sendRedirect(request.getContextPath() + "/ListerServlet");

			} catch (Exception e) {
				request.setAttribute("erreur", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/erreur.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajouterVoiture.jsp");
			rd.forward(request, response);
		}
	}

}
