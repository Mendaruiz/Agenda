<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

	<spring:url value="/resources/css/bootstrap.min.css" var="bm" />
	<link href="${bm}" rel="stylesheet" />
	
	<spring:url value="/resources/css/custom.css" var="btm"/>
    <link href="${btm}" rel="stylesheet" /> 

<title>Detalles del Contacto</title>
</head>
<body>
	
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1>
				Detalles del Contacto
				
			</h1>
			
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
		<p><strong>Nombre : </strong>${persona.nombre}</p>
		</div>
		<div class="col-md-8">
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		<p><strong>Apellidos : </strong>${persona.apellido1} ${persona.apellido2}</p>
		</div>
		<div class="col-md-8">
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		<p><strong>Fecha de Nacimiento :</strong></p>
		</div>
		<div class="col-md-8">
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		<p><strong>DNI : </strong>${persona.dni}</p>
		</div>
		<div class="col-md-8">
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		<p><strong>Tlf : </strong></p>
		</div>
		<div class="col-md-8">
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		<p><strong>Grupo : </strong></p>
		</div>
		<div class="col-md-8">
		</div>
	</div>
	
</div>

</body>
</html>