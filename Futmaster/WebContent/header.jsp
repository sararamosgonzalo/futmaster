<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="modelo.entidades.Equipo" 
    import = "java.text.DecimalFormat"
    import = "gestion.GestionEquipo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Resources/css/estilos.css">
<link rel="shortcut icon" href="Resources/images/logos/futmaster.png">
<title>Futmaster</title>
</head>
<body class="fondo">
<header>
	<%
	Equipo equipo = (Equipo)session.getAttribute("equipo");
	GestionEquipo ge = new GestionEquipo();
	DecimalFormat nf = new DecimalFormat("#,###");
	int saldo = equipo.getSaldo();
	int ofertas = 3000000;
	int balance = saldo - ofertas;
	%>
<div id="containerHeader" class="sombra">
	<div id="perfil">
	<p id="nombre"><%=equipo.get_usuario().getNombre()%></p>
	<img src="Resources/images/perfil.png" id="fotoperfil">
	<a href="Controlador?op=toPerfil">Mi perfil</a>
	<a href="Controlador?op=toLogOut">Desconectar</a>
	</div>
	<div id="info">
	<h3><%=equipo.getNombre()%></h3>
	<table id="tabla1">
		<tr>
			<td class="celda1">Fondos:</td><td class="alignDcha"><%=nf.format(saldo) %> &euro; </td>
		</tr> 
		<tr>
			<td>Ofertas:</td><td class="alignDcha negativo"><%=nf.format(ofertas) %> &euro; </td>
		</tr>
		<tr>
			<td>Balance:</td><td class="alignDcha"><%=nf.format(balance) %> &euro;</td>
		</tr>
		<tr>
			<td>Valor del equipo:</td><td class="alignDcha"><%=nf.format(ge.getValorequipo(equipo))%> &euro; </td>
		</tr>
	</table>
	<table id="tabla2">
		<tr>
			<td class="celda1">Puntos:</td><td class="alignDcha"><%=equipo.getPuntos()%></td>
		</tr>
		<tr>
			<td>Posición:</td><td class="alignDcha">0</td>
		</tr>
	</table>
	</div>
	<div><img src="Resources/images/logos/mundial.jpg" id="logoMundial"></div>
	<nav>
		<ul>
			<li><a href="Controlador?op=toAlineacion&formAlineacion=no">Alineación</a></li>
			<li><a href="Controlador?op=toClasificacion">Clasificación</a></li>
			<li><a href="Controlador?op=toMercado&cambiarTransferibles=no">Mercado</a></li>
			<li><a href="Controlador?op=toPlantillas&seleccion=Alemania">Plantillas</a></li>
			<li><a href="Controlador?op=toAdministracion&id=<%=equipo.getId()%>">Administración</a></li>
			<li><a href="Controlador?op=toCalendario">Calendario</a></li>
		</ul>
	</nav>
</div>
</header>