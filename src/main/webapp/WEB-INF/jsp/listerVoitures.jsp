<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.List" %>    
<%@ page import="fr.eni.beans.Voiture" %>    
      
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- CSS Bootstrap 4 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

	<title>Liste des voitures</title>
</head>

<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Liste des voitures</h2>
		</div>

		<div class="row">
			<div class="col-md-12 order-md-1">
				<c:choose>
					<c:when test="${!empty voitures}">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Marque</th>
									<th>Modèle</th>
									<th>Kilométrage</th>
									<th>Immatriculation</th>
									<th>Année</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" items="${voitures}">
									<tr>
										<td>${v.marque}</td>
										<td>${v.modele}</td>
										<td>${v.kilometrage}</td>
										<td>${v.immatriculation}</td>
										<td>${v.annee}</td>

										<td>
											<a href="${pageContext.request.contextPath}/SupprimerServlet?immatriculation=${v.immatriculation}"><i class="bi bi-trash"></i></a>
											<a href="${pageContext.request.contextPath}/EditerServlet?immatriculation=${v.immatriculation}"><i class="bi bi-pencil-square"></i></a>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</c:when>
					
					<c:otherwise>
						<p>Aucune voiture n'est présente dans la liste.</p>
					</c:otherwise>
				</c:choose>

				<a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/AjouterServlet">Ajouter Voiture</a>
			</div>
		</div>
		
		<footer class="my-5 pt-5 text-muted text-center text-small">
        	<p class="mb-1">&copy; 2024 Editions Zara'Dev</p>
      	</footer>
	</div>
	
</body>
</html>