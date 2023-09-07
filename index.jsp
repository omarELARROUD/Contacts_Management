<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire impôt</title>
</head>
<body>
<h1>Calcul d'impôt</h1>
<form action="/war/controleur" method="post">
    <label for="salaireAnnuel">Salaire annuel:</label>
    <input type="number" id="salaireAnnuel" name="salaireAnnuel"><br>
    <label for="nbEnfants">Nombre d'enfants:</label>
    <input type="number" id="nbEnfants" name="nbEnfants"><br>
    <label for="estMarie">Marié(e):</label>
    <input type="checkbox" id="estMarie" name="estMarie"><br>
    <input type="submit" value="Calculer impôt">
</form>
</body>
</html>