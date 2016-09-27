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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btn_password').click(function(evt){
			var $passw = $('#password');
			var $passwrep = $('#passwordrep');
			var $spanPasswError = $('#error_passw');
			if($spanPasswError.size()==0){
				$spanPasswError = $('<span id="error_passw" class="msgerror"/>');
				$spanPasswError.insertBefore('#form_password');
			}
			if($passw.val().trim().length==0){
				controlError($passw,'La contraseña no puede estar vacía');
				return false;
			}
			if($passw.val().trim() != $passwrep.val().trim()){
				$fieldPasswords = 
				controlError($passw.add($passwrep),'Las contraseñas no coinciden');
				return false;
			}
			return true;
		});
		
		var controlError = function($obj,msg){
			$('.fielderror').removeClass('fielderror');
			$obj.addClass('fielderror');
			$('.msgerror').html(msg);
		};
	});
</script>
</head>
<body>
	<div>
		<div id="nemu-panel" >
			<jsp:include page="../fragmentos/menu.jsp"></jsp:include>
		</div>
	</div>	
	<h3>Datos Cuenta</h3>
	<c:if test="${not empty perfil.errores }">
		<c:forEach items="${perfil.errores}" var="erroresEntry">
			<span style="color:red">${erroresEntry.value }</span>
			<br/>
		</c:forEach>
	</c:if>
	<c:if test="${not empty perfil.mensaje }">
		<span style="color:blue">${perfil.mensaje }</span>
	</c:if>
	<c:set scope="page" value="${perfil.gestionCuenta }" var="cuenta"/>
	<form action="cuenta" method="post">
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
				<td><label for="nombreusuario">Nombre Usuario</label></td>
				<td><input name="nombreUsuario" value="${cuenta.nombreusuario }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td><button type="submit">Actualizar Cuenta</button></td>
			</tr>
		</table>
	</form>
	<br>
	<h3>Cambiar Contraseña</h3>
	<c:if test="${not empty perfil.password_msg}">
		<span style="color: blue;">${perfil.password_msg}</span>
	</c:if>
	<c:if test="${not empty perfil.password_error}">
		<span id="error_passw" class="msgerror">${perfil.password_error}</span>
	</c:if>
	<form id="form_password" action="cambiarpassword" method="post">
		<table>
			<tr>
				<td><label for="password">Contraseña Nueva</label></td>
				<td><input type="password" name="password" id="password">
			</tr>
			<tr>
				<td><label for="passwordrep">Repita Contraseña Nueva</label></td>
				<td><input type="password" id="passwordrep" >
			</tr>
			<tr>
				<td><button id="btn_password" type="submit">Cambiar Contraseña</button></td>
			</tr>			
		</table>
	</form>
</body>
</html>