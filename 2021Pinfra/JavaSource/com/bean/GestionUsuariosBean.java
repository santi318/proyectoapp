package com.bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;	//JEE8
import javax.inject.Named;
import com.capa2LogicaNegocio.GestionUsuarioService;
import com.capa2LogicaNegocio.Usuario;
import com.exception.PersistenciaException;



@Named(value="gestionUsuarios")		//JEE8
@SessionScoped				        //JEE8
public class GestionUsuariosBean implements Serializable{
	
	@EJB
	GestionUsuarioService gestionUsuarioService;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String nomUser;
	private String contrasenia;
	private String criterioNombre;
	private String criterioRol;
	private Boolean criterioActivo;
	
	private List<Usuario> usuariosSeleccionados;
	private Usuario usuarioSeleccionado;
	public GestionUsuariosBean() {
		super();
	}
	
	// ********Acciones****************************
	public String seleccionarUsuarios() throws PersistenciaException {
		usuariosSeleccionados=gestionUsuarioService.seleccionarUsuarios(criterioNombre, criterioRol, criterioActivo);
		return "";
	}
	
	
	public String verDatosUsuario() {
		//Navegamos a datos usuario
		return "DatosUsuario";
	}
	
	// ******** Getters & Setters****************************
	
	
	public String getCriterioNombre() {
		return criterioNombre;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setCriterioNombre(String criterioNombre) {
		this.criterioNombre = criterioNombre;
	}
	public String getCriterioRol() {
		return criterioRol;
	}
	public void setCriterioRol (String criterioRol) {
		this.criterioRol = criterioRol;
	}
	public Boolean getCriterioActivo() {
		return criterioActivo;
	}
	public void setCriterioActivo(Boolean criterioActivo) {
		this.criterioActivo = criterioActivo;
	}
	public List<Usuario> getUsuariosSeleccionados() {
		return usuariosSeleccionados;
	}
	public void setUsuariosSeleccionados(List<Usuario> usuariosSeleccionados) {
		this.usuariosSeleccionados = usuariosSeleccionados;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
	public String inicioSesion (String user, String contrasenia) {
		String redireccion = null;
		try {
			gestionUsuarioService.buscarInicioSesion(user, contrasenia);
			redireccion="Usuarios";
		}catch (Exception e) {
			
		}
		return redireccion;
		
	}
	
	
	
}
