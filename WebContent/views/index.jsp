<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JRuteros</title>
<!-- jQuery y sus css -->
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

<link
	href="${pageContext.request.contextPath}/resources/css/registro.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> login <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand aLogo" href="#"><div class="logo"></div></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">¿Qué es?</a></li>
				<li><a href="#">¿Cómo funciona?</a></li>
			</ul>

			<div class="nav navbar-nav navbar-right ">
				<form class="form-inline" action="login" method="post">
					<table>
						<tbody>
							<tr>
								<th><label for="username"></label></th>
								<th><label for="password"></label></th>
							</tr>
							<tr>
								<div class="form-group">
									<td><input type="text" name="username"
										placeholder="Usuario" class="form-control"></td>
								</div>
								<div class="form-group">
									<td><input type="password" name="password"
										placeholder="Contraseña" class="form-control"></td>
								</div>
								<td><input class="btn btn-default" type="submit"
									value="Iniciar Sesión"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>



	</div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active"
				style="background-image: url('resources/img/bike-3.jpg'); background-repeat: no-repeat;">
			</div>
			<div class="item"
				style="background-image: url('resources/img/bike-1.jpg'); background-repeat: no-repeat;">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div class="container">
		<form role="form" type="post" class="col-md-4 col-md-offset-7">
			<fieldset class="registro">
				<h3>¿No tenes una cuenta?</h3>
				<div class="form-group">
					<label for="username"></label> <input type="text"
						placeholder="Nombre de Usuario" name="username"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="dni"></label> <input type="text" name="dni"
						placeholder="DNI" class="form-control">
				</div>
				<div class="form-group">
					<label for="nomyape"></label> <input type="text"
						placeholder="Nombre y apellido" name="nombre" class="form-control">
				</div>
				<div class="form-group">
					<label for="domicilio"></label> <input type="text"
						placeholder="Domicilio" name="domicilio" class="form-control">
				</div>
				<div class="form-group">
					<label for="nacimiento"></label> <input
						placeholder="Fecha de nacimiento" type="text" name="nacimiento"
						id="nacimiento" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="checkbox-inline"> <input type="radio"
						id="male" name="sexo" value="masculino" class="form-control">Masculino
					</label> <label class="checkbox-inline"> <input type="radio"
						id="female" name="sexo" value="femenino" class="form-control">Femenino
					</label>
				</div>
				<div class="form-group">
					<label for="email"></label> <input type="email" name="email"
						placeholder="Correo electrónico" class="form-control">
				</div>
				<div class="form-group col-md-offset-3">
					<button type="button" class="btn btn-default">Registrarme</button>
				</div>
			</fieldset>
		</form>


	</div>
	<footer class="footer">
	<p>&#169; Java y Aplicaciones Avanzadas en Internet | 2016</p>
	</footer>
	<script type="text/javascript">
		$(function() {
			$('#nacimiento').datepicker();
		});
	</script>
</body>
</html>