<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JRuteros | Mis Rutas</title>


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
<!-- iconos  -->
<link href="./resources/fonts/css/font-awesome.min.css" rel="stylesheet">
<link href="./resources/fonts/css/font-awesome.min.css" rel="stylesheet">
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
				<li>
					<a href="altaRuta"><span class="fa fa-plus" aria-hidden="true"> </span>Ruta Nueva</a>
				</li>
				<li>
					<a href="buscarRuta"><span class="fa fa-search" aria-hidden="true"> </span>Buscar una Ruta</a>
				</li>
				<li>
					<a href="listarRutasUsuario"><span class="fa fa-road" aria-hidden="true"> </span>Mis Rutas</a>
				</li>				
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li>
					<a href="#"><span class="fa fa-user" aria-hidden="true"> </span> Nombre Usuario</a>
				</li>
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

		<h4>Mis Rutas</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Detalle</th>
					<th>Fotos</th>
					<th>Modificacion</th>
					<th>Eliminacion</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Ruta 1</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Detalles</li>
								<li>Descripcion de ruta 1</li>
								<li>Privacidad: privada</li>
								<li>Formato: circular</li>
								<li>Distancia: 15km</li>
								<li>Dificultad: facil</li>
								<li>Actividad: ciclismo</li>
								<li>Tiempo estimado: 5 hrs</li>
								<li>Fecha realizacion</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-default"
						value="Ver fotos" /></td>
					<td><form action="altaRuta"><input type="submit" class="btn btn-warning"
						value="Modificar" /> </form></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" /></td>
					<td>
				</tr>
				<tr>
					<td>Ruta 2</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Detalles</li>
								<li>Descripcion de ruta 2</li>
								<li>Privacidad: publica</li>
								<li>Formato: circular</li>
								<li>Distancia: 5km</li>
								<li>Dificultad: dificil</li>
								<li>Actividad: alpinismo</li>
								<li>Tiempo estimado: 15 hrs</li>
								<li>Fecha realizacion</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-default"
						value="Ver fotos" /></td>
					<td><form action="altaRuta"><input type="submit" class="btn btn-warning"
						value="Modificar" /> </form></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" /></td>
					<td>
				</tr>
				<tr>
					<td>Ruta 3</td>
					<td><div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								Detalle <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Detalles</li>
								<li>Descripcion de ruta 3</li>
								<li>Privacidad: privada</li>
								<li>Formato: ida</li>
								<li>Distancia: 10km</li>
								<li>Dificultad: moderado</li>
								<li>Actividad: motociclismo</li>
								<li>Tiempo estimado: 4 hrs</li>
								<li>Fecha realizacion</li>
							</ul>
						</div></td>
					<td><input type="button" class="btn btn-default"
						value="Ver fotos" /></td>
					<td><form action="altaRuta"><input type="submit" class="btn btn-warning"
						value="Modificar" /> </form></td>
					<td><input type="button" class="btn btn-default"
						value="Eliminar" /></td>
					<td>
				</tr>
			</tbody>
		</table>
	</div>

	<footer class="footer">
		<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</footer>

</body>
</html>