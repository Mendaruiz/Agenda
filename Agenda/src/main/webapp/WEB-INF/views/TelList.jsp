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
		<h1>LISTADO DE TELEFONOS</h1>
	
	</div>
	<%@include file="cabecera.jsp" %>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<div class="navbar-center">
						<input id="searchTerm" type="text" class="btn btn-default " placeholder="Escriba algo para filtrar" onkeyup="doSearch()"/>
					</div>
			<table id="datos" class="table table-hover sortable">
				<thead>
					<tr>
						<th>Persona</th>
						<th>telefono</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="telefono" items="${telefonos}">
						<tr class="success">
							<td>${telefono.persona.nombre} ${telefono.persona.apellido1} ${telefono.persona.apellido2}</td>
							<td>${telefono.telefono}</td>
							<td><a href="deleteTel?id=${telefono.idtelefonos}">Eliminar</a></td>
							
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
    <script language="javascript">
		function doSearch() {
			var tableReg = document.getElementById('datos');
			var searchText = document.getElementById('searchTerm').value
					.toLowerCase();
			var cellsOfRow = "";
			var found = false;
			var compareWith = "";

			// Recorremos todas las filas con contenido de la tabla
			for (var i = 1; i < tableReg.rows.length; i++) {
				cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
				found = false;
				// Recorremos todas las celdas
				for (var j = 0; j < cellsOfRow.length && !found; j++) {
					compareWith = cellsOfRow[j].innerHTML.toLowerCase();
					// Buscamos el texto en el contenido de la celda
					if (searchText.length == 0
							|| (compareWith.indexOf(searchText) > -1)) {
						found = true;
					}
				}
				if (found) {
					tableReg.rows[i].style.display = '';
				} else {
					// si no ha encontrado ninguna coincidencia, esconde la
					// fila de la tabla
					tableReg.rows[i].style.display = 'none';
				}
			}
		}
	</script>
	
</body>
</html>