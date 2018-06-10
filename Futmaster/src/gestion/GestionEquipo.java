package gestion;

import java.util.HashMap;
import java.util.List;

import modelo.daos.EquipoDao;
import modelo.daos.JugadorDao;
import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Equipo;
import modelo.entidades.Jugador;

public class GestionEquipo {
	EquipoDaoInterfaz equiDao = new EquipoDao();
	JugadorDaoInterfaz jugadoresDao = new JugadorDao();
	

	
	public int getValorequipo(Equipo equipo) {
		List <Jugador> listaJugadores = equipo.getJugadores();
		int valorEquipo = 0;
		for (Jugador jugador : listaJugadores) {
			valorEquipo += jugador.getPrecio();
		}
		
		return valorEquipo;
	}
	
	public int insertarPuntosEquipo(Equipo equipo) {
		List <Jugador> listaJugadores = equipo.getJugadores();
		int puntosEquipo = 0;
		for (Jugador jugador:listaJugadores) {
			puntosEquipo += jugador.getPuntos();
		}
		return puntosEquipo;
	}
	
	
}
