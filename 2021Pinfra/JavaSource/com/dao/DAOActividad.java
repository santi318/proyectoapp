package com.dao;



import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import com.entities.Actividad;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Localidad;
import com.entities.MetodoMuestreo;
import com.entities.TipoMuestreo;
import com.entities.Zona;



public class DAOActividad {

	public DAOActividad() {
		// TODO Auto-generated constructor stub
	}

	public static void cargarActividadDeCampo(Actividad actividad, EntityManager em) throws Exception {
		try {
			em.persist(actividad);
			em.flush();
		} catch (Exception e) {
			throw new Exception("No se puede creaR");
		}		
	}

	public static List<Formulario> listarFormularios(EntityManager em) {
		
		TypedQuery<Formulario> query = em.createQuery("SELECT t FROM Formulario t ", Formulario.class);
		List<Formulario> listaFormularios= query.getResultList();
		return listaFormularios;
		
	}

	public static Departamento buscarDepartamento(long depSelec,EntityManager em) {
		
		TypedQuery<Departamento> query= em.createQuery("SELECT d FROM Departamento d WHERE d.idDepartamento=:id", Departamento.class).setParameter("id", depSelec);
		return query.getSingleResult();
	}

	public static Zona buscarZona(long idZona, EntityManager em) {
		
		TypedQuery<Zona> query=em.createQuery("SELECT z FROM Zona z WHERE z.idZona=:id ", Zona.class).setParameter("id", idZona);
		return query.getSingleResult();
	}

	public static Formulario buscarFormulario(long idFormulario, EntityManager em) {
		
		TypedQuery<Formulario> query=em.createQuery("SELECT f FROM Formulario f WHERE f.id=:idF ", Formulario.class).setParameter("idF", idFormulario);
		return query.getSingleResult();
	}

	public static Localidad buscarLocalidad(long idlocalidad, EntityManager em) {
		
		TypedQuery<Localidad> query=em.createQuery("SELECT l FROM Localidad l WHERE l.idLocalidad=:id ", Localidad.class).setParameter("id", idlocalidad);
		return query.getSingleResult();
	}

	public static EstacionMuestreo buscarEstacionMuestreo(long estacionMuestreo, EntityManager em) {
		
		TypedQuery<EstacionMuestreo> query=em.createQuery("SELECT e FROM EstacionMuestreo e WHERE e.idEstacionMuestreo=:id ", EstacionMuestreo.class).setParameter("id", estacionMuestreo);
		return query.getSingleResult();
	}

	public static TipoMuestreo buscarTipoMuestreo(long idMetodo, EntityManager em) {
		
		TypedQuery<TipoMuestreo> query=em.createQuery("SELECT e FROM TipoMuestreo e WHERE e.idTipoMuestreo=:id ", TipoMuestreo.class).setParameter("id", idMetodo);
		return query.getSingleResult();
	}

	public static MetodoMuestreo buscarMetodoMuestreo(long idMetodo, EntityManager em) {
		
		TypedQuery<MetodoMuestreo> query=em.createQuery("SELECT e FROM MetodoMuestreo e WHERE e.idMetodo=:id ", MetodoMuestreo.class).setParameter("id", idMetodo);
		return query.getSingleResult();
	}
	
	public static List<Actividad> obtenerActividadesEstacionMuestreo(EntityManager em, Date fechaInicio, Date fechaFin,
			String nombreUsuario, String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento){
		String queryString = "SELECT a FROM Actividad a WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin";
		if(!nombreUsuario.isEmpty())
			queryString += " AND a.usuario.nombreUsuario=:nombreUsuario";
		if(!rolUsuario.isEmpty() && !rolUsuario.equals("Todos"))
			queryString += " AND a.usuario.rolesUsuario.rol=:rolUsuario";
		if(!metodoMuestreo.isEmpty() && !metodoMuestreo.equals("Todos"))
			queryString += " AND a.metodosMuestreo.nombre=:metodoMuestreo";
		if(!estacionMuestreo.isEmpty() && !estacionMuestreo.equals("Todos"))
			queryString += " AND a.estacionesMuestreo.nombre=:estacionMuestreo";
		if(!departamento.isEmpty() && !departamento.equals("Todos"))
			queryString += " AND a.departamento.nombre=:departamento";
		TypedQuery<Actividad> query = em.createQuery(queryString, Actividad.class)
				.setParameter("fechaInicio", fechaInicio, TemporalType.DATE)
				.setParameter("fechaFin", fechaFin, TemporalType.DATE);		
		if(!nombreUsuario.isEmpty())
			query.setParameter("nombreUsuario", nombreUsuario);
		if(!rolUsuario.isEmpty() && !rolUsuario.equals("Todos"))
			query.setParameter("rolUsuario", rolUsuario);
		if(!metodoMuestreo.isEmpty() && !metodoMuestreo.equals("Todos"))
			query.setParameter("metodoMuestreo", metodoMuestreo);
		if(!estacionMuestreo.isEmpty() && !estacionMuestreo.equals("Todos"))
			query.setParameter("estacionMuestreo", estacionMuestreo);
		if(!departamento.isEmpty() && !departamento.equals("Todos"))
			query.setParameter("departamento", departamento);
		List<Actividad> resultados = query.getResultList();
		return resultados;
	}
	
	public static List<Actividad> obtenerActividadesRangoFechas(EntityManager em, Date fechaInicio, Date fechaFin,
			String nombreUsuario, String rolUsuario, String metodoMuestreo, String estacionMuestreo, String departamento){
		String queryString = "SELECT a FROM Actividad a WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin";
		if(!nombreUsuario.isEmpty())
			queryString += " AND a.usuario.nombreUsuario=:nombreUsuario";
		if(!rolUsuario.isEmpty() && !rolUsuario.equals("Todos"))
			queryString += " AND a.usuario.rolesUsuario.rol=:rolUsuario";
		if(!metodoMuestreo.isEmpty() && !metodoMuestreo.equals("Todos"))
			queryString += " AND a.metodosMuestreo.nombre=:metodoMuestreo";
		if(!estacionMuestreo.isEmpty() && !estacionMuestreo.equals("Todos"))
			queryString += " AND a.estacionesMuestreo.nombre=:estacionMuestreo";
		if(!departamento.isEmpty() && !departamento.equals("Todos"))
			queryString += " AND a.departamento.nombre=:departamento";
		queryString += " ORDER BY a.departamento.nombre";
		TypedQuery<Actividad> query = em.createQuery(queryString, Actividad.class)
				.setParameter("fechaInicio", fechaInicio, TemporalType.DATE)
				.setParameter("fechaFin", fechaFin, TemporalType.DATE);		
		if(!nombreUsuario.isEmpty())
			query.setParameter("nombreUsuario", nombreUsuario);
		if(!rolUsuario.isEmpty() && !rolUsuario.equals("Todos"))
			query.setParameter("rolUsuario", rolUsuario);
		if(!metodoMuestreo.isEmpty() && !metodoMuestreo.equals("Todos"))
			query.setParameter("metodoMuestreo", metodoMuestreo);
		if(!estacionMuestreo.isEmpty() && !estacionMuestreo.equals("Todos"))
			query.setParameter("estacionMuestreo", estacionMuestreo);
		if(!departamento.isEmpty() && !departamento.equals("Todos"))
			query.setParameter("departamento", departamento);
		List<Actividad> resultados = query.getResultList();
		return resultados;
	}

	public static List<Actividad> listarActividadesCampoXForm(String nomU,Long idForm ,EntityManager em) {
		
		
		String consulta= "SELECT a FROM Actividad a WHERE formulario.id=:idFormu ";
		
		if(!nomU.isEmpty()) {
			consulta = consulta + "AND usuario.nombreUsuario=:nomUsu";
		}
		
		TypedQuery<Actividad> query= em.createQuery(consulta, Actividad.class).setParameter("idFormu", idForm);
		
		if(!nomU.isEmpty()) {
		query.setParameter("nomUsu", nomU );
		}
		
		
		return query.getResultList();
	}

}
