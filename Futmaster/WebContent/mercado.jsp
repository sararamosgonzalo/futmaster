<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,
    modelo.entidades.Jugador,
    java.text.DecimalFormat"
    %>
    
<%
	Integer id=(Integer)session.getAttribute("id");
	if(id==null){
%>
	<jsp:forward page="ErrorSesion.jsp"/>;
<%
	}
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="contenidoPag">
	<div class="cabPag sombra">
		<div class="tituloPag"><span class="textocab">Mercado</span></div>
		<div class="subPag"><span class="textocab">Selecciona un equipo para ver sus jugadores</span></div>
	</div>
</div>

<%
//Si el iusuarios es Sra, puede camiar los transferibles:
if (id ==1){%>
<form action="Controlador" method="get" >
		<input type="hidden" name="op" value="toMercado">
		<input type="hidden" name="cambiarTransferibles" value="si">
		<button type="submit" id="botonCambiarTrasferibles" class="sombra">Cambiar transferibles</button>
</form>
<%	
}

%>

	<div id="plantillas" class="divContenedor sombra">
	<table id="tablaPlantilla" class="tablas">
	<caption class="titTablas">JUGADORES TRANSFERIBLES</caption>
		<tr>
			<th colspan ="3">Nombre</th>
			<th>Puntos</th>
			<th>Valor</th>
			<th>Propietario</th>
		</tr>
		<%List<Jugador> jugadores=(List<Jugador>)request.getAttribute("jugadoresEnVenta");
		DecimalFormat nf = new DecimalFormat("#,###");
		for(Jugador j :jugadores){ %>
			<tr>
			<% String puesto = j.getPuesto();
			   int id_jugador = j.getId();%>
				<td class="colorPuesto <%= puesto %> "></td>
				<td class="tdImg"><img src="Resources/images/jugadores/<%=j.getId() %>.png" class="imgJugador"></td>
				<td><%=j.getNombre() %></td>
				<td class="tdCentrada"><%=j.getPuntos() %></td>
				<td class="tdCentrada"><%=nf.format((int)j.getPrecio()) %> &euro; </td>
				<td class="tdCentrada"><%=j.getEquipo().getNombre() %></td>
			</tr>
		
		<%} %>
	</table>
	</div>
<jsp:include page="footer.jsp"></jsp:include>