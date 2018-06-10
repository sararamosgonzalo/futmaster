package modelo.daos.interfaces;

import java.util.List;
import java.util.Map;

import modelo.entidades.Equipo;
import modelo.entidades.Partido;

public interface PartidoDaoInterfaz {
	List<Partido> getAll();
	List<Partido> getByJornada(int jornada);
	List<Partido> getBySeleccion(int seleccion);
	
}
