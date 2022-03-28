<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- aqui borraste esto :action="/contactManager/addContact"  -->
	<form:form id="frmAcciones" modelAttribute="contacto" class="pb-5">
		<div>
			<fieldset>
				<legend>Mantenedor de Contactos</legend>
				<table border="1">
					<tr>
						<td>Nombre:</td>
						<td><input type="text" id="idNombre" name="nombre" /></td>
						<td>Apellido Paterno:</td>
						<td><input type="text" id="idApellidoPaterno"
							name="apellidoPaterno" /></td>
						<td>Apellido Materno:</td>
						<td><input type="text" id="idApellidoMaterno"
							name="apellidoMaterno" /></td>
					</tr>
					<tr>
						<td>Dirección:</td>
						<td colspan="3"><input type="text" id="idDireccion"
							name="direccion" width="100%" /></td>
						<td>Teléfono:</td>
						<td><input type="text" id="idTelefono" name="telefono" /></td>

					</tr>
					<tr>
						<td colspan="6"><input type="button" value="Agregar"
							onclick="submitFormAction('/contactManager/addContact', 'post')" />
							<input type="button" value="Eliminar" onclick="deleteRow()" /></td>

					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>

	<fieldset>
		<legend>Lista de contactos</legend>
		<div align="center">
			<table style="margin: 50px auto;" border="1">
				<tr>
					<th></th>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Dirección</th>
					<th>Teléfono</th>
				</tr>
				<tbody>
					<c:forEach items="${listaContactos}" var="contact">
						<tr>
						<td><input type="radio" id="optSelectRow${contact.id}"
							name="optSelectRow" onclick="setIdSelect(${contact.id})" /></td>
						<td>${contact.id}</td>
						<td>${contact.nombre}</td>
						<td>${contact.apellidoPaterno}</td>
						<td>${contact.apellidoMaterno}</td>
						<td>${contact.direccion}</td>
						<td>${contact.telefono}</td>
					</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>
	</fieldset>

	<!-- Javascript -->
	<script type="text/javascript">
		var idSelect = 0;
		
		function submitFormAction(action, method) {
			document.getElementById("frmAcciones").action = action;
			document.getElementById("frmAcciones").method = method;
			document.getElementById("frmAcciones").submit();
		}
		function setIdSelect(id){
			idSelect = id;
		}
		
		function deleteRow(){
			//alert(idSelect);
			//document.getElementById("frmAcciones").action = "/contactManager/deleteContact/?id=" + idSelect;
			//document.getElementById("frmAcciones").method = "POST";
			//document.getElementById("frmAcciones").submit();
			
			window.location.href = "/contactManager/deleteContact/?id=" + idSelect;
		}
		
	</script>
</body>
</html>


