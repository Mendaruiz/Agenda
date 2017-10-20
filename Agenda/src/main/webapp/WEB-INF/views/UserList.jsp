<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">

        <spring:url value="static/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet" />
        <spring:url value="static/css/custom.css" var="custom"/>
        <link href="${custom}" rel="stylesheet" />  

<title>LISTADO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE USUARIOS</h1>
		<h3>
			<a href="new">Clic para crear un NUEVO USUARIO</a>
		</h3>

		<table border="1">
		<tr>
			<th>Nº</th>
			<th>Usuario</th>
			<th>Apellidos</th>
			<th>DNI</th>
			</tr>
			<% 
				//request.getAttribute("list");
			
			
			%>
			<c:forEach var="persona" items="${lista}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${persona.nombre}</td>
					<td>${persona.apellido1}</td>
					<td>${persona.apellido2}</td>
					<td>${persona.dni}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>