package modelo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.daos.interfaces.UsuarioDaoInterfaz;
import modelo.entidades.Equipo;
import modelo.entidades.Usuario;
import util.Conexion;

public class UsuarioDao implements UsuarioDaoInterfaz{

	@Override
	public List<Usuario> getAll() {
		List<Usuario> lista = new ArrayList<Usuario>();
		String query =  "select * from usuarios";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setCorreo(rs.getString("correo"));
				u.setPassword(rs.getString("password"));
				lista.add(u);
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
	public Usuario getUsuario(int id) {
		Usuario u = null;
		String query =  "select * from usuarios where id ="+id;
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setCorreo(rs.getString("correo"));
				u.setPassword(rs.getString("password"));
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
		return u;
	}
	
	public Usuario getUsuarioByLogin(String correo, String pass) {
		Usuario u = null;
		String query =  "select * from usuarios where correo ='"+correo+"' and password='"+pass+"'";
		Connection cn = Conexion.abrirConexion();
		try
		{
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query.toString());
			while (rs.next())
			{
				u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setCorreo(rs.getString("correo"));
				u.setPassword(rs.getString("password"));
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
		return u;
	}

}
