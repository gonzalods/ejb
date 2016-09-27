<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libreria</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stilo.css"/>
</head>
<body>
	<div>
		<div id="nemu-panel" >
			<jsp:include page="../fragmentos/menu.jsp">
				<jsp:param value="${catalogo.usuario}" name="usuario"/>
				<jsp:param value="${catalogo.carrito}" name="carrito"/>
			</jsp:include>
		</div>
	</div>
	<h2>Búsqueda Libros</h2>
	<form action="busquedaLibro" method="post">
		<table>
			<tr>
				<td><input type="submit" value="Buscar"/></td>
				<td> <input id="name" name="titulo" value="${catalogo.titulo}"/></td>
				<td> <select id="categoria" name="categoria">
						<option value="">Seleccione una Categoría</option>
						<c:forEach items="${catalogo.categorias}" var="categoria">
							<c:choose>
								<c:when test="${categoria.id == catalogo.categoria}">
									<option value="${categoria.id }" selected="selected">${categoria.descripcion }</option>
								</c:when>
								<c:otherwise>
									<option value="${categoria.id }">${categoria.descripcion }</option>	
								</c:otherwise>
							</c:choose>
						</c:forEach>					
					</select>
				</td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty catalogo.listLibros}">
	<div>
		<br>
		<h2>Resultado Búsqueda</h2>
		<c:if test="${not empty catalogo.msg_busqueda }">
			<span>${catalogo.msg_busqueda}</span>
		</c:if>
		<ol>
		<c:forEach items="${catalogo.listLibros }" var="lib">
			<li>
				${lib.titulo } (${lib.autores })
				<c:url value="detalleLibro" var="detalleLibroUrl">
					<c:param name="id" value="${lib.id }"/>
					<c:param name="titulo" value="${catalogo.titulo}"/>
					<c:param name="categoria" value="${catalogo.categoria}"/>
				</c:url>
				(<a href="${detalleLibroUrl}">Detalle</a>)
			</li>
		</c:forEach>
		</ol>
	</div>
	</c:if>
	<c:if test="${not empty catalogo.detalleLibro}">
		<c:set value="${catalogo.detalleLibro }" var="libro" scope="page"/>
	<div>
		<h2>Detalle Libro</h2>
		<dl>
			<dt>Titulo</dt>
			<dd>${libro.titulo }</dd>
			<dt>Descripción:</dt>
			<dd>${libro.descripcion }</dd>
			<dt>Precio:</dt>
			<dd>${libro.precio}</dd>
			<dt>Año:</dt>
			<dd>${libro.anno }</dd>
			<dt>Autor:</dt>
			<dd>${libro.autores}</dd>
			<dt>ISBN:</dt>
			<dd>${libro.isbn }</dd>
			<dt>Categoría:</dt>
			<dd>${libro.categoria}</dd>
		</dl>
		<c:url value="busquedaLibro" var="volverUrl">
			<c:param name="titulo" value="${catalogo.titulo}"/>
			<c:param name="categoria" value="${catalogo.categoria}"/>
		</c:url>
		<a href="${volverUrl}" >Volver</a>
		<c:if test="${not empty catalogo.usuario}">
		<div>
			<form action="anadirCarrito" method="post">
				<button type="submit">Añadir a Carrito</button>
				<c:if test="${not empty catalogo.msg_carrito }">
					<input class="fielderror" name="cantidad" size="4">
					<span class="msgerror">${catalogo.msg_carrito}</span>
				</c:if>
				<c:if test="${empty catalogo.msg_carrito }">
					<input name="cantidad" size="4">
				</c:if>
				<input type="hidden" name="id" value="${libro.id }">
				<input type="hidden" name="titulo" value="${catalogo.titulo}">
				<input type="hidden" name="categoria" value="${catalogo.categoria}">
			</form>
		</div>
		</c:if>
	</div>
	</c:if>	
</body>

</html>















