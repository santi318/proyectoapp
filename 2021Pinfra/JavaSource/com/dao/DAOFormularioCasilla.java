package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.entities.FormularioCasilla;

public class DAOFormularioCasilla {
	
	public static FormularioCasilla find(Long idFormulario, Long idCasilla, EntityManager em) throws Exception {
		FormularioCasilla formBuscado = null;
		TypedQuery<FormularioCasilla> query = em
				.createQuery("SELECT f FROM FormularioCasilla f WHERE f.id.idFormulario LIKE :idFormulario"
						+ " and f.id.idCasilla LIKE :idCasilla", FormularioCasilla.class)
				.setParameter("idFormulario", idFormulario)
				.setParameter("idCasilla", idCasilla);
		try {
			formBuscado = (FormularioCasilla) query.getSingleResult();
		}
		catch(NoResultException ex) {
			return null;
		}
		return formBuscado;
	}
	
	public static void insertarFormularioCasilla(FormularioCasilla formularioCasilla, EntityManager em) throws Exception {
		try {
			em.persist(formularioCasilla);
			em.flush();
		} catch (Exception e) {
			throw new Exception("No se pudo crear el formulario casilla!!");
		}
	}
	
	public static void quitarFormularioCasilla(FormularioCasilla formularioCasilla, EntityManager em) throws Exception {
		try {
			em.remove(formularioCasilla);
			em.flush();
		} catch (Exception e) {
			throw new Exception("No se pudo quitar el formulario casilla!!");
		}
	}
	
	public static void editarFormularioCasilla(FormularioCasilla formularioCasilla, EntityManager em) throws Exception {
		try {
			em.merge(formularioCasilla);
			em.flush();
		} catch (Exception e) {
			throw new Exception("No se pudo editar el formulario casilla!!");
		}
	}
}
