package com.capa2LogicaNegocio;



import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dao.DAOActividad;
import com.entities.Actividad;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Localidad;
import com.entities.MetodoMuestreo;
import com.entities.TipoMuestreo;
import com.entities.Zona;


/**
 * Session Bean implementation class ActividadBean
 */
@Stateless
public class ActividadBean implements ActividadBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public ActividadBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void cargarActividadDeCampo(Actividad actividad) throws Exception {
		
		
		DAOActividad.cargarActividadDeCampo( actividad, em);
		
	}

	@Override
	public void listarActividadesDeCampo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarActividadesDeCampo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Formulario> listarFormularios() {
		
		return DAOActividad.listarFormularios(em);
		
	}

	@Override
	public Departamento buscarDepartamento(long depSelec) {
		
		return DAOActividad.buscarDepartamento(depSelec, em);
	}

	@Override
	public EstacionMuestreo buscarEstacionMuestreo(long estacionMuestreo) {
		
		return DAOActividad.buscarEstacionMuestreo(estacionMuestreo,em);
	}

	@Override
	public Localidad buscarLocalidad(long idlocalidad) {
		
		return DAOActividad.buscarLocalidad(idlocalidad,em);
	}

	@Override
	public Formulario buscarFormulario(long idFormulario) {
		
		return DAOActividad.buscarFormulario(idFormulario,em);
	}

	@Override
	public Zona buscarZona(long idZona) {
		
		return DAOActividad.buscarZona(idZona,em);
	}

	@Override
	public TipoMuestreo buscarTipoMuestreo(long idMetodo) {
		
		return DAOActividad.buscarTipoMuestreo(idMetodo, em);
	}

	@Override
	public MetodoMuestreo buscarMetodoMuestreo(long idMetodo) {
		
		return DAOActividad.buscarMetodoMuestreo(idMetodo, em);
	}
	
	@Override
	public List<Actividad> obtenerActividadesEstacionMuestreo(Date fechaInicio, Date fechaFin, String nombreUsuario, String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento) {
		return DAOActividad.obtenerActividadesEstacionMuestreo(em, fechaInicio, fechaFin, nombreUsuario, rolUsuario, metodoMuestreo, estacionMuestreo, departamento);
	}

	@Override
	public List<Actividad> obtenerActividadesRangoFechas(Date fechaInicio, Date fechaFin, String nombreUsuario, String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento) {
		return DAOActividad.obtenerActividadesRangoFechas(em, fechaInicio, fechaFin, nombreUsuario, rolUsuario, metodoMuestreo, estacionMuestreo, departamento);
	}

	@Override
	public List<Actividad> obtenerActividadesUsuariosExpertos(Date fechaInicio, Date fechaFin, String nombreUsuario, String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento) {
		return DAOActividad.obtenerActividadesRangoFechas(em, fechaInicio, fechaFin, nombreUsuario, rolUsuario, metodoMuestreo, estacionMuestreo, departamento);
	}

	public List<Actividad> listarActividadesCampoXForm(String nomU,Long idForm) {
		
		return DAOActividad.listarActividadesCampoXForm( nomU,idForm,em);
	}


}
