package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

	@SuppressWarnings("finally")
	public static Connection abrirConexion(){
	Connection con = null;
	try{	
	
		Class.forName("com.mysql.jdbc.Driver");
		String servidor = "jdbc:mysql://mysql21969-mysql.jelastic.com/futmaster";
	    String usuarioDB="root";
	    String passwordDB="EROeqs80156";
	    con= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
	}
	catch(ClassNotFoundException ex)
	{
		ex.printStackTrace();
		con = null;
	}
	catch(SQLException ex)
	{
	    ex.printStackTrace();
	    con=null;
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	    con=null;
	}
	finally
	{
	    return con;
	}
		
		
	}
	
	
	public static void cerrarConexion(Connection con) throws SQLException
	{
		if (!con.isClosed())
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
