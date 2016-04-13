<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JRuteros | Administrador</title>


<link
	href="${pageContext.request.contextPath}/resources/js/jquery-ui-1.11.4.custom/jquery-ui.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<!-- Bootstrap CSS -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/fronted.css"
	rel="stylesheet">

<!-- Bootstrap JS -->
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>


<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand aLogo" href="#"><div class="logo"></div></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#"><span class="fa fa-user" aria-hidden="true">
					</span>Administrador</a></li>
				<li><a href="listarUsuarios"><span class="fa fa-road" aria-hidden="true">
					</span>Usuarios</a></li>
				<li><a href="listarActividades"><span class="fa fa-road" aria-hidden="true">
					</span>Actividades</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li>
					<a href="#" class="dropdown-toggle"	role="button" aria-haspopup="true" aria-expanded="false"> 
						<img class="img-perfil" src="#" alt="Foto Perfil">
					</a>
				</li>
				<li><a href="logout" class="salir">Salir</a></li>
			</ul>
		</div>
	</div>
</nav>

	<div class="container">

		<div>
			<a href="altaActividad"
				class="btn btn-primary" role="button">Crear actividad</a>

		</div>
		<h4>Actividades Habilitadas</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Actividad</th>
					<th>Cantidad de rutas asociadas</th>
					<th>Detalle rutas</th>
					<th>Modificacion</th>
					<th>Deshabilitacion</th>
					<th>Eliminacion</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Actividad 1</td>
					<td>3</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Rutas</li>
								<li>A la montaña</li>
								<li>Al bosque</li>
								<li>To the hell</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-warning"
						value="Modificar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Deshabilitar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Actividad 3</td>
					<td>4</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Rutas</li>
								<li>A la montaña</li>
								<li>Al bosque</li>
								<li>Al rio</li>
								<li>Al glaciar</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-warning"
						value="Modificar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Deshabilitar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Actividad 5</td>
					<td>0</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Rutas</li>
								<li>No posee rutas</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-warning"
						value="Modificar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Deshabilitar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" /></td>
				</tr>
			</tbody>
		</table>

		<h4>Actividades Deshabilitadas</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Actividad</th>
					<th>Cantidad de rutas asociadas</th>
					<th>Detalle rutas</th>
					<th>Modificacion</th>
					<th>Habilitacion</th>
					<th>Eliminacion</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Actividad 2</td>
					<td>5</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Rutas</li>
								<li>Al parque</li>
								<li>A lo de Carlitos</li>
								<li>A la costa</li>
								<li>A las cataratas</li>
								<li>A casa</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-warning"
						value="Modificar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Habilitar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>Actividad 4</td>
					<td>0</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Rutas</li>
								<li>No posee rutas</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-warning"
						value="Modificar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Habilitar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" /></td>
				</tr>
				<tr>
					<td>Actividad 6</td>
					<td>2</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Rutas</li>
								<li>A la montaña</li>
								<li>Al bosque</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-warning"
						value="Modificar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Habilitar" /></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" disabled="disabled" /></td>
				</tr>
			</tbody>
		</table>

	</div>

	<footer class="footer">
	<div class="container">
		<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</div>
	</footer>
</body>
</html>