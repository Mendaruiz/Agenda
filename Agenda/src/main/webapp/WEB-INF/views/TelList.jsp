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
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			
			<nav class="navbar navbar-default navbar-static-top" role="navigation">
				<div class="navbar-header">
					 
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
					</button> <a class="navbar-brand" href="/Agenda/">Agenda</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li >
							<a href="new">A�adir Usuario</a>
						</li>
						<li>
							<a href="telefonos">Telefonos</a>
						</li>
					</ul>
					<form:form class="navbar-form navbar-left" action="search" method="get">
						<div class="form-group">
							<input type="text" class="form-control" name="nombre">
						</div> 
						<button type="submit" class="btn btn-default">
							Buscar
						</button>
					</form:form>
					
				</div>
				
			</nav>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Persona</th>
						<th>telefono</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="telefono" items="${telefonos}">
						<tr class="success">
							<td>${telefono.persona.nombre} ${telefono.persona.apellido1} ${telefono.persona.apellido2}</td>
							<td>${telefono.telefono}</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
	
	
</body>
</html>