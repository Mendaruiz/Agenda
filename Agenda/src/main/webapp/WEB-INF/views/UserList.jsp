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

<title>LISTADO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE USUARIOS</h1>
		<h3>
			<a href="new">Clic para crear un NUEVO USUARIO</a>
		</h3>
		<h3>
			<a href="telefonos">Telefonos</a>
		</h3>

		<table border="1">
		<tr>
			<th>N�</th>
			<th>Usuario</th>
			<th>Apellidos</th>
			<th>DNI</th>
			<th>Fecha de Nacimiento</th>
			<th>Telefono </th>
			</tr>
			<c:forEach var="persona" items="${lista}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${persona.nombre}</td>
					<td>${persona.apellido1} ${persona.apellido2}</td>
					<td>${persona.dni}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${persona.fechaNacimiento}" /></td>
					
				</tr>
			</c:forEach>
		</table>
		
		<form:form action="search" method="get" >
			<input type="text" name="nombre" id="nombre"/>
			<input type="submit" value="Buscar Agenda"></td>
		</form:form>
	</div>
</body>
</html>