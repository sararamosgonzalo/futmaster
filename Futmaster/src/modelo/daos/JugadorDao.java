package modelo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.daos.interfaces.JugadorDaoInterfaz;
import modelo.entidades.Jugador;
import util.Conexion;

public class JugadorDao implements JugadorDaoInterfaz{
public EquipoDao equipoDao = new EquipoDao();

private Map<Integer, String> seleccionesMap = null;
	@Override
	public List<Jugador> getAll() {
			//Primero llamamos al metodo que nos carga el map con las selecciones, para setear lue
			cargarSelecciones();
			List<Jugador> lista = new ArrayList<Jugador>();
			String query =  "select * from jugadores";
			Connection cn = Conexion.abrirConexion();
			try
			{
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(query.toString());
				while (rs.next())
				{
					Jugador j = new Jugador();
					j.setId(rs.getInt("id"));
					j.setNombre(rs.getString("nombre"));
					j.setEquipo(equipoDao.getEquipo(rs.getInt("id_equipo")));
					j.setPrecio(rs.getInt("precio"));
					j.setPuesto(rs.getString("puesto"));
					j.setPuntos(rs.getInt("puntos"));
					j.setSeleccion(seleccionesMap.get(rs.getInt("id_seleccion")));
					j.setAlineado(rs.getBoolean("alineado"));
					j.setEn_venta(rs.getBoolean("en_venta"));
					lista.add(j);
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
	public List<Jugador> getByPorSeleccion(String seleccion) {
		//Recuperamos el id de la seleccion:
		 cargarSelecciones();
		 int id_seleccion = 0;
		 for (Map.Entry<Integer, String> entry : seleccionesMap.entrySet()) {
			 if(entry.getValue().equals(seleccion)) {
			   id_seleccion = entry.getKey();
			 }
			}
		 String query =  "select * from jugadores where id_seleccion ="+id_seleccion;
		
		List<Jugador> lista = new ArrayList<Jugador>();
		//String query =  "select * from jugadores where seleccion ='"+seleccion+"'";
		
		
		Connection cn = Conexion.abrirConexion();
		int contador = 0;
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				System.out.println(contador++);
				Jugador j = new Jugador();
				j.setId(rs.getInt("id"));
				j.setNombre(rs.getString("nombre"));
				j.setEquipo(equipoDao.getEquipo(rs.getInt("id_equipo")));
				j.setPrecio(rs.getInt("precio"));
				j.setPuesto(rs.getString("puesto"));
				j.setPuntos(rs.getInt("puntos"));
				j.setSeleccion(seleccionesMap.get(rs.getInt("id_seleccion")));
				j.setAlineado(rs.getBoolean("alineado"));
				j.setEn_venta(rs.getBoolean("en_venta"));
				lista.add(j);
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
	public List<Jugador> getByPorEquipo(int equipo) {
		cargarSelecciones();
		List<Jugador> lista = new ArrayList<Jugador>();
		String query =  "select * from jugadores where id_equipo ="+equipo;
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Jugador j = new Jugador();
				j.setId(rs.getInt("id"));
				j.setNombre(rs.getString("nombre"));
				j.setEquipo(equipoDao.getEquipo(rs.getInt("id_equipo")));
				j.setPrecio(rs.getInt("precio"));
				j.setPuesto(rs.getString("puesto"));
				j.setPuntos(rs.getInt("puntos"));
				j.setSeleccion(seleccionesMap.get(rs.getInt("id_seleccion")));
				j.setAlineado(rs.getBoolean("alineado"));
				j.setEn_venta(rs.getBoolean("en_venta"));
				lista.add(j);
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
	public int crearAlineacion(String[] alineados) {
		// TODO Auto-generated method stub
		String consulta = "UPDATE jugadores SET alineado = 1 where id IN(";
		for(int i=0; i<= (alineados.length-1); i++) {
			consulta += Integer.parseInt(alineados[i])+", ";
		}
		consulta = consulta.substring(0, consulta.length()-2);
		consulta += ");";
		
		Connection cn = Conexion.abrirConexion();
		
		int filas=0;
		try {
			Statement st = cn.createStatement();
			filas = st.executeUpdate(consulta);
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
		return filas;
	}

	@Override
	public int eliminarAlineacion(int equipo) {
		String consulta = "UPDATE jugadores SET alineado = 0 where id_equipo = "+equipo; 
		Connection cn = Conexion.abrirConexion();
		
		int filas=0;
		try {
			Statement st = cn.createStatement();
			filas = st.executeUpdate(consulta);
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
		return filas;
	}

	
	
	public void cargarSelecciones() {
		seleccionesMap = new HashMap<Integer, String>();
		String query =  "select * from selecciones";
		Connection cn = Conexion.abrirConexion();
		int contador = 0;
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				seleccionesMap.put(rs.getInt("id"), rs.getString("seleccion"));
				
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

		
	}

	@Override
	public List<Jugador> getAlineadosByEquipo(int equipo) {
		cargarSelecciones();
		List<Jugador> lista = new ArrayList<Jugador>();
		String query =  "select * from jugadores where id_equipo ="+equipo+" and alineado = 1";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Jugador j = new Jugador();
				j.setId(rs.getInt("id"));
				j.setNombre(rs.getString("nombre"));
				j.setEquipo(equipoDao.getEquipo(rs.getInt("id_equipo")));
				j.setPrecio(rs.getInt("precio"));
				j.setPuesto(rs.getString("puesto"));
				j.setPuntos(rs.getInt("puntos"));
				j.setSeleccion(seleccionesMap.get(rs.getInt("id_seleccion")));
				j.setAlineado(rs.getBoolean("alineado"));
				j.setEn_venta(rs.getBoolean("en_venta"));
				lista.add(j);
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
//MERCADO
	@Override
	public List<Jugador> getJugadoresEnVenta() {
		cargarSelecciones();
		List<Jugador> lista = new ArrayList<Jugador>();
		String query =  "select * from jugadores where en_venta = 1";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Jugador j = new Jugador();
				j.setId(rs.getInt("id"));
				j.setNombre(rs.getString("nombre"));
				j.setEquipo(equipoDao.getEquipo(rs.getInt("id_equipo")));
				j.setPrecio(rs.getInt("precio"));
				j.setPuesto(rs.getString("puesto"));
				j.setPuntos(rs.getInt("puntos"));
				j.setSeleccion(seleccionesMap.get(rs.getInt("id_seleccion")));
				j.setAlineado(rs.getBoolean("alineado"));
				j.setEn_venta(rs.getBoolean("en_venta"));
				lista.add(j);
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
	public int changeJugadoresEnVenta(List<Integer> trasferibles) {
		// TODO Auto-generated method stub
				String consulta = "UPDATE jugadores SET en_venta = 1 where id IN(";
				for(Integer i : trasferibles) {
					consulta += i+", ";
				}
				consulta = consulta.substring(0, consulta.length()-2);
				consulta += ");";
				
				Connection cn = Conexion.abrirConexion();
				
				int filas=0;
				try {
					Statement st = cn.createStatement();
					filas = st.executeUpdate(consulta);
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
				
		return filas;
	}

	//ponemos a no transferibles a todos los los jugadores de futmondo:
	@Override
	public int eliminarTransferibles() {
		String consulta = "UPDATE jugadores SET en_venta = 0 where id_equipo = 11"; 
		Connection cn = Conexion.abrirConexion();
		
		int filas=0;
		try {
			Statement st = cn.createStatement();
			filas = st.executeUpdate(consulta);
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
		return filas;
	}

	@Override
	public List<Integer> getIdsJugadoresByEquipo(int equipo) {
		List<Integer> listaIds =new ArrayList <Integer>();
		String query =  "select * from jugadores where id_equipo ="+equipo;
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				listaIds.add(rs.getInt("id"));
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
		return listaIds;
	}

}
