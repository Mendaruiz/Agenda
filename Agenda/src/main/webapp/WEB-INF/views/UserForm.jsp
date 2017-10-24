<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
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
			
<title>FORMULARIO DE USUARIOS</title>

</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE USUARIOS </h1>	
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
							<a href="new">Añadir Usuario</a>
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
			</div>
			</div>
			</div>
		
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3" >
			<form:form action="save" method="get"  modelAttribute="persona">
				<form:hidden path="idpersonas"/>
				<div class="form-group">
					<label>
						Nombre
					</label>
					<form:input path="nombre" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						1º Apellido
					</label>
					<form:input path="apellido1" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						2º Apellido
					</label>
					<form:input path="apellido2" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						Dni
					</label>
					<form:input path="dni" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						Fecha de Nacimiento
					</label>
					<form:input path="fechaNacimiento" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-default">
					Guardar Registro
				</button>
			</form:form>
		</div>
	</div>
</div>

		
		
		<script src="static/js/jquery.min.js"></script>
	    <script src="static/js/bootstrap.min.js"></script>
	    <script src="static/js/scripts.js"></script>
</body>
</html>