package modelo.daos.interfaces;

import java.util.List;
import java.util.Map;

import modelo.entidades.Equipo;

public interface EquipoDaoInterfaz {
	List<Equipo> getAll();
	Equipo getEquipo(int id);
	Equipo getEquipoByUsuario(int id);
	Map<String, Integer> getClasificacionEquipos();
	
	
}
