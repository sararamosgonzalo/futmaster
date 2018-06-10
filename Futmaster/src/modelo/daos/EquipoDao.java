package modelo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import modelo.daos.interfaces.EquipoDaoInterfaz;
import modelo.daos.interfaces.UsuarioDaoInterfaz;
import modelo.entidades.Equipo;
import util.Conexion;

public class EquipoDao implements EquipoDaoInterfaz{

	UsuarioDaoInterfaz usuarioDao = new UsuarioDao();
	
	@Override
	public List<Equipo> getAll() {
		
			List<Equipo> lista = new ArrayList<Equipo>();
			String query =  "select * from Equipos Where id <> 11";
			Connection cn = Conexion.abrirConexion();
			try
			{
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(query.toString());
				while (rs.next())
				{
					Equipo c = new Equipo();
					c.setId(rs.getInt("id"));
					c.setNombre(rs.getString("nombre"));
					c.set_usuario(usuarioDao.getUsuario(rs.getInt("id_usuario")));
					c.setSaldo(rs.getInt("saldo"));
					c.setPuntos(rs.getInt("puntos"));
					lista.add(c);
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
	public Equipo getEquipo(int id) {
		
		Equipo c = null;
		String query =  "select * from Equipos where id ="+id;
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				c = new Equipo();
				c.setId(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));
				c.set_usuario(usuarioDao.getUsuario(rs.getInt("id_usuario")));
				c.setSaldo(rs.getInt("saldo"));
				c.setPuntos(rs.getInt("puntos"));
				
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
		return c;
	}

	public Equipo getEquipoByUsuario(int id) {
		
		Equipo c = null;
		String query =  "select * from Equipos where id_usuario ="+id;
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				c = new Equipo();
				c.setId(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));
				c.set_usuario(usuarioDao.getUsuario(rs.getInt("id_usuario")));
				c.setSaldo(rs.getInt("saldo"));
				c.setPuntos(rs.getInt("puntos"));
				
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
		return c;
	}
	
	public Map<String, Integer> getClasificacionEquipos() {
		
		//LinkedHashMap nos respeta el orden de inserccion
		Map<String, Integer> clasificacion = new LinkedHashMap<String, Integer>();
		
		String query = "select nombre, puntos from equipos ORDER BY puntos DESC";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				clasificacion.put(rs.getString("nombre"), rs.getInt("puntos"));
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
		return clasificacion;

	}
}
