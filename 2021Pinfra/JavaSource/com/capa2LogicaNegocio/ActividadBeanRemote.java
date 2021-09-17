package com.capa2LogicaNegocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.entities.Actividad;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Localidad;
import com.entities.MetodoMuestreo;
import com.entities.TipoMuestreo;
import com.entities.Zona;

@Remote
public interface ActividadBeanRemote {
	void cargarActividadDeCampo( Actividad activi) throws Exception;
	void listarActividadesDeCampo();
	void eliminarActividadesDeCampo();
	Departamento buscarDepartamento(long depSelec);
	EstacionMuestreo buscarEstacionMuestreo(long estacionMuestreo);
	Localidad buscarLocalidad(long idlocalidad);
	Formulario buscarFormulario(long idFormulario);
	Zona buscarZona(long idZona);
	TipoMuestreo buscarTipoMuestreo(long idMetodo);
	MetodoMuestreo buscarMetodoMuestreo(long idMetodo);
	List<Formulario> listarFormularios();
	List<Actividad> obtenerActividadesUsuariosExpertos(Date fechaInicio, Date fechaFin,
			String nombreUsuario, String rolUsuario, String metodoMuestreo, String estacionMuestreo,
			String departamento);
	List<Actividad> obtenerActividadesRangoFechas(Date fechaInicio, Date fechaFin, String nombreUsuario,
			String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento);
	List<Actividad> obtenerActividadesEstacionMuestreo(Date fechaInicio, Date fechaFin, String nombreUsuario,
			String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento);
	
	List<Actividad> listarActividadesCampoXForm(String nomU, Long idForm);
}
