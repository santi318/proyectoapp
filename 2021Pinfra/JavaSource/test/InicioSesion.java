package test;

import java.util.List;

import com.bean.GestionUsuariosBean;
import com.dao.UsuariosEmpresaDAO;
import com.entities.UsuarioEmpresa;
import com.exception.PersistenciaException;

public class InicioSesion {

	public static void main(String[] args) throws PersistenciaException {
		// TODO Auto-generated method stub
		GestionUsuariosBean gub = new GestionUsuariosBean();
		
		String us = gub.inicioSesion("agustin.azziz", "123456");
		
		System.out.println(us);
		
		
		UsuariosEmpresaDAO dao = new UsuariosEmpresaDAO();
		
		
		UsuarioEmpresa usDAO = dao.iniciarSesion("agustin.azziz", "123456");
		
		System.out.println (usDAO);

	}

}
