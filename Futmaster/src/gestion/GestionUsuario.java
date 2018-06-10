package gestion;

import modelo.daos.UsuarioDao;
import modelo.daos.interfaces.UsuarioDaoInterfaz;
import modelo.entidades.Usuario;

public class GestionUsuario {
	UsuarioDaoInterfaz usuDao = new UsuarioDao();
	
public Integer usuarioCorrecto (String correo, String pass){
	Usuario usuario = usuDao.getUsuarioByLogin(correo, pass);
	if(usuario!=null){
		return usuario.getId();
	}
	return null;
}
	

}
