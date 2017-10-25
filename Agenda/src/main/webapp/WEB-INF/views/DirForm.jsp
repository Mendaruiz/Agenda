<%@page import="com.proyecto.agenda.model.Telefono"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.proyecto.agenda.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
			
<title>FORMULARIO DE TELEFONOS</title>

</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE TELEFONOS </h1>	
	</div>
	<%@include file="cabecera.jsp" %>
		<%
					
					int id = (Integer)request.getAttribute("idPersona");
					System.out.println("---------------- Entra en el DirForm -------------------- " + id);
					Direccion direccion = (Direccion) request.getAttribute("direccion");
					System.out.println(direccion.toString());
				%>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3" >
			<form:form action="saveDir" method="get"  modelAttribute="direccion">
				<form:hidden path="iddirecciones"/>
				<form:hidden path="persona.idpersonas" value="<%=id%>"/>
				<div class="form-group">
					<label>
						Direccion
					</label>
					<form:input path="direccion" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						Codigo Postal
					</label>
					<form:input path="codPostal" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						Localidad
					</label>
					<form:input path="localidad" class="form-control"/>
				</div>
				<div class="form-group">
					<label>
						Provincia
					</label>
					<form:input path="provincia" class="form-control"/>
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