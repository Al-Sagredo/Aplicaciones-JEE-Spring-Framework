<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cl.desafiolatam.biblioteca.modelo.Libro"%>
<%@page import="cl.desafiolatam.biblioteca.VO.LibroVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>BIBLIOTECA AGREGAR</title>
</head>
<body>
	<div class="p-3">
		<h1>AGREGAR LIBRO</h1>
		
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close close-button" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>

		<form action="agregar" method="post">
			<table>
				<tr>
					<td class="p-2"><label for="titulo">Título:</label></td>
					<td><input class="form-control" type="text" name="titulo" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="autor">Autor:</label></td>
					<td><input class="form-control" type="text" name="autor" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="ano">Año:</label></td>
					<td><input class="form-control" type="number" name="ano" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="imprenta">Imprenta:</label></td>
					<td><input class="form-control" type="text" name="imprenta" /></td>
				</tr>
				<tr>
					<td>Disponible:</td>
					<td><select name="disponible">
							<option value="si">SI</option>
							<option value="no">NO</option>
					</select></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" class="btn m-2 btn-success" value="Agregar" /></td>
				</tr>
			</table>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>