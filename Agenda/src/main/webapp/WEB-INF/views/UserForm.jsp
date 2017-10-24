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
	<script type="text/javascript">
			jQuery(function($){
			   $("#date").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
			});
	</script>

</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE USUARIOS (add/edit)</h1>
		<table>
			<form:form action="save" method="get"  modelAttribute="persona">
				<form:hidden path="idpersonas"/>
				<tr>
					<td>Nombre:</td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td>Apellido1:</td>
					<td><form:input path="apellido1" /></td>
				</tr> 
				<tr>
					<td>Apellido2:</td>
					<td><form:input path="apellido2" /></td>
				</tr>
				<tr>
					<td>Dni:</td>
					<td><form:input path="dni" /></td>
				</tr>
				 	
				<tr>
					<td>Fecha de nacimiento</td>
					<td><form:input id="date" path="fechaNacimiento" title="Enter a date in this format DD/MM/YYYY"/></td>
                </tr>
				
				<!--
				<tr>
					<%
					   Date dNow = new Date();
					   SimpleDateFormat ft = 
					   new SimpleDateFormat ("yyyy/MM/dd");
					   String currentDate = ft.format(dNow);
					   System.out.println(currentDate);
					%>
					<td>Fecha de nacimiento</td>
					<td><form:input type="date" id="fecha" path="fechaNacimiento" data-date-format="YYYY/MM/DD"/></td>
				</tr>
				-->
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Guardar Registro"></td>
				</tr>
			</form:form>
		</table>
		
		
		<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Añadir Usuario
			</h3>
			<form:form action="save" method="get"  modelAttribute="persona">
				<form:hidden path="idpersonas"/>
				<div class="form-group">
					<label>
						Nombre
					</label>
					<form:input path="nombre" />
				</div>
				<div class="form-group">
					<label>
						Apellido1
					</label>
					<form:input path="apellido1" />
				</div>
				<div class="form-group">
					<label>
						Apellido2
					</label>
					<form:input path="apellido2" />
				</div>
				<div class="form-group">
					<label>
						Dni
					</label>
					<form:input path="dni" />
				</div>
				<div class="form-group">
					<label>
						Fecha de Nacimiento
					</label>
					<form:input path="fechaNacimiento" />
				</div>
				<button type="submit" class="btn btn-default">
					Submit
				</button>
			</form:form>
		</div>
	</div>
</div>
		
		
	</div>
		<script src="static/js/jquery.min.js"></script>
	    <script src="static/js/bootstrap.min.js"></script>
	    <script src="static/js/scripts.js"></script>
</body>
</html>