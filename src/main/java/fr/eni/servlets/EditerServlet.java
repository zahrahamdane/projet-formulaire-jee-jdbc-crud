package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.beans.Voiture;
import fr.eni.services.VoitureService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditerServlet")
public class EditerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String immatriculation = request.getParameter("immatriculation");

		VoitureService vs = new VoitureService();
		try {
			Voiture voitureAModifier = vs.getVoiture(immatriculation);
			request.setAttribute("voitureAEditer", voitureAModifier);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editerVoiture.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/erreur.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Voiture voitureModifiee = Validation.validerSaisie(request);

		if (voitureModifiee != null) {
			VoitureService vs = new VoitureService();

			try {
				vs.modifierVoiture(voitureModifiee);
				response.sendRedirect(request.getContextPath() + "/ListerServlet");

			} catch (Exception e) {
				request.setAttribute("erreur", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/erreur.jsp");
				rd.forward(request, response);
			}

		} else {
			doGet(request, response);
		}
	}

}
