package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPOS_MUESTREO database table.
 * 
 */
@Entity
@Table(name="TIPOS_MUESTREO")
@NamedQuery(name="TipoMuestreo.findAll", query="SELECT t FROM TipoMuestreo t")
public class TipoMuestreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOS_MUESTREO_IDTIPOMUESTREO_GENERATOR", sequenceName="SEQ_ID_TIPO_MUESTREO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOS_MUESTREO_IDTIPOMUESTREO_GENERATOR")
	@Column(name="ID_TIPO_MUESTREO", unique=true, nullable=false, precision=38)
	private long idTipoMuestreo;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="tiposMuestreo")
	private List<Actividad> actividades;

	public TipoMuestreo() {
	}

	public long getIdTipoMuestreo() {
		return this.idTipoMuestreo;
	}

	public void setIdTipoMuestreo(long idTipoMuestreo) {
		this.idTipoMuestreo = idTipoMuestreo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Actividad> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Actividad addActividade(Actividad actividade) {
		getActividades().add(actividade);
		actividade.setTiposMuestreo(this);

		return actividade;
	}

	public Actividad removeActividade(Actividad actividade) {
		getActividades().remove(actividade);
		actividade.setTiposMuestreo(null);

		return actividade;
	}

}