<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- CSS Bootstrap 4 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	
	<title>Ajouter Voiture</title>

</head>
<body>

	<div class="container">
		<div class="py-5 text-center">
			<h2>Ajouter une Voiture</h2>
		</div>

		<div class="row">
			<div class="col-md-12 order-md-1">
				<form action="${pageContext.request.contextPath}/AjouterServlet" method="post">
					<div class="mb-3">
						<label for="marque">Marque</label>
						<input type="text" class="form-control" id="marque" name="marque" placeholder="RENAULT, PEUGEOT, CITROEN, ..." value="${param.marque}">
						<p class="text-danger">${erreursDeSaisie.get("marque")}</p>
					</div>

					<div class="mb-3">
						<label for="modele">Modèle</label>
						<input type="text" class="form-control" id="modele" name="modele" value="${param.modele}">
						<p class="text-danger">${erreursDeSaisie.get("modele")}</p>
					</div>

					<div class="mb-3">
						<label for="kilometrage">Kilométrage</label>
						<input type="text" class="form-control" id="kilometrage" name="kilometrage"  value="${param.kilometrage}">
						<p class="text-danger">${erreursDeSaisie.get("kilometrage")}</p>
						
					</div>

					<div class="mb-3">
						<label for="immatriculation">Immatriculation</label>
						<input type="text" class="form-control" id="immatriculation" name="immatriculation" value="${param.immatriculation}">
						<p class="text-danger">${erreursDeSaisie.get("immatriculation")}</p>
					</div>

					<div class="mb-3">
						<label for="annee">Année</label>
						<input type="number" class="form-control" id="annee" name="annee"  value="${param.annee}">
						<p class="text-danger">${erreursDeSaisie.get("annee")}</p>
					</div>
					<button class="btn btn-primary bnt-lg btn-block" type="submit">Ajouter</button>
				</form>
			</div>
		</div>
		
		<footer class="my-5 pt-5 text-muted text-center text-small">
        	<p class="mb-1">&copy; 2024 Editions Zara'Dev</p>
      </footer>
	</div>
	
</body>
</html>