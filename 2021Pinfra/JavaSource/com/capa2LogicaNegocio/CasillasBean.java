package com.capa2LogicaNegocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dao.DAOCasilla;
import com.entities.Casilla;
import com.entities.TipoDato;
import com.entities.UnidadMedida;

/**
 * Session Bean implementation class CasillasBean
 */
@Stateless
public class CasillasBean implements CasillasBeanRemote {
	@PersistenceContext
	private EntityManager em;

	private static DAOCasilla daoCasillas;

	/**
	 * Default constructor.
	 */
	public CasillasBean() {
		daoCasillas = new DAOCasilla();
	}

	@Override
	public List<Casilla> listarCasillas() {
		return daoCasillas.listarFormularios(em);
	}

	@Override
	public void altaCasilla(String desc, String param, TipoDato tipoDato, UnidadMedida unuMedida) throws Exception {
		try {

			daoCasillas.altaCasilla(desc, param, tipoDato, unuMedida, em);
			return;

		} catch (Exception e) {
			throw new Exception("No se puede crear la casilla!");
		}
	}	

	@Override
	public TipoDato buscarTipoDatoSele(String nomtipoDato) {

		return DAOCasilla.buscarTipoDatoSele(nomtipoDato, em);
	}

	@Override
	public UnidadMedida buscarUnidadMedida(String itemSelectUnidad) {

		return DAOCasilla.buscarUnidadMedida(itemSelectUnidad, em);
	}

	@Override
	public void ModificarCasilla(Long id,String des, String par,UnidadMedida uni, TipoDato tipDato) {
	
		DAOCasilla.modificarCasilla( id, des, par,uni, tipDato, em);
		
	}

	@Override
	public Casilla buscarCasilla(Long idCas) {
		
		return DAOCasilla.buscarCasilla(idCas, em);
		
	}
}