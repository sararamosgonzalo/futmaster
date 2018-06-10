<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import= "java.util.Map"
    import= "java.util.Iterator"
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
		<div class="tituloPag"><span class="textocab">Clasificación</span></div>
		<div class="subPag"><span class="textocab">Campeonato Futmaster Mundial de Rusia 2018</span></div>
	</div>
	<div id="clasificacion" class="divContenedor sombra">
		<table id="cGeneral" class="tablas">
			<caption class="titTablas">General</caption>
			<tr>
				<th colspan="2">Equipo</th>
				<th>Puntos</th>
			</tr>
			<% Map<String, Integer> clasificacion = (Map) request.getAttribute("clasificacion");
			Iterator<String> it = (Iterator) clasificacion.keySet().iterator();
			int contador = 0;
			while(it.hasNext()) {
				String nombreEquipo = (String) it.next();
				Integer puntos = (Integer) clasificacion.get(nombreEquipo);
				contador += 1;%>
				<tr>
				<td class="tdClasif tdCentrada"><%=contador %> &deg;</td>
				<td class="tdCentrada"><%=nombreEquipo %></td>
				<td class="tdCentrada"><%=puntos %></td>
			</tr>
			<% }
			%>
			
		</table>
		<table id="cJornada" class="tablas">
			<caption class="titTablas">De la Jornada</caption>
			<tr>
				<th colspan="2">Equipo</th>
				<th>Puntos</th>
			</tr>

			<tr>
				<td class="tdClasif tdCentrada">1</td>
				<td>Nombre Equipo</td>
				<td class="tdCentrada">Puntos</td>
			</tr>
		</table>
	</div>
	
</div>

<jsp:include page="footer.jsp"></jsp:include>