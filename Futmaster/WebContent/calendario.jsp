<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,
    modelo.entidades.Partido"%>

<%
	Integer id=(Integer)session.getAttribute("id");
	if(id==null){
%>
	<jsp:forward page="ErrorSesion.jsp"/>;
<%
	}
	
	List<Partido> jornada1 = (List<Partido>) request.getAttribute("jornada1");
	List<Partido> jornada2 = (List<Partido>) request.getAttribute("jornada2");
	List<Partido> jornada3 = (List<Partido>) request.getAttribute("jornada3");
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="contenidoPag">
	<div class="cabPag sombra">
		<div class="tituloPag"><span class="textocab">Calendario</span></div>
		<div class="subPag"><span class="textocab">Fechas y resultados de los partidos por jornada</span></div>
	</div>
	<div class="calendario" id="calenJornada1">
		<table class="tablas">
			<caption class="titTablas">Jornada 1</caption>
			<tr>
			<%for(Partido p: jornada1) { }%>
				<th colspan=6>14 de junio</th>
			</tr>
			<tr>
				<td>17:00</td>
				<td>Rusia </td>
				<td><img src='Resources/images/banderas/rusia.png' alt="Rusia" title="Rusia" class='banderas'></td>
				<td> 4 - 2 </td>
				<td><img src='Resources/images/banderas/arabia-saudi.png' alt="Arabia Saudí" title="Arabia Saudí" class='banderas'></td>
				<td> Arabia</td>
			</tr>
		</table>
	</div>
	<div class="calendario" id="calenJornada2">
		<table>
			<caption class="titTablas">Jornada 2</caption>
		</table>
	</div>
	<div class="calendario" id="calenJornada3">
		<table>
			<caption class="titTablas">Jornada 3</caption>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>