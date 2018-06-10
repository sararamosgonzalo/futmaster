package modelo.entidades;

import java.util.Date;

public class Partido {
private int id;
private int jornada;
private int equipo_local;
private int equipo_visitante;
private int goles_local;
private int goles_visitante;
private Date fecha;
 

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getJornada() {
	return jornada;
}
public void setJornada(int jornada) {
	this.jornada = jornada;
}

public int getGolesLocal() {
	return goles_local;
}
public void setGolesLocal(int goles_local) {
	this.goles_local = goles_local;
}

public int getGolesVisitante() {
	return goles_visitante;
}
public void setGolesVisitante(int goles_visitante) {
	this.goles_visitante = goles_visitante;
}

public int getEquipoLocal() {
	return equipo_local;
}

public void setEquipoLocal(int equipo_local) {
	this.equipo_local = equipo_local;
}

public int getEquipoVisitante() {
	return equipo_visitante;
}

public void setEquipoVisitante(int equipo_visitante) {
	this.equipo_visitante = equipo_visitante;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}


}
