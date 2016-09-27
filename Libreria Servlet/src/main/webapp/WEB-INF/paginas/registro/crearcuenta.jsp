<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stilo.css"/>
</head>
<body>
	<nav>
		<table>
			<tr>
				<td><h3>Librería Formación</h3></td>
				<td><div><a href="cancelarRegistro">Cancelar</a></div></td>
		</table>
	</nav>
	<h3>Crear Cuenta</h3>
	<c:if test="${not empty registro.validacion_errores }">
		<c:forEach items="${registro.validacion_errores}" var="erroresEntry">
			<span style="color:red">${erroresEntry.value }</span>
			<br/>
		</c:forEach>
	</c:if>
	<c:if test="${not empty registro.cuenta_error }">
		<span style="color:red">${registro.cuenta_error }</span>
	</c:if>
	<c:set scope="page" value="${registro.cuenta }" var="cuenta"/>
	<form action="crearcuenta" method="post">
		<input type="hidden" name="id" value="${cuenta.id }"/>
		<table>
			<tr>
				<td><label for="nombre">Nombre</label></td>
				<td><input name="nombre" value="${cuenta.nombre }"/></td>
			</tr>
			<tr>
				<td><label for="apellidos">Apellidos</label></td>
				<td><input name="apellidos" value="${cuenta.apellidos }"/></td>
			</tr>
			<tr>
				<td><label for="fechaNacimiento">Fecha Nacimiento</label></td>
				<td><input name="fechaNacimiento" value="${cuenta.fechaNacimiento}"	>&nbsp;(dd-mm-aaaa)</td>
			</tr>
			<tr>
				<td><label for="email">Correo Electrónico</label></td>
				<td><input name="email" value="${cuenta.email }"/></td>
			</tr>
			<tr>
				<td><label for="calle">Calle</label></td>
				<td><input name="calle" value="${cuenta.calle }"/> </td>
			</tr>
			<tr>
				<td><label for="numero">Número</label></td>
				<td><input name="numero" value="${cuenta.numero }"/> </td>
			</tr>
			<tr>
				<td><label for="piso">Piso</label></td>
				<td><input name="piso" value="${cuenta.piso }"/> </td>
			</tr>
			<tr>
				<td><label for="ciudad">Ciudad</label></td>
				<td><input name="ciudad" value="${cuenta.ciudad }"/> </td>
			</tr>
			<tr>
				<td><label for="zip">Código Postal</label></td>
				<td><input name="codigoPostal" value="${cuenta.codigoPostal }"/> </td>
			</tr>
			<tr>
				<td><button type="submit">Crear Cuenta</button></td>
			</tr>
		</table>
	</form>
</body>
</html>