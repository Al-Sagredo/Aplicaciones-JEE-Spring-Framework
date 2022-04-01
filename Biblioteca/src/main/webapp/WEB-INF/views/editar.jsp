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
<title>BIBLIOTECA EDITAR</title>
</head>
<body>
	<div class="p-3">
		<h1>EDITAR LIBRO</h1>
		
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>

			<form action="editar" method="post">
	
	<input type="hidden" name="id" value="${VO.getId()}">
		<table>
		
			<tr>
				<td class="p-2"><label for="titulo">Titulo:</label></td>
				<td><input class="form-control" type="text" name="titulo" placeholder="Nombre" value="${VO.getTitulo()}" /></td>
			</tr>
			<tr>
				<td class="p-2"><label for="autor">Autor:</label></td>
				<td><input class="form-control" type="text" placeholder="Autor" name="autor" value="${VO.getAutor()}" /></td>
			</tr>
			<tr>
				<td class="p-2"><label for="ano">Año:</label></td>
				<td><input class="form-control" type="number" placeholder="Año" name="ano" maxlength="2022" value="${VO.getAno()}" /></td>
			</tr>
			<tr>
			<td class="p-2"><label for="imprenta">Imprenta:</label></td>
				<td><input class="form-control" type="text" placeholder="Imprenta" name="imprenta"  value="${VO.getImprenta()}" /></td>
			</tr>
			<tr>
			<td>Disponible:</td>
				<td><select name="disponible">
						<option value="si" ${'si'.equals(VO.getDisponible()) ? 'selected' : ''}>SI</option>
						<option value="no" ${'no'.equals(VO.getDisponible()) ? 'selected' : ''}>NO</option>
					</select></td>

			</tr>
			
			<tr>
				<td colspan="2"><input class="btn m-2 btn-success" type="submit" value="Guardar" /></td>

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