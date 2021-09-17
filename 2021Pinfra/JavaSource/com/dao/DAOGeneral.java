package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Localidad;
import com.entities.MetodoMuestreo;
import com.entities.TipoDato;
import com.entities.TipoMuestreo;
import com.entities.UnidadMedida;
import com.entities.Zona;

public class DAOGeneral {
	
	public static List<MetodoMuestreo> obtenerMetodosMuestreo(EntityManager em) {
		TypedQuery<MetodoMuestreo> query = em.createQuery("SELECT mm FROM MetodoMuestreo mm order by mm.idMetodo", MetodoMuestreo.class);
		List<MetodoMuestreo> resultados = query.getResultList();
		return resultados;
	}
	
	public static List<EstacionMuestreo> obtenerEstacionMuestreo(EntityManager em) {
		TypedQuery<EstacionMuestreo> query = em.createQuery("SELECT em FROM EstacionMuestreo em order by em.idEstacionMuestreo", EstacionMuestreo.class);
		List<EstacionMuestreo> resultados = query.getResultList();
		return resultados;
	}
	
	public static List<Departamento> obtenerDepartamentos(EntityManager em) {
		TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d order by d.idDepartamento", Departamento.class);
		List<Departamento> resultados = query.getResultList();
		return resultados;
	}
	
	public static List<Zona> listarZonas(EntityManager em) {		
		TypedQuery<Zona> query = em.createQuery("SELECT t FROM Zona t order by t.idZona", Zona.class);
		List<Zona> listaZonas= query.getResultList();
		return listaZonas;		
	}
	
	public static List<TipoMuestreo> listarTipoMuestreo(EntityManager em) {		
		TypedQuery<TipoMuestreo> query= em.createQuery("SELECT t FROM TipoMuestreo t order by t.idTipoMuestreo", TipoMuestreo.class);
		List<TipoMuestreo> listaTipMuestreo= query.getResultList();
		return listaTipMuestreo;
	}
	
	public static List<Localidad> listarLocalidades(EntityManager em) {		
		TypedQuery<Localidad> query = em.createQuery("SELECT t FROM Localidad t order by t.idLocalidad", Localidad.class);
		List<Localidad> listaLocalidades= query.getResultList();
		return listaLocalidades;		
	}
	
	public static List<TipoDato> listarTipoDatos(EntityManager em) {
		TypedQuery<TipoDato> query = em.createQuery("SELECT t FROM TipoDato t order by t.idTipoDato", TipoDato.class);
		List<TipoDato> listaTipoDatos = query.getResultList();
		return listaTipoDatos;	}

	public static List<UnidadMedida> listarUniMed(EntityManager em) {
		TypedQuery<UnidadMedida> query = em.createQuery("SELECT u FROM UnidadMedida u order by u.idUnidadMedida", UnidadMedida.class);
		List<UnidadMedida> listaTipoInput = query.getResultList();
		return listaTipoInput;
	}
}
