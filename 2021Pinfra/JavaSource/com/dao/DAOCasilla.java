package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.entities.Casilla;
import com.entities.TipoDato;
import com.entities.UnidadMedida;

public class DAOCasilla {

	public DAOCasilla() {
		// TODO Auto-generated constructor stub
	}

	public static List<Casilla> listarFormularios(EntityManager em) {
		TypedQuery<Casilla> query = em.createQuery("SELECT c FROM Casilla c order by c.idCasilla", Casilla.class);
		List<Casilla> resultados = query.getResultList();
		return resultados;
	}

	public void altaCasilla(String desc, String param, TipoDato tipoDato, UnidadMedida unuMedida, EntityManager em)
			throws Exception {

		try {

			Casilla cas = new Casilla();
			cas.setDescripcion(desc);
			cas.setParametro(param);
			cas.setTiposDato(tipoDato);
			cas.setUnidadesMedida(unuMedida);
			em.persist(cas);

		} catch (Exception e) {
			throw new Exception("No se puede crear la casilla!");
		}

	}
	

	public static TipoDato buscarTipoDatoSele(String nomtipoDato, EntityManager em) {

		TypedQuery<TipoDato> query = em
				.createQuery("SELECT t FROM TipoDato t WHERE t.tipoDato=:tipDato ", TipoDato.class)
				.setParameter("tipDato", nomtipoDato);
		TipoDato tipoBuscado = query.getSingleResult();
		return tipoBuscado;

	}

	public static UnidadMedida buscarUnidadMedida(String itemSelectUnidad, EntityManager em) {

		TypedQuery<UnidadMedida> query = em
				.createQuery("SELECT t FROM UnidadMedida t WHERE t.nombre=:uniMed ", UnidadMedida.class)
				.setParameter("uniMed", itemSelectUnidad);
		UnidadMedida unidadBuscada = query.getSingleResult();
		return unidadBuscada;
	}

	public static void modificarCasilla(Long idCas,String des, String par,UnidadMedida uni, TipoDato tipDato,EntityManager em) {
		
		Casilla casBuscada= buscarCasilla(idCas, em);
		
		casBuscada.setDescripcion(des);
		casBuscada.setParametro(par);
		casBuscada.setUnidadesMedida(uni);
		casBuscada.setTiposDato(tipDato);
		em.merge(casBuscada);
		em.flush();
		
	}

	public static Casilla buscarCasilla(Long idCasi, EntityManager em) {
		
		TypedQuery<Casilla> query= em.createQuery("SELECT f FROM Casilla f WHERE f.idCasilla=:idcas ", Casilla.class).setParameter("idcas", idCasi);
		Casilla casBuscada= query.getSingleResult();
		return casBuscada;
		
	}
}
