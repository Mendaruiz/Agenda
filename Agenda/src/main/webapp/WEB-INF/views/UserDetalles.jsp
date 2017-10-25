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

<title>DETALLES DE USUARIO</title>
</head>
<body>
	<div align="center">
		<h1>Usuario</h1>
	</div>
	<%@include file="cabecera.jsp" %>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th>
							Nombre
						</th>
						<th>
							Apellidos 
						</th>
						<th>
							DNI
						</th>
						<th>
							Fecha de Nacimiento
						</th>
						<th>
							Telefonos
						</th>
						<th>
							Direcciones
						</th>
					</tr>
				</thead>
				<tbody>
						<tr class="success">
							<td>${persona.nombre}</td>
							<td>${persona.apellido1} ${persona.apellido2}</td>
							<td>${persona.dni}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${persona.fechaNacimiento}" /></td>
							<td>
								<c:forEach var="telefono" items="${persona.telefonos}">
									<p>${telefono.telefono}</p>
								</c:forEach>
							</td>
							<td>
								<c:forEach var="direccion" items="${persona.direcciones}">
									<p>${direccion.direccion} ${direccion.codPostal} ${direccion.localidad} ${direccion.provincia}</p>
									
								</c:forEach>
							</td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
	
	
	
	
	
</body>
</html>