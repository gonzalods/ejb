<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="nemu-panel" >
			<jsp:include page="../fragmentos/menuorden.jsp"></jsp:include>
		</div>
	</div>
	<h3>Resumen del Pedido</h3>
	<p>Ha continuación le mostramos el resumen del pedido que va ha realizar</p>
	<h4>Dirección de Entrega</h4>
	<p>El pedido se entregara en la siguiente dirección:</p>
	<dl>
		<dt>Calle:</dt>
		<dd>${orden.dirEntrega.calle }</dd>
	<c:if test="${not empty orden.dirEntrega.numero}">	
		<dt>Número:</dt>
		<dd>${orden.dirEntrega.numero}</dd>
	</c:if>
	<c:if test="${not empty orden.dirEntrega.piso}">	
		<dt>Piso:</dt>
		<dd>${orden.dirEntrega.piso}</dd>
	</c:if>
		<dt>Ciudad:</dt>
		<dd>${orden.dirEntrega.ciudad}</dd>
		<dt>Código Postal:</dt>
		<dd>${orden.dirEntrega.codigoPostal}</dd>
	</dl>
	<h4>Libros Pedidos</h4>
	<table>
		<tr>
			<td>Cantidad</td>
			<td>Libro</td>
			<td align="right">Precio</td>
			<td></td>
		</tr>
			<c:forEach items="${orden.detalleCarrito.items }" var="item">
				
				<tr>
					<td>${item.cantidad }</td>
					<td>${item.titulo } (${item.precio })</td>
					<td align="right">${item.totalItem }</td>
				</tr>
			</c:forEach>
		<tr>
			<td colspan="2" align="right">Total:</td>
			<td align="right">${orden.detalleCarrito.total }</td>	
		</tr>
		<tr>
			<td><a href="vueltadireccion">Volver</a></td>
			<td></td>
			<td align="right"><a href="confirmarorden">Confirmar</a></td>	
		</tr>
	</table>
</body>
</html>