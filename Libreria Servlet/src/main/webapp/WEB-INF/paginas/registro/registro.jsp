<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stilo.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btn_registro').click(function(evt){
			var $passw = $('#password');
			var $passwrep = $('#passwordrep');
			var $spanErrorRegistro = $('#error_registro');
			if($spanErrorRegistro.size()==0){
				$spanErrorRegistro = $('<span id="error_passw" class="msgerror"/>');
				$spanErrorRegistro.insertBefore('#form_registro');
			}
			if($passw.val().trim().length==0){
				controlError($passw,'El campo Nombre Usuario no puede estar vacío');
				return false;
			}
			if($passw.val().trim().length==0){
				controlError($passw,'El campo Contraseña no puede estar vacío');
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
	<nav>
		<table>
			<tr>
				<td><h3>Librería Formación</h3></td>
				<td><div><a href="cancelarRegistro">Cancelar</a></div></td>
		</table>
	</nav>
	<h2>Nuevo Registro</h2>
	<c:if test="${not empty registro.registro_error}">
		<span id="error_registro" style="color: red">${registro.registro_error}</span>
	</c:if>
	<form role="form" action="registro" id="form_registro" method="post">
		<table>
			<tr>
				<td><label for="username">Nombre Usuario:</label></td>
				<td><input type="text" id="username" name="username" 
						value="${registro.username}"/></td>
			</tr>
			<tr>
				<td><label for="password">Contraseña:</label></td>
				<td><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td><label for="password">Repetir Contraseña:</label></td>
				<td><input type="password" id="passwordrep"/></td>
			</tr>
			<tr>
				<td colspan="2"><button id="btn_registro" type="submit">Registro</button></td>
			</tr>
		</table>
	</form>
</body>
</html>