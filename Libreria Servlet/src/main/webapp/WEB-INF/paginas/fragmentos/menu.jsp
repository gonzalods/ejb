<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	<table>
		<tr>
			<td><h3>Librería Formación</h3></td>
			
			<td><c:if test="${not empty usuario}"><div><a href="cuenta">Gestión Cuenta</a></div></c:if></td>
			<td><div><a href="catalogo">Catálogo</a></div></td>
			<td><c:if test="${empty usuario}"><div><a href="${pageContext.request.contextPath}/login">Acceso</a></div></c:if></td>
			<td><c:if test="${empty usuario}"><div><a href="${pageContext.request.contextPath}/registro">Registro</a></div></c:if></td>
			<td><c:if test="${not empty usuario}"><div><a href="${pageContext.request.contextPath}/logout">Salir</a></div></c:if></td>
			<td><span >${usuario.username}</span> </td>
			<td>
			<c:if test="${not empty usuario and not empty carrito}">
				<div id="divCarrito">
					<a href="verCarrito">Carrito (${carrito.cantidad})</a>
				</div>
			</c:if>
			</td>
		</tr>
	</table>
</nav>