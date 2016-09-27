<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="nemu-panel" >
			<jsp:include page="../fragmentos/menu.jsp"></jsp:include>
		</div>
	</div>
	<h3>Confirmación del Pedido</h3>
	<p>El pedido se ha grabado correctamente</p>
	<p>Se le ha enviado un correo a la dirección ${orden.email} con el número
	de pedido ${orden.numOrden}</p>
	<p>Se le enviará notificaciones del estado de su pedido</p>
</body>
</html>