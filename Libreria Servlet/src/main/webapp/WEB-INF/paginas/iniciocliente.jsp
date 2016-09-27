<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Opciones Usuario ${sessionScope.cuenta.nombre }</h2>
	
	<a href="cliente/catalogo">Catálogo</a>
	<a href="cliente/modificarCuenta">Modificar Cuenta</a>
	<a href="${pageContext.request.contextPath }/logout">Salir</a>

</body>
</html>