package modelo.entidades;

import java.util.List;

public class Equipo {
private int id;
private String nombre;
private Usuario _usuario;
private int saldo;
private int puntos;
private List<Jugador> jugadores;


public List<Jugador> getJugadores() {
	return jugadores;
}
public void setJugadores(List<Jugador> jugadores) {
	this.jugadores = jugadores;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Usuario get_usuario() {
	return _usuario;
}
public void set_usuario(Usuario _usuario) {
	this._usuario = _usuario;
}
public int getSaldo() {
	return saldo;
}
public void setSaldo(int saldo) {
	this.saldo = saldo;
}
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}

}
