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

<title>LISTADO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE Telefonos</h1>
		<table border="1">
		<tr>
			<th>Nº</th>
			<th>telefono</th>
			</tr>
			<c:forEach var="telefono" items="${telefonos}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${telefono.telefono}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>