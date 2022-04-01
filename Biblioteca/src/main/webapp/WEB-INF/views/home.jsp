<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cl.desafiolatam.biblioteca.modelo.Libro"%>
<%@page import="cl.desafiolatam.biblioteca.VO.LibroVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>home</title>
</head>
<body>
	<h1>BIBLIOTECA</h1>
	<div class="p-3">
		<!-- Inicio Mensajes -->
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show"
				role="alert">${mensaje}

				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>

		<a href="agregarForm" class="btn m-2 btn-success">Agregar libro</a>
		<form action="buscarLibro" method="get">
			<br> <input type="text" name="texto">
			<button type="submit">Buscar</button>
		</form>
		<br style="margin-top: 15px" />
		<table border="1" class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id Libro</th>
					<th scope="col">Título</th>
					<th scope="col">Autor</th>
					<th scope="col">Año</th>
					<th scope="col">Imprenta</th>
					<th scope="col">Disponible</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listaLibros}" var="libro">
				<tr>
					<td>${libro.id}</td>
					<td>${libro.titulo}</td>
					<td>${libro.autor}</td>
					<td>${libro.ano}</td>
					<td>${libro.imprenta}</td>
					<td>${libro.disponible} </td>

					<td style="display:flex; justify-content:space-around"><a href="editarForm?idLibro=${libro.id}" class="btn btn-primary btn-sm">Editar</a> <br />
						<a href="eliminar?id=${libro.id}" class="btn btn-danger btn-sm">Eliminar</a> 
						<a href="cambiarDisp?id=${libro.id}" class="btn btn-warning">Cambiar Disponibilidad</a>
						</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
</body>