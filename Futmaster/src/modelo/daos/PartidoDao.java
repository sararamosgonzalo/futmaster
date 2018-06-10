package modelo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.daos.interfaces.PartidoDaoInterfaz;
import modelo.entidades.Equipo;
import modelo.entidades.Partido;
import util.Conexion;

public class PartidoDao implements PartidoDaoInterfaz{

	@Override
	public List<Partido> getAll() {
		List<Partido> lista = new ArrayList<Partido>();
		String query =  "select * from partidos";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Partido p = new Partido();
				p.setJornada(rs.getInt("jornada"));
				p.setEquipoLocal(rs.getInt("id_equipo_local"));
				p.setEquipoVisitante(rs.getInt("id_equipo_visitante"));
				p.setFecha(rs.getTimestamp("fecha"));
				p.setGolesLocal(rs.getInt("goles_local"));
				p.setGolesVisitante(rs.getInt("goles_visitante"));
				lista.add(p);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			try {
				Conexion.cerrarConexion(cn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
		
	}

	@Override
	public List<Partido> getByJornada(int jornada) {
		List<Partido> lista = new ArrayList<Partido>();
		String query =  "select * from partidos where jornada ="+jornada+" order by fecha";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Partido p = new Partido();
				p.setJornada(rs.getInt("jornada"));
				p.setEquipoLocal(rs.getInt("id_equipo_local"));
				p.setEquipoVisitante(rs.getInt("id_equipo_visitante"));
				p.setFecha(rs.getTimestamp("fecha"));
				p.setGolesLocal(rs.getInt("goles_local"));
				p.setGolesVisitante(rs.getInt("goles_visitante"));
				lista.add(p);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			try {
				Conexion.cerrarConexion(cn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<Partido> getBySeleccion(int seleccion) {
		List<Partido> lista = new ArrayList<Partido>();
		String query =  "select * from partidos where id_equipo_local ='"+seleccion+"' or id_equipo_visitante= '"+seleccion+"';";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Partido p = new Partido();
				p.setJornada(rs.getInt("jornada"));
				p.setEquipoLocal(rs.getInt("id_equipo_local"));
				p.setEquipoVisitante(rs.getInt("id_equipo_visitante"));
				p.setFecha(rs.getDate("fecha"));
				p.setGolesLocal(rs.getInt("goles_local"));
				p.setGolesVisitante(rs.getInt("goles_visitante"));
				lista.add(p);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			try {
				Conexion.cerrarConexion(cn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	
}
