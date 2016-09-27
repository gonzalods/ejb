<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="nemu-panel" >
			<jsp:include page="./fragmentos/menu.jsp">
				<jsp:param value="" name="usuario"/>
				<jsp:param value="" name="carrito"/>
			</jsp:include>
		</div>
	</div>
	<h2>Registro usuario</h2>
	<c:if test="${not empty login.msg_error}">
		<span style="color: red">${login.msg_error}</span>
	</c:if>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Nombre Usuario</td>
				<td><input name="username" value="${login.usuario.username }"/></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Registro"/></td>
			</tr>
		</table>
	</form>
</body>
</html>