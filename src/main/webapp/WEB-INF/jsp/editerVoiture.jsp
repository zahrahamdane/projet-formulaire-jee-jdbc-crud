<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<%@ page import="fr.eni.beans.Voiture" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editer une voiture</title>

<!-- CSS Bootstrap 4 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="py-5 text-center">
            <h2>Editer une voiture</h2>
        </div>

        <div class="row">
        	<c:choose>
        		<c:when test="${!empty voitureAEditer }">
        			<div class="col-md-12 order-md-1">
                        <form action="${pageContext.request.contextPath}/EditerServlet" method="post">
                            <div class="mb-3">
                                <label for="marque">Marque</label>
				                <input type="text" class="form-control" id="marque" name="marque" placeholder="RENAULT, PEUGEOT, CITROEN, ..." value="${param.marque!=null?param.marque:voitureAEditer.marque}">
                            	<p class="text-danger">${erreursDeSaisie.get("marque")}</p>
                            </div>

                            <div class="mb-3">
                                <label for="modele">Modele</label>
                                <input type="text" class="form-control" name="modele" id="modele" value="${param.modele!=null?param.modele:voitureAEditer.marque}">
                            	<p class="text-danger">${erreursDeSaisie.get("modele")}</p>
                            </div>

                            <div class="mb-3">
                                <label for="kilometrage">Kilometrage</label>
                                <input type="text" class="form-control" name="kilometrage" id="kilometrage" value="${param.kilometrage!=null?param.kilometrage:voitureAEditer.kilometrage}">
                            	<p class="text-danger">${erreursDeSaisie.get("kilometrage")}</p>
                            </div>

                            <div class="mb-3">
                                <label for="immatriculation">Immatriculation</label>
                                <input type="text" class="form-control" name="immatriculation" id="immatriculation" value="${param.immatriculation!=null?param.immatriculation:voitureAEditer.immatriculation}" readonly>
                            	<p class="text-danger">${erreursDeSaisie.get("immatriculation")}</p>
                            </div>

                            <div class="mb-3">
                                <label for="annee">Annee</label>
                                <input type="text" class="form-control" name="annee" id="annee" value="${param.annee!=null?param.annee:voitureAEditer.annee}">
                            	<p class="text-danger">${erreursDeSaisie.get("annee")}</p>
                            </div>

                            <button class="btn btn-primary btn-lg btn-block" type="submit">Editer</button>

                        </form>
                    </div>
        		</c:when>
        		
        		<c:otherwise>
        			 <p>Aucune voiture n'est selectionnee</p>
        		</c:otherwise>
        	</c:choose>
        </div>
        
        <footer class="my-5 pt-5 text-muted text-center text-small">
        	<p class="mb-1">&copy; 2024 Editions Zara'Dev</p>
      </footer>
    </div>

</body>
</html>