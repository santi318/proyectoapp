package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.entities.Formulario;

public class DAOFormulario {

	public DAOFormulario() {
	}

	public static void insertarFormulario(String nombre, String resumen, EntityManager em) throws Exception {

		Formulario form = new Formulario();
		try {
			form.setNombre(nombre);
			form.setResumen(resumen);
			form.setStatus(1L);
			em.persist(form);
			em.flush();

		} catch (Exception e) {
			throw new Exception("No se pudo crear el formulario!!");
		}

	}

	public static List<Formulario> listarFormularios(EntityManager em) { // Lista los formularios de la BD con status 1
																			// ("Los que no se han eliminado")

		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.status=1", Formulario.class); //
		List<Formulario> resultados = query.getResultList();
		return resultados;
	}

	public static void eliminarFormulario(Long idForm, EntityManager em) { // Elimina de forma lógica
		em.createQuery("UPDATE Formulario f SET f.status=0 WHERE f.id='" + idForm + "' ").executeUpdate(); // cambia el
																											// atributo
																											// status a
																											// 0.
		return;
	}

	public static Formulario find(Long idForm, EntityManager em) throws Exception {

		Formulario formBuscado = null;
		TypedQuery<Formulario> query = em
				.createQuery("SELECT f FROM Formulario f WHERE f.id LIKE :idF", Formulario.class).setParameter("idF", idForm);
		formBuscado = (Formulario) query.getSingleResult();
		return formBuscado;

		// }

	}
	
	public static void EditarFormulario(Formulario form, EntityManager em) {
		em.merge(form);
		em.flush();
	}

	
	

}
