package modelo.daos.interfaces;

import java.util.List;

import modelo.entidades.Equipo;
import modelo.entidades.Jugador;

public interface JugadorDaoInterfaz {
	List<Jugador> getAll();
	List<Jugador> getByPorSeleccion(String seleccion);
	List<Jugador> getByPorEquipo(int equipo);
	int crearAlineacion(String[] alineados);
	int eliminarAlineacion (int equipo);
	List<Jugador> getAlineadosByEquipo(int equipo);
	List<Jugador> getJugadoresEnVenta();
	int changeJugadoresEnVenta(List<Integer> trasferibles);
	int eliminarTransferibles();
	List<Integer> getIdsJugadoresByEquipo(int equipo);
}
