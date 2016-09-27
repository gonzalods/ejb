<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libreria Formación</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stilo.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#ckcbox_cobroIgualEntrega').click(function(evt){
			var $form_direntrega = $('#form_direntrega');
			$form_direntrega.submit();
		});
		$('#btn_siguiente').click(function(evt){
			var calle = $('#dir_calle').val();
			var ciudad = $('#dir_ciudad').val();
			var codigoPostal = $('#dir_codigoPostal').val();
			var arrCamposError = [];
			limpiarErrores();
			if(calle.trim().length == 0){
				var error = {
					campo: '#dir_calle',
					msg: 'El campo Calle es obligatorio'
				}
				arrCamposError.push(error);
			}
			if(ciudad.trim().length == 0){
				var error = {
					campo: '#dir_ciudad',
					msg: 'El campo Ciudad es obligatorio'
				}
				arrCamposError.push(error);
			}
			if(codigoPostal.trim().length == 0){
				var error = {
					campo: '#dir_codigoPostal',
					msg: 'El campo Código Postal es obligatorio'
				}
				arrCamposError.push(error);
			}
			if(arrCamposError.length != 0){
				$.each(arrCamposError, function(index, element){
					crearError(element);
				});
				return false;
			}
			return true;
		});
		
		var limpiarErrores = function(){
			$('.fielderror').removeClass('fielderror');
			$('.msgerror').detach();
		};
		var crearError = function(data){
			$span_error = $('<span id="error_passw" class="msgerror"/>');
			var $obj = $(data.campo);
			$span_error.insertAfter($obj);
			$obj.addClass('fielderror');
			$('.msgerror').html(data.msg);
		};
		
		var bool_cobroIgualEntrega = $('#ckcbox_cobroIgualEntrega').prop('checked');
		if(bool_cobroIgualEntrega){
			$("input[id^='dir_']").prop('readonly',true);
		}
	});
</script>
</head>
<body>
	<div>
		<div id="nemu-panel" >
			<jsp:include page="../fragmentos/menuorden.jsp"></jsp:include>
		</div>
	</div>	
	<h3>Dirección de entrega</h3>
	<div>
		<form id="form_direntrega" action="obtenerdirentrega" method="get">
			<label for="cobroIgualEntrega">Misma dirección de cobro</label>
			<c:if test="${not empty orden and orden.cobroIgualEntrega}">
				<input id="ckcbox_cobroIgualEntrega" type="checkbox" name="cobroIgualEntrega" checked="checked">
			</c:if>
			<c:if test="${empty orden or not orden.cobroIgualEntrega}">
				<input id="ckcbox_cobroIgualEntrega" type="checkbox" name="cobroIgualEntrega">
			</c:if>
		</form>
		<form action="resumen" method="post">
			<table>
				<tr>
					<td><label for="calle">Calle</label></td>
					<td><input type="text" id="dir_calle" name="calle" value="${orden.dirEntrega.calle }"/> </td>
				</tr>
				<tr>
					<td><label for="numero">Número</label></td>
					<td><input id="dir_numero" name="numero" value="${orden.dirEntrega.numero }"/> </td>
				</tr>
				<tr>
					<td><label for="piso">Piso</label></td>
					<td><input id="dir_piso" name="piso" value="${orden.dirEntrega.piso }"/> </td>
				</tr>
				<tr>
					<td><label for="ciudad">Ciudad</label></td>
					<td><input id="dir_ciudad" name="ciudad" value="${orden.dirEntrega.ciudad }"/> </td>
				</tr>
				<tr>
					<td><label for="zip">Código Postal</label></td>
					<td><input id="dir_codigoPostal" name="codigoPostal" value="${orden.dirEntrega.codigoPostal }"/> </td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input id="btn_siguiente" type="submit" value="Siguiente"/> 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>