<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


		<spring:url value="/resources/css/bootstrap.css" var="estilos1" />
		<link href="${estilos1}" rel="stylesheet" />
		
		<spring:url value="/resources/css/custom.css" var="estilos3" />
		<link href="${estilos3}" rel="stylesheet" />		
	
		<spring:url value="css/bootstrap.css" var="estilos2" />
		<link href="${estilos2}" rel="stylesheet" />	
		
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
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
	</div>

</body>
</html>