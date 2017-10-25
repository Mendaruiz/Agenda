<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">

        <spring:url value="static/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet" />
        <spring:url value="static/css/custom.css" var="custom"/>
        <link href="${custom}" rel="stylesheet" /> 
        <link href="static/css/bootstrap.min.css" rel="stylesheet" /> 
        <link href="static/css/style.css" rel="stylesheet" /> 
        
<title>LISTADO DE TELEFONOS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE DIRECCIONES</h1>
	
	</div>
	<%@include file="cabecera.jsp" %>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<div class="navbar-center">
						<input id="searchTerm" type="text" class="btn btn-default " placeholder="Escriba algo para filtrar" onkeyup="doSearch()"/>
					</div>
			<table class="table table-hover sortable">
				<thead>
					<tr>
						<th>Persona</th>
						<th>Direccion</th>
						<th>Codigo Postal</th>
						<th>Localidad</th>
						<th>Provincia</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="direccion" items="${direcciones}">
						<tr class="success">
							<td>${direccion.persona.nombre} ${direccion.persona.apellido1} ${direccion.persona.apellido2}</td>
							<td>${direccion.direccion}</td>
							<td>${direccion.codPostal}</td>
							<td>${direccion.localidad}</td>
							<td>${direccion.provincia}</td>	
							<td><a href="deleteDir?id=${direccion.iddirecciones}">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
	<script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/scripts.js"></script>
    <script src="static/js/sorttable.js"></script>
	
</body>
</html>