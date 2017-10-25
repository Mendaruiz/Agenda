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
			
	<%@include file="cabecera.jsp" %>
		
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
						1� Apellido
					</label>
					<form:input path="apellido1" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						2� Apellido
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