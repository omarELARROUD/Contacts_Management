<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Résultat impôt</title>
</head>
<body>
<h1>Résultat</h1>
<% if (request.getAttribute("impot") != null) { %>
<p>Impôt à payer: <%= request.getAttribute("impot") %> euros</p>
<% } else { %>
<p>Une erreur est survenue lors du calcul de l'impôt.</p>
<% } %>
<p><a href="index.jsp">Retour au formulaire</a></p>
</body>
</html>
