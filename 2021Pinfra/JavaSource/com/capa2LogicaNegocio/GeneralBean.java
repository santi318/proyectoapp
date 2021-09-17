package com.capa2LogicaNegocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dao.DAOGeneral;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Localidad;
import com.entities.MetodoMuestreo;
import com.entities.TipoDato;
import com.entities.TipoMuestreo;
import com.entities.UnidadMedida;
import com.entities.Zona;

/**
 * Session Bean implementation class GeneralBean
 */
@Stateless
public class GeneralBean implements GeneralBeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GeneralBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public List<MetodoMuestreo> obtenerMetodosMuestreo() {
		return DAOGeneral.obtenerMetodosMuestreo(em);
	}
	
	@Override
	public List<EstacionMuestreo> obtenerEstacionMuestreo() {
		return DAOGeneral.obtenerEstacionMuestreo(em);
	}

	@Override
	public List<Departamento> obtenerDepartamentos() {
		return DAOGeneral.obtenerDepartamentos(em);
	}
	
	@Override
	public List<Zona> listarZonas() {	
		return DAOGeneral.listarZonas(em);		
	}
	
	@Override
	public List<TipoMuestreo> listarTipoMuestros() {		
		return DAOGeneral.listarTipoMuestreo(em);
	}
	
	@Override
	public List<Localidad> listarLocalidades() {		
		return DAOGeneral.listarLocalidades(em);		
	}
	
	@Override
	public List<TipoDato> listarTipoDatos() {
		return DAOGeneral.listarTipoDatos(em);
	}

	@Override
	public List<UnidadMedida> listarUniMed() {
		return DAOGeneral.listarUniMed(em);
	}
}
