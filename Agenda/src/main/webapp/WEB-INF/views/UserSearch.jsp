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

<title>USUARIO BUSCADO</title>
</head>
<body>
	<div align="center">
		<h1>USUARIOS</h1>
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
					</tr>
				</thead>
				<tbody>
					<c:forEach var="persona" items="${lista}">
						<tr class="success">
							<td><a href="detalle?idpersona=${persona.idpersonas}">${persona.nombre}</a></td>
							<td>${persona.apellido1} ${persona.apellido2}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>