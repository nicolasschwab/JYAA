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
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand aLogo" href="#"><div class="logo"></div></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#"><span class="fa fa-user" aria-hidden="true">
					</span>Administrador</a></li>
				<li><a href="listarUsuarios"><span class="fa fa-road"
						aria-hidden="true"> </span>Usuarios</a></li>
				<li><a href="listarActividades"><span class="fa fa-road"
						aria-hidden="true"> </span>Actividades</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li><a href="#" class="dropdown-toggle" role="button"
					aria-haspopup="true" aria-expanded="false"> <img
						class="img-perfil" src="#" alt="Foto Perfil">
				</a></li>
				<li><a href="logout" class="salir">Salir</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<ul class="nav nav-tabs">
			<li class="active" id="liHab"><a href="#">Usuarios
					Habilitados</a></li>
			<li id="liDes"><a href="#">Usuarios Deshabilitados</a></li>
		</ul>

		<table class="table table-striped" id="tablaHabilitada">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Domicilio</th>
					<th>Fecha Nacimiento</th>
					<th>Sexo</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>22435432</td>
					<td>Juan</td>
					<td>Perez</td>
					<td>Calle 1 n°500</td>
					<td>05/05/89</td>
					<td>M</td>
					<td>juan@perez.com</td>
					<td><input type="button" class="btn btn-default"
						value="Deshabilitar" /></td>
					<td>
				</tr>
				<tr>
					<td>234523453</td>
					<td>Marta</td>
					<td>Gomez</td>
					<td>Calle 3 n°700</td>
					<td>09/07/90</td>
					<td>F</td>
					<td>marta@gomez.com</td>
					<td><input type="button" class="btn btn-default"
						value="Deshabilitar" /></td>
					<td>
				</tr>
				<tr>
					<td>283949254</td>
					<td>Belen</td>
					<td>Gesell</td>
					<td>Calle 9 n°1200</td>
					<td>29/03/56</td>
					<td>F</td>
					<td>belen@gesell.com</td>
					<td><input type="button" class="btn btn-default"
						value="Deshabilitar" /></td>
					<td>
				</tr>
			</tbody>
		</table>


		<table class="table table-striped" style="display: none"
			id="tablaDeshabilitada">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Domicilio</th>
					<th>Fecha Nacimiento</th>
					<th>Sexo</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>21564721</td>
					<td>Ramon</td>
					<td>Díaz</td>
					<td>Calle 3 n°600</td>
					<td>11/06/87</td>
					<td>M</td>
					<td>ramon@diaz.com</td>
					<td><input type="button" class="btn btn-default"
						value="Habilitar" /></td>
					<td>
				</tr>
				<tr>
					<td>38284923</td>
					<td>Pedro</td>
					<td>Asnar</td>
					<td>Calle 6 n°800</td>
					<td>17/03/77</td>
					<td>M</td>
					<td>pedro@asnar.com</td>
					<td><input type="button" class="btn btn-default"
						value="Habilitar" /></td>
					<td>
				</tr>
				<tr>
					<td>287627283</td>
					<td>Ruben</td>
					<td>Martinez</td>
					<td>Calle 12 n°1800</td>
					<td>26/05/47</td>
					<td>M</td>
					<td>ruben@martinez.com</td>
					<td><input type="button" class="btn btn-default"
						value="Habilitar" /></td>
					<td>
				</tr>
			</tbody>
		</table>

	</div>

	<footer class="footer">
	<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</footer>

	<script type="text/javascript">
		$("#liDes").click(function() {
			$("#liHab").removeClass("active");
			$("#tablaHabilitada").hide();
			$(this).addClass("active");
			$("#tablaDeshabilitada").show();
		});
		$("#liHab").click(function() {
			$("#liDes").removeClass("active");
			$("#tablaDeshabilitada").hide();
			$(this).addClass("active");
			$("#tablaHabilitada").show();
		});
	</script>

</body>
</html>