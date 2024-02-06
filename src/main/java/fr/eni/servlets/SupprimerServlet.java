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

@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String immatriculation = request.getParameter("immatriculation");
		
		VoitureService vs = new VoitureService();
		
		try {
			vs.supprimerVoiture(immatriculation);
			RequestDispatcher rd = request.getRequestDispatcher("/ListerServlet");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/erreur.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
