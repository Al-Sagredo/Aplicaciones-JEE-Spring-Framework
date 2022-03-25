<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
						<td><form:label path="nombre">Nombre:</form:label></td>
						<td><form:input path="nombre" /></td>
						<td><form:label path="apellidoPaterno">Apellido Paterno:</form:label></td>
						<td><form:input path="apellidoPaterno" /></td>
						<td><form:label path="apellidoMaterno">Apellido Materno:</form:label></td>
						<td><form:input path="apellidoMaterno" /></td>
					</tr>
					<tr>
						<td><form:label path="direccion">Dirección:</form:label></td>
						<td><form:input path="direccion" /></td>
						<td><form:label path="telefono">Teléfono:</form:label></td>
						<td><form:input path="telefono" /></td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="button" value="Agregar" onclick="submitFormAction('/contactManager/addContact', 'post')" />
	
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>

	<fieldset>
		<legend>Lista de contactos</legend>
		<table style="margin: 50px auto;" border="1">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<th>Dirección</th>
				<th>Teléfono</th>
			</tr>

				<c:forEach items="${listaContactos}" var="contacto">
					<tr>
						<td><c:out value="${contacto.getId()}" /></td>
						<td><c:out value="${contacto.getNombre()}" /></td>
						<td><c:out value="${contacto.getApellidoPaterno()}" /></td>
						<td><c:out value="${contacto.getApellidoMaterno()}" /></td>
						<td><c:out value="${contacto.getDireccion()}" /></td>
						<td><c:out value="${contacto.getTelefono()}" /></td>
						<td><form method="post" action="/contactManager/deleteContact/?id=${contacto.getId()}"><input type="submit" value="Eliminar"></form></td>
					
					</tr>

				</c:forEach>
	
		</table>
	</fieldset>

	<!-- Javascript -->
	<script type="text/javascript">
		var idSelect = 0;
		function submitFormAction(action, method) {
			document.getElementById("frmAcciones").action = action;
			document.getElementById("frmAcciones").method = method;
			document.getElementById("frmAcciones").submit();
		}
		
	</script>
</body>
</html>