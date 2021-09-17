package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UNIDADES_MEDIDA database table.
 * 
 */
@Entity
@Table(name="UNIDADES_MEDIDA")
@NamedQuery(name="UnidadMedida.findAll", query="SELECT u FROM UnidadMedida u")
public class UnidadMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIDADES_MEDIDA_IDUNIDADMEDIDA_GENERATOR", sequenceName="SEQ_ID_UNIDAD_MEDIDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIDADES_MEDIDA_IDUNIDADMEDIDA_GENERATOR")
	@Column(name="ID_UNIDAD_MEDIDA", unique=true, nullable=false, precision=38)
	private long idUnidadMedida;

	@Column(nullable=false, length=50,  unique=true)
	private String nombre;

	//bi-directional many-to-one association to Casilla
	@OneToMany(mappedBy="unidadesMedida")
	private List<Casilla> casillas;

	public UnidadMedida() {
	}

	public long getIdUnidadMedida() {
		return this.idUnidadMedida;
	}

	public void setIdUnidadMedida(long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Casilla> getCasillas() {
		return this.casillas;
	}

	public void setCasillas(List<Casilla> casillas) {
		this.casillas = casillas;
	}

	public Casilla addCasilla(Casilla casilla) {
		getCasillas().add(casilla);
		casilla.setUnidadesMedida(this);

		return casilla;
	}

	public Casilla removeCasilla(Casilla casilla) {
		getCasillas().remove(casilla);
		casilla.setUnidadesMedida(null);

		return casilla;
	}

}