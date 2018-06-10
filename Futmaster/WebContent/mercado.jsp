<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

<jsp:include page="footer.jsp"></jsp:include>