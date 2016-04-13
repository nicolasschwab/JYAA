<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenido!</title>
<%@ include file="head.jsp"%>
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
					<a href="#"><span class="fa fa-road" aria-hidden="true"> </span>Ruta Nueva</a>
				</li>
				<li>
					<a href="#"><span class="fa fa-road" aria-hidden="true"> </span>Buscar una Ruta</a>
				</li>
				<li>
					<a href="#"><span class="fa fa-road" aria-hidden="true"> </span>Mis Rutas</a>
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
	
	<%@ include file="footer.jsp"%>
</body>
</html>