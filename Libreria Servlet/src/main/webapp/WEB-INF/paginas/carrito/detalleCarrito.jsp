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
			<jsp:include page="../fragmentos/menu.jsp">
<%-- 				<jsp:param value="${carritoBean.usuario}" name="usuario"/> --%>
<%-- 				<jsp:param value="${carritoBean.carrito}" name="carrito"/> --%>
			</jsp:include>
		</div>
	</div>
	<h3>Detalle Carrito</h3>
	<table>
		<tr>
			<td>Cantidad</td>
			<td>Libro</td>
			<td>Precio</td>
			<td></td>
		</tr>
			<c:forEach items="${carritoBean.detalleCarrito.items }" var="item">
				
				<tr>
					<td>${item.cantidad }</td>
					<td>${item.titulo } (${item.precio })</td>
					<td>${item.totalItem }</td>
					<c:url value="eliminarElementoCarrito" var="eliminarElemetoURL">
						<c:param name="id" value="${item.idLibro }"/>
					</c:url>
					<td><a href="${eliminarElemetoURL }">Eliminar de Carrito</a></td>
				</tr>
			</c:forEach>
		<tr>
			<td colspan="2" align="right">Total:</td>
			<td align="right">${carritoBean.detalleCarrito.total }</td>	
		</tr>
		<tr>
			<td colspan="3" align="right"><a href="direccion">Comprar</a></td>	
		</tr>
	</table>
	
</body>
</html>


