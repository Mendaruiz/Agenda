<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<spring:url value="static/css/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<spring:url value="static/css/custom.css" var="custom" />
<link href="${custom}" rel="stylesheet" />
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/style.css" rel="stylesheet" />

 

		

<title>LISTADO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE USUARIOS</h1>
	</div>

	<%@include file="cabecera.jsp"%>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/scripts.js"></script>
	<script src="static/js/sorttable.js"></script>

	<script language="javascript">
		function doSearch() {
			var tableReg = document.getElementById('datos');
			var searchText = document.getElementById('searchTerm').value
					.toLowerCase();
			var cellsOfRow = "";
			var found = false;
			var compareWith = "";

			// Recorremos todas las filas con contenido de la tabla
			for (var i = 1; i < tableReg.rows.length; i++) {
				cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
				found = false;
				// Recorremos todas las celdas
				for (var j = 0; j < cellsOfRow.length && !found; j++) {
					compareWith = cellsOfRow[j].innerHTML.toLowerCase();
					// Buscamos el texto en el contenido de la celda
					if (searchText.length == 0
							|| (compareWith.indexOf(searchText) > -1)) {
						found = true;
					}
				}
				if (found) {
					tableReg.rows[i].style.display = '';
				} else {
					// si no ha encontrado ninguna coincidencia, esconde la
					// fila de la tabla
					tableReg.rows[i].style.display = 'none';
				}
			}
		}
	</script>
	
	<!-- Si no funciona este poner
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     -->
	<script src="static/js/jquery-3.2.1.min.js"></script>

    
	<div class="container-fluid" style="margin-top:20px;">
		<div class="row">
			<div id="user" class="col-md-8 col-md-offset-2" >
			  <div class="panel panel-primary panel-table animated slideInDown">
			   <div class="panel-heading " style="padding:5px;">
			        <div class="row">
			        <div class="col col-xs-3 text-left">
			            <a href="telefonos" class="btn btn-default"><i class="glyphicon glyphicon-phone"></i>Telefonos</a>
			            <a href="direcciones" class="btn btn-default"><i class="glyphicon glyphicon-map-marker"></i>Direcciones</a>
			        </div>
			        <div class="col col-xs-5 text-center">
			            <h1 class="panel-title">Lista de Contactos</h1>
			        </div>
			        <div class="col col-xs-2 text-center" >
			         	<div class="navbar-center">
									<input id="searchTerm" type="text" class="btn btn-default " placeholder="Escriba algo para filtrar" onkeyup="doSearch()"/>
								</div>
			        </div>
			        <div class="col col-xs-2 text-right ">
						   <button type="button" class="btn  btn-success " onclick="location.href='new'"> ADD NEW<i class="fa fa-plus-square" ></i></button>
			        </div>
			        </div>
			    </div>
			   <div class="panel-body">
			     <div class="tab-content">
			      <div role="tabpanel" class="tab-pane active" id="list">
			       <table id="datos" class="table table-striped table-hover table-bordered table-list sortable">
						<thead>
								<tr>
									<th>
										Nombre
									</th>
									<th>
										Apellidos 
									</th>
									<th>
										DNI
									</th>
									<th>
										Fecha de Nacimiento
									</th>
									<th>
										Editar Persona
									</th>
									<th>
										Telefonos
									</th>
									<th>
										Insertar Telefono
									</th>
									<th>
										Direcciones
									</th>
									<th>
										Insertar Direccion
									</th>
									<th>
										Eliminar
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="persona" items="${lista}">
									<tr class="success">
										<td><a href="detalle?idpersona=${persona.idpersonas}">${persona.nombre}</a></td>
										<td>${persona.apellido1} ${persona.apellido2}</td>
										<td>${persona.dni}</td>
										<td><fmt:formatDate pattern="dd-MM-yyyy" value="${persona.fechaNacimiento}" /></td>
										<td><a href="editPerson?id=${persona.idpersonas}" class="btn btn-primary" title="Editar"    ><i class="glyphicon glyphicon-pencil">    	</i></a></td>
										
										<td>
											<c:forEach var="telefono" items="${persona.telefonos}">
												<p>${telefono.telefono}</p>
											</c:forEach>
										</td>
										<td><a href="newTel?id=${persona.idpersonas}" class="btn btn-success" title="Añadir Telefono"    ><i class="glyphicon glyphicon-earphone">    	</i></a></td>
										<td>
											<c:forEach var="direccion" items="${persona.direcciones}">
												<p>${direccion.direccion}</p>
											</c:forEach>
										</td>
										<td><a href="newDir?id=${persona.idpersonas}"class="btn btn-info" title="Añadir direccion"    ><i class="glyphicon glyphicon-home">    	</i></a></td>
										
										
										<td><a href="delete?id=${persona.idpersonas}" class="btn btn-danger"  title="delete" ><i class="glyphicon glyphicon-trash" >		</i></a></td>
									</tr>
								</c:forEach>
							</tbody>
			        </table>
			      </div>
			       
			     </div>
			    </div>
			   
			  </div>
			</div>
		</div>
	</div>

	<div class="container-fluid" style="margin-top: 20px;">
		<div class="row">
			<div id="user" class="col-md-8 col-md-offset-2">
				<div class="panel panel-primary panel-table animated slideInDown">
					<div class="panel-heading " style="padding: 5px;">
						<div class="row">
							<div class="col col-xs-3 text-left">
								<a href="telefonos" class="btn btn-default"><i
									class="glyphicon glyphicon-phone"></i>Telefonos</a> <a
									href="direcciones" class="btn btn-default"><i
									class="glyphicon glyphicon-map-marker"></i>Direcciones</a>
							</div>
							<div class="col col-xs-7 text-center">
								<h1 class="panel-title">Lista de Contactos</h1>
							</div>
						
							<div class="col col-xs-2 text-right ">
								<button type="button" class="btn  btn-success "
									onclick="location.href='new'">
									ADD NEW<i class="fa fa-plus-square"></i>
								</button>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="list">
								<table id="datos" class="table table-striped table-hover table-bordered table-list table-condensed"
									style="border-collapse: collapse;">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Apellidos</th>
											<th>Telefonos</th>
											<th>Eliminar</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="persona" items="${lista}">
											<tr data-toggle="collapse"
												data-target="#${persona.idpersonas}"
												class="success accordion-toggle">
												<td><a href="detalle?idpersona=${persona.idpersonas}">${persona.nombre}</a></td>
												<td>${persona.apellido1}${persona.apellido2}</td>
												<td><c:forEach var="telefono"
														items="${persona.telefonos}">
														<p>${telefono.telefono}</p>
													</c:forEach></td>
												<td><a href="delete?id=${persona.idpersonas}"
																		class="btn btn-danger center-block btn-sx" title="delete"><i
																			class="glyphicon glyphicon-trash"> </i></a></td>
											</tr>

											<tr>
												<td colspan="16" class="hiddenRow">
													<div id="${persona.idpersonas}"
														class="accordian-body collapse">
														<table class="table table-condensed"
															style="border-collapse: collapse;">
															<thead>
																<tr>
																	<th>DNI</th>
																	<th>Fecha de Nacimiento</th>
																	<th>Editar Persona</th>
																	<th>Insertar Telefono</th>
																	<th>Direcciones</th>
																	<th>Insertar Direccion</th>
																</tr>
															<thead>
															<tbody>
																<tr class="success">
																	<td>${persona.dni}</td>
																	<td><fmt:formatDate pattern="dd-MM-yyyy"
																			value="${persona.fechaNacimiento}" /></td>
																	<td><a href="editPerson?id=${persona.idpersonas}"
																		class="btn btn-primary" title="Editar"><i
																			class="glyphicon glyphicon-pencil"> </i></a></td>
																	<td><a href="newTel?id=${persona.idpersonas}"
																		class="btn btn-success" title="Añadir Telefono"><i
																			class="glyphicon glyphicon-earphone"> </i></a></td>
																	<td><c:forEach var="direccion"
																			items="${persona.direcciones}">
																			<p>${direccion.direccion}</p>
																		</c:forEach></td>
																	<td><a href="newDir?id=${persona.idpersonas}"
																		class="btn btn-info" title="Añadir direccion"><i
																			class="glyphicon glyphicon-home"> </i></a></td>
																</tr>
															</tbody>
														</table>
													</div>
												</td>
											</tr>

										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>