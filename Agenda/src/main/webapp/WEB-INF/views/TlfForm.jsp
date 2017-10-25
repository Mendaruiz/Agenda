<%@page import="com.proyecto.agenda.model.Telefono"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.proyecto.agenda.dao.*"%>

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
					System.out.println("---------------- Entra en el TlfForm -------------------- " + id);
					Telefono tel = (Telefono) request.getAttribute("telefono");
					System.out.println(tel.toString());
				%>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3" >
			<form:form action="saveTlf" method="get"  modelAttribute="telefono">
				<form:hidden path="idtelefonos"/>
				<form:hidden path="persona.idpersonas" value="<%=id%>"/>
				<div class="form-group">
					<label>
						Telefono
					</label>
					<form:input path="telefono" class="form-control"/>
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