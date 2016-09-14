<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saludo</title>
</head>
<body>
	<h2>Recogída de datos</h2>
	<form action="saludo" method="post">
		<label for="nombre">Nombre:</label>
		<input id="nombre" name="nombre"/>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>